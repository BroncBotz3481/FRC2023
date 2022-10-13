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


package frc.robot.commands.shooterCommand;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.index.IndexPolicy;
import frc.robot.subsystems.index.IndexSubsystem;
import frc.robot.subsystems.shooter.ShooterPolicy;
import frc.robot.subsystems.shooter.ShooterSubsystem;

/**
 * An example command that uses an example subsystem.
 */
public class LowShotCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final ShooterSubsystem m_shooterSubsystem;
    private final IndexSubsystem m_indexSubsystem;
    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public LowShotCommand(ShooterSubsystem subsystem, IndexSubsystem isubsystem) {
        m_shooterSubsystem = subsystem;
        m_indexSubsystem = isubsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
        addRequirements(isubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        IndexPolicy.overridePressurePad = true;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        m_shooterSubsystem.shootPID(8200);
        if(ShooterPolicy.inBound(250)){
            m_indexSubsystem.runIndex(-0.65);
        }
        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        IndexPolicy.overridePressurePad = false;
        m_shooterSubsystem.stopShooter();

    }


    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
