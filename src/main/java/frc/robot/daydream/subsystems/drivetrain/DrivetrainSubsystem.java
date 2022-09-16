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


package frc.robot.daydream.subsystems.drivetrain;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.daydream.subsystems.drivetrain.DrivetrainPolicy;

public class DrivetrainSubsystem extends SubsystemBase {
    private CANSparkMax frontLeftMotor;
    private CANSparkMax backLeftMotor;
    private CANSparkMax frontRightMotor;
    private CANSparkMax backRightMotor;

    private RelativeEncoder leftEncoder, rightEncoder;

    private DifferentialDrive driveTrain;
    
    public DrivetrainSubsystem(){
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
        System.out.println("Are there errors here in DrivetrainSubsystem?");    
    }

    public void run(){
        System.out.println("AM I RUNNING!!!");
        System.out.println(DrivetrainPolicy.powerLeft);
        System.out.println(DrivetrainPolicy.powerRight);
        driveTrain.tankDrive(DrivetrainPolicy.powerLeft * 0.5, DrivetrainPolicy.powerRight * 0.5);
        // frontLeftMotor.set(Driver);
        
    }

    @Override
    public void periodic()
    {
        DrivetrainPolicy.rightEncoderPosition = rightEncoder.getPosition();
        DrivetrainPolicy.rightEncoderVelocity = rightEncoder.getVelocity();
        DrivetrainPolicy.leftEncoderPosition = leftEncoder.getPosition();
        DrivetrainPolicy.leftEncoderVelocity = leftEncoder.getVelocity();
    }

}

