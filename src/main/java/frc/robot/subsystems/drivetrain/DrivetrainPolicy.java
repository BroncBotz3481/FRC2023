/****************************** Header ******************************\
 Class Name: DriveTrain
 File Name: Drivetrain.java
 Summary: Contains constant subclasses and variables for commands, subsystems, and utility methods
 Project: BroncBotzFRC2023
 Copyright (c) BroncBotz.
 All rights reserved.

 Author(s): Samuel Zhao and Shruti Venkat
 Email: Shruti.venkat05@gmail.com
 \********************************************************************/

package frc.robot.subsystems.drivetrain;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import frc.robot.Constants;

public final class DrivetrainPolicy {
    public static double powerLeft; // power for left motors
    public static double powerRight; // power for right motors
    public static double forwardPowerScale = 0.85;
    public static double backwardPowerScale = 0.7;
    private static Rotation2d gyroAngle = new Rotation2d(0);
    private static Pose2d initialPoseMeters = new Pose2d(0, 0, gyroAngle);
    public static DifferentialDriveOdometry driveOdometry = new DifferentialDriveOdometry(gyroAngle, initialPoseMeters);
    public static DifferentialDriveKinematics driveKinematics; //TODO: INITIALIZE THIS OBJECT PLEASE
    public static double rightSpeed;
    public static double leftSpeed;

    public static double rightEncoder;

    public static double leftEncoder;

    public static double rightEncoderPosition = 0, rightEncoderVelocity = 0;
    public static double leftEncoderPosition = 0, leftEncoderVelocity = 0;

    public static Pose2d position ;



//For Orry
    
    //RPM
    public static double getRightVelocity() {
        return ((DrivetrainPolicy.rightSpeed * 60) / (Math.PI * Constants.wheelDiameter));
    }
    //RPM
    public static double getLeftVelocity() {
        return ((DrivetrainPolicy.leftSpeed * 60) / (Math.PI * Constants.wheelDiameter));

    }

     /*public static void  UpdateEncoderPosition(double leftEncoder, double rightEncoder)
     {
         leftEncoder = leftEncoderPosition;
         rightEncoder = rightEncoderPosition;

     } */


    public static double setPowerScale() {

        if (powerLeft > 0 && powerRight > 0) {
            return backwardPowerScale; //backward speed
        }
        return forwardPowerScale; //forward speed

    }


}
