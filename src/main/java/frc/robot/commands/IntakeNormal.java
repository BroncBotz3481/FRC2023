package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Daydream.IntakeSubsystem;

public class IntakeNormal extends CommandBase {
    
    private final IntakeSubsystem Intake;

    private double m_previousPower;
    private double m_maximumPower;

    public IntakeNormal(IntakeSubsystem intake) {
        Intake = intake;
        addRequirements(intake);
        m_previousPower = 0.0;
        m_maximumPower = 0.65; // TODO: Move this to Constants
    }

    @Override
    public void execute() {
        if(m_previousPower < m_maximumPower)
            m_previousPower += 0.05;
        if(m_previousPower > m_maximumPower)
            m_previousPower = m_maximumPower;

        Intake.setIntakePower(m_previousPower);
    }
}
