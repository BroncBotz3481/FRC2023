package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DrivetrainSubsystem extends SubsystemBase {
    private CANSparkMax frontLeftMotor;
    private CANSparkMax backLeftMotor;
    private CANSparkMax frontRightMotor;
    private CANSparkMax backRightMotor;

    public DrivetrainSubsystem(){
        frontLeftMotor = new CANSparkMax(0, MotorType.kBrushless);
        backLeftMotor = new CANSparkMax(0, MotorType.kBrushless);
        frontRightMotor = new CANSparkMax(0, MotorType.kBrushless);
        backRightMotor = new CANSparkMax(0, MotorType.kBrushless);

        backLeftMotor.follow(frontLeftMotor);//frontLeftMotor is the leader
        backRightMotor.follow(frontRightMotor);//frontRightMotor is the leader

        frontLeftMotor.setInverted(true);
        frontRightMotor.setInverted(false);

    }

    public void run(double powerLeft, double powerRight){
        frontLeftMotor.set(powerLeft);
        frontRightMotor.set(powerRight);
    }

    public double retrieveEncoderPosition(boolean leftSide){
        if(leftSide){
            RelativeEncoder encoder = frontLeftMotor.getEncoder();
            return encoder.getPosition();
            
        }
        RelativeEncoder encoder = frontRightMotor.getEncoder();
        return encoder.getPosition();

    }

    public double retrieveEncoderVelocity(boolean leftSide){
        if(leftSide){
            RelativeEncoder encoder = frontLeftMotor.getEncoder();
            return encoder.getVelocity();
        }
        RelativeEncoder encoder = frontRightMotor.getEncoder();
        return encoder.getVelocity();
    }

}

