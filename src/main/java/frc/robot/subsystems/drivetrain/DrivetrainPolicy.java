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
import frc.robot.Constants;
import frc.robot.subsystems.drivetrain.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public final class DrivetrainPolicy {
    public static double powerLeft; // power for left motors
    public static double powerRight; // power for right motors
    public static double forwardPowerScale = 0.85;
    public static double backwardPowerScale = 0.7;
    public static DifferentialDrive driveOdometry;
    public static DifferentialDrive driveKinematics;
    public static double rightSpeed;
    public static double rightEncoderPosition, rightEncoderVelocity,
    leftEncoderPosition, leftEncoderVelocity;
    
    rightEncoderVelocity = (rightEncoder.getVelocity() / 60) * Constants.wheelDiameter * Math.PI;
    leftEncoderVelocity = (rightEncoder.getVelocity() / 60) * Constants.wheelDiameter * Math.PI;


    public static double getRightVelocity()
    {
        return ((DrivetrainPolicy.rightSpeed * 60) / (Math.PI * Constants.wheelDiameter));
    }



    
  

  
    public static double setPowerScale()
    {
        
        if(powerLeft > 0 && powerRight > 0)
        {
            return backwardPowerScale; //backward speed
        }
        return forwardPowerScale; //forward speed

    }


}
