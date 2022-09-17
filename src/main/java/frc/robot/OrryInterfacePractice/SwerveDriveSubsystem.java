package frc.robot.OrryInterfacePractice;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveDriveSubsystem extends SubsystemBase {
    private final CANSparkMax frontLeftMotor;
    private final CANSparkMax backLeftMotor;
    private final CANSparkMax frontRightMotor;
    private final CANSparkMax backRightMotor;

    public SwerveDriveSubsystem() {
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

    }

    public void retrieveEncoderPosition(boolean leftSide) {

    }

    public void retrieveEncoderVelocity(boolean leftSide) {

    }

    private class SwerveModule {
        public double speed;
        public double angle;

        public SwerveModule(MotorController runningMotor, MotorController angledMotor) {

        }

        public void setAngle() {

        }

        public void resetAngle() {

        }

        public void setSpeed() {

        }
    }


}

