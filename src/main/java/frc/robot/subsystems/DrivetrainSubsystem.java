package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    private final CANSparkMax frontLeftMotor;
    private final CANSparkMax backLeftMotor;
    private final CANSparkMax frontRightMotor;
    private final CANSparkMax backRightMotor;

    public DrivetrainSubsystem() {
        frontLeftMotor = new CANSparkMax(0, MotorType.kBrushless);
        backLeftMotor = new CANSparkMax(0, MotorType.kBrushless);
        frontRightMotor = new CANSparkMax(0, MotorType.kBrushless);
        backRightMotor = new CANSparkMax(0, MotorType.kBrushless);

        backLeftMotor.follow(frontLeftMotor);//frontLeftMotor is the leader
        backRightMotor.follow(frontRightMotor);//frontRightMotor is the leader

        frontLeftMotor.setInverted(true);
        frontRightMotor.setInverted(false);

    }

    public void run(double powerLeft, double powerRight) {
        frontLeftMotor.set(powerLeft);
        frontRightMotor.set(powerRight);
    }

    public double retrieveEncoderPosition(boolean leftSide) {
        if (leftSide) {
            RelativeEncoder encoder = frontLeftMotor.getEncoder();
            return encoder.getPosition();

        }
        RelativeEncoder encoder = frontRightMotor.getEncoder();
        return encoder.getPosition();

    }

    public double retrieveEncoderVelocity(boolean leftSide) {
        if (leftSide) {
            RelativeEncoder encoder = frontLeftMotor.getEncoder();
            return encoder.getVelocity();
        }
        RelativeEncoder encoder = frontRightMotor.getEncoder();
        return encoder.getVelocity();
    }

}

