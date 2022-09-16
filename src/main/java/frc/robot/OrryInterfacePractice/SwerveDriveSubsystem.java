package frc.robot.OrryInterfacePractice;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class SwerveDriveSubsystem extends SubsystemBase {
    private class SwerveModule {
    public double speed;
    public double angle;

    public void setAngle(){

    }

    public void resetAngle(){

    }

    public void setSpeed(){

    }
    
    public SwerveModule(MotorController runningMotor, MotorController angledMotor){

    }
}

    private CANSparkMax frontLeftMotor;
    private CANSparkMax backLeftMotor;
    private CANSparkMax frontRightMotor;
    private CANSparkMax backRightMotor;

    public SwerveDriveSubsystem(){
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
        
    }

    public void retrieveEncoderPosition(boolean leftSide){
       
    }

    public void retrieveEncoderVelocity(boolean leftSide){
       
    }


}

