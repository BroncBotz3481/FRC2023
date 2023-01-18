package frc.robot.subsystems.wrist;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WristSubsystem extends SubsystemBase {
    private final CANSparkMax wristMotor;

    public WristSubsystem() {
        wristMotor = new CANSparkMax(4,MotorType.kBrushless);
    }

    public void runWrist(double power) {
        WristPolicy.powerWrist = power; 
        wristMotor.set(WristPolicy.powerWrist);
    }

    public void stopRightMotor() {
        runWrist(0);;
    }

}
