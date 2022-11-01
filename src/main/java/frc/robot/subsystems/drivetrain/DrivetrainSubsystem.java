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

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    private final CANSparkMax frontLeftMotor;
    private final CANSparkMax backLeftMotor;
    private final CANSparkMax frontRightMotor;
    private final CANSparkMax backRightMotor;

    private final RelativeEncoder leftEncoder;
    private final RelativeEncoder rightEncoder;

    private final DifferentialDrive driveTrain;

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
        System.out.println("Are there errors here in DrivetrainSubsystem?");
    }

    public void run(double leftPower, double rightPower) {
        DrivetrainPolicy.powerLeft = leftPower;
        DrivetrainPolicy.powerRight = rightPower;
        driveTrain.tankDrive(DrivetrainPolicy.powerLeft * DrivetrainPolicy.setPowerScale(), DrivetrainPolicy.powerRight * DrivetrainPolicy.setPowerScale());
        
        // frontLeftMotor.set(Driver);

    }

    @Override
    public void periodic() {
        
        //DrivetrainPolicy.UpdateEncoderPositions(leftEncoder.getPosition(), rightEncoder.getPosition());
        DrivetrainPolicy.rightEncoderPosition = rightEncoder.getPosition();
        DrivetrainPolicy.rightEncoderVelocity = rightEncoder.getVelocity();
        DrivetrainPolicy.leftEncoderPosition = leftEncoder.getPosition();
        DrivetrainPolicy.leftEncoderVelocity = leftEncoder.getVelocity();
    }

}

