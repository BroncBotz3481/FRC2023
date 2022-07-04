package frc.robot.subsystems.Daydream;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

    private CANSparkMax Left0;
    private CANSparkMax Left1;
    private CANSparkMax Right0;
    private CANSparkMax Right1;

    public DriveSubsystem() {
        configureSubsystem();        
    }

    public void driveByPower(double leftPower, double rightPower) {
        Left0.set(leftPower);
        Right0.set(rightPower);
    }

    private void configureSubsystem() {
        // TODO: Verify motor IDs
        // TODO: Move motor ID's to Conastants.java
        Left0 = new CANSparkMax(0, MotorType.kBrushless);
        Left1 = new CANSparkMax(1, MotorType.kBrushless);
        Right0 = new CANSparkMax(2, MotorType.kBrushless);
        Right1 = new CANSparkMax(3, MotorType.kBrushless);

        Left0.setInverted(true);
        Left1.setInverted(true);
        Right1.setInverted(false);
        Right0.setInverted(false);

        Left1.follow(Left0);
        Right1.follow(Right0);

        //TODO: Encoder setup (See Example code)
    }
}
