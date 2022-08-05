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


    public void runEitherSide(double power, boolean runLeftSide){
        if(runLeftSide){
            frontLeftMotor.set(power);
        }
        frontRightMotor.set(power);
    }

    public Object retrieveEncoderPosition(boolean leftSide){
        if(leftSide){
            RelativeEncoder position = frontLeftMotor.getEncoder();
            return position.getPosition();
            
        }
        RelativeEncoder position = frontRightMotor.getEncoder();
        return position.getPosition();

    }

    public Object retrieveEncoderVelocity(boolean leftSide){
        if(leftSide){
            RelativeEncoder position = frontLeftMotor.getEncoder();
            return position.getVelocity();
        }
        RelativeEncoder position = frontRightMotor.getEncoder();
        return position.getVelocity();
    }

}

