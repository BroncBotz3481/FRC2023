package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Daydream.ShooterSubsystem;

public class HighShot extends CommandBase {

    private ShooterSubsystem Shooter;

    public HighShot(ShooterSubsystem shooter) {
        addRequirements(shooter);
        Shooter = shooter;
    }

    @Override
    public void execute() {
        Shooter.setPIDVelocity(12400);
    }
}
