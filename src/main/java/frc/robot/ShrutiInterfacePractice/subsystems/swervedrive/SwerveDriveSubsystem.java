/*package frc.robot.ShrutiInterfacePractice.subsystems.swervedrive;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import com.ctre.phoenix.sensors.PigeonIMU;
import com.swervedrivespecialties.swervelib.Mk3SwerveModuleHelper;
import com.swervedrivespecialties.swervelib.SwerveModule;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

class SwerveDrivePolicy{

    private MotorController runningMotor, angleMotor;
    private double angle, speed;

    private SwerveDrivePolicy(MotorController r, MotorController a){

        


    }

    public void setAngle(){



    }

    public void setSpeed(){



    }

    public void resetAngle(){



    }

}


public class SwerveDriveSubsystem extends SubsystemBase {
    
    private final SwerveModule frontLeftModule;
    private final SwerveModule frontRightModule;
    private final SwerveModule backLeftModule;
    private final SwerveModule backRightModule;
    
    private SwerveDrivePolicy angModule;



    public SwerveDriveSubsystem(){
        frontLeftMotor = new SwerveDriveModule(0, MotorType.kBrushless);
        backLeftMotor = new CANSparkMax(0, MotorType.kBrushless);
        frontRightMotor = new CANSparkMax(0, MotorType.kBrushless);
        backRightMotor = new CANSparkMax(0, MotorType.kBrushless);

        backLeftMotor.follow(frontLeftMotor);//frontLeftMotor is the leader
        backRightMotor.follow(frontRightMotor);//frontRightMotor is the leader

        frontLeftMotor.setInverted(true);
        frontRightMotor.setInverted(false); */

        //frontLeftModule = new SwerveModule()
       // ShuffleboardTab shuffleboardTab = Shuffleboard.getTab("Drivetrain");


   // } 

 /*   public void run(double powerLeft, double powerRight){
    
        
    }

    public void retrieveEncoderPosition(boolean leftSide){
        

    }

    public void retrieveEncoderVelocity(){
        
    }

    public void resetAngle(){



    }


    public void getAngle() {



    }

} */

