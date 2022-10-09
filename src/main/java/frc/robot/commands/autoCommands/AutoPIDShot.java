/****************************** Header ******************************\
 Class Name: ExampleCommand extends CommandBase
 File Name: ExampleCommand.java
 Summary: An example command to use for learning and testing.
 Project: BroncBotzFRC2023
 Copyright (c) BroncBotz.
 All rights reserved.

 Author(s): Dylan Watson
 Email: dylantrwatson@gmail.com
 \********************************************************************/


package frc.robot.commands.autoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.index.IndexPolicy;
import frc.robot.subsystems.index.IndexSubsystem;
import frc.robot.subsystems.shooter.ShooterPolicy;
import frc.robot.subsystems.shooter.ShooterSubsystem;
import edu.wpi.first.wpilibj.Timer;

/**
 * An example command that uses an example subsystem.
 */
public class AutoPIDShot extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final ShooterSubsystem m_shooterSubsystem;
    private Timer time;
    private final IndexSubsystem m_indexSubsystem;
    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public AutoPIDShot(ShooterSubsystem subsystem, IndexSubsystem isubsystem) {
        m_shooterSubsystem = subsystem;
        m_indexSubsystem = isubsystem;
        time = new Timer();
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
        addRequirements(isubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        time.start();
        IndexPolicy.overridePressurePad = true;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        //ShooterPolicy.targetSpeed = 12000;
        ShooterPolicy.targetSpeed = 12300;
        m_shooterSubsystem.shootPID();
        if(ShooterPolicy.inBound(150)){
            m_indexSubsystem.runIndex(-0.4);
        }
        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        time.stop();
        time.reset();
        IndexPolicy.overridePressurePad = false;
        m_shooterSubsystem.stopShooter();

    }


    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if(time.get()>=4){
            System.out.println("Is this running?");
            return true;
        }
        return false;
    }
}
