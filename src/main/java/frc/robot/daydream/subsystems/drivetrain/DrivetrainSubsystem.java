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

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.daydream.subsystems.drivetrain.DrivetrainPolicy.DrivetrainSubsystemConstants;

public class DrivetrainSubsystem extends SubsystemBase {
    private CANSparkMax frontLeftMotor;
    private CANSparkMax backLeftMotor;
    private CANSparkMax frontRightMotor;
    private CANSparkMax backRightMotor;

    public DrivetrainSubsystem(){
        frontLeftMotor = new CANSparkMax(0, MotorType.kBrushless);
        backLeftMotor = new CANSparkMax(1, MotorType.kBrushless);
        frontRightMotor = new CANSparkMax(2, MotorType.kBrushless);
        backRightMotor = new CANSparkMax(3, MotorType.kBrushless);

        backLeftMotor.follow(frontLeftMotor);//frontLeftMotor is the leader
        backRightMotor.follow(frontRightMotor);//frontRightMotor is the leader

        frontLeftMotor.setInverted(true);
        frontRightMotor.setInverted(false);

    }

    public void run(){
        frontLeftMotor.set(DrivetrainSubsystemConstants.powerLeft);
        

    }

    public void retrieveEncoderPosition(){


    }

    public void retrieveEncoderVelocity(){


    }

}

