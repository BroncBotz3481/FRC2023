package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Daydream.ShooterSubsystem;

public class LowShot extends CommandBase {

    private ShooterSubsystem Shooter;

    public LowShot(ShooterSubsystem shooter) {
        addRequirements(shooter);
        Shooter = shooter;
    }

    @Override
    public void execute() {
        Shooter.setPIDVelocity(12100/1.75);
    }
}
