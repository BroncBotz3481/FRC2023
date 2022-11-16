/****************************** Header ******************************\
 Class Name: DrivetrainSubsystem extends SubsystemBase
 File Name: DrivetrainSubsystem.java
 Summary: Contains constant subclasses and variables for commands, subsystems, and utility methods
 Project: BroncBotzFRC2023
 Copyright (c) BroncBotz.
 All rights reserved.

 Author(s): Samuel Zhao and Shruti Venkat
 Email: Shruti.venkat05@gmail.com and samuelzhao0714@gmail.com
 \********************************************************************/


package frc.robot.subsystems.drivetrain;
//hello

import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;
import edu.wpi.first.wpilibj.shuffleboard.SuppliedValueWidget;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    private final CANSparkMax frontLeftMotor;
    private final CANSparkMax backLeftMotor;
    private final CANSparkMax frontRightMotor;
    private final CANSparkMax backRightMotor;

    private final RelativeEncoder leftEncoder;
    private final RelativeEncoder rightEncoder;

    private final DifferentialDrive driveTrain;

    private SparkMaxPIDController leftPIDController;
    private SparkMaxPIDController rightPIDController;


    public DrivetrainSubsystem() {
        frontLeftMotor = new CANSparkMax(4, MotorType.kBrushless);
        backLeftMotor = new CANSparkMax(3, MotorType.kBrushless);
        frontRightMotor = new CANSparkMax(1, MotorType.kBrushless);
        backRightMotor = new CANSparkMax(2, MotorType.kBrushless);

        backLeftMotor.follow(frontLeftMotor);//frontLeftMotor is the leader
        backRightMotor.follow(frontRightMotor);//frontRightMotor is the leader

        frontRightMotor.setInverted(false);
        frontLeftMotor.setInverted(true);

        leftEncoder = frontLeftMotor.getEncoder();
        rightEncoder = frontRightMotor.getEncoder();


        driveTrain = new DifferentialDrive(frontLeftMotor, frontRightMotor);

        leftPIDController = frontLeftMotor.getPIDController();
        leftPIDController = frontRightMotor.getPIDController();

        this.setPIDF(0, 0, 0, 0, 200);
        this.setOutputRange(-1,1);
    }

    private void setOutputRange(int i, int j) {
    }

    public void setPIDF(double P, double I, double D, double F, double integralZone){
        leftPIDController.setP(P);
        leftPIDController.setI(I);
        leftPIDController.setD(D);
        leftPIDController.setFF(F);
        leftPIDController.setIZone(integralZone);

        rightPIDController.setP(P);
        rightPIDController.setI(I);
        rightPIDController.setD(D);
        rightPIDController.setFF(F);
        rightPIDController.setIZone(integralZone);
    }

    public void run(double powerLeft, double powerRight) {
        DrivetrainPolicy.powerLeft = powerLeft;
        DrivetrainPolicy.powerRight = powerRight;
        driveTrain.tankDrive(DrivetrainPolicy.powerLeft * DrivetrainPolicy.setPowerScale(), DrivetrainPolicy.powerRight * DrivetrainPolicy.setPowerScale());

    }
//For Orry
    public void set(double leftspeed, double rightspeed) {

        DrivetrainPolicy.leftSpeed = leftspeed;
        DrivetrainPolicy.rightSpeed = rightspeed;

        leftPIDController.setReference(DrivetrainPolicy.getLeftVelocity(),ControlType.kVelocity);
        rightPIDController.setReference(DrivetrainPolicy.getRightVelocity(), ControlType.kVelocity);
    }

    public void setGearRatio(double gearRatio) {
        leftEncoder.setVelocityConversionFactor(gearRatio);
        rightEncoder.setVelocityConversionFactor(gearRatio);
        leftEncoder.setPositionConversionFactor(gearRatio);
        rightEncoder.setPositionConversionFactor(gearRatio);


    }

    @Override
    public void periodic() {
        DrivetrainPolicy.rightEncoderPosition = rightEncoder.getPosition();
        DrivetrainPolicy.rightEncoderVelocity = rightEncoder.getVelocity();
        DrivetrainPolicy.leftEncoderPosition = leftEncoder.getPosition();
        DrivetrainPolicy.leftEncoderVelocity = leftEncoder.getVelocity();

    }
}

