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

public final class DrivetrainPolicy {
    public static double powerLeft; // power for left motors
    public static double powerRight; // power for right motors
    public static double forwardPowerScale = 0.85;
    public static double backwardPowerScale = 0.7;
    public static double rightEncoderPosition, rightEncoderVelocity,
            leftEncoderPosition, leftEncoderVelocity;


    public static double setPowerScale()
    {
        
        if(powerLeft > 0 && powerRight > 0)
        {
            return backwardPowerScale; //backward speed
        }
        return forwardPowerScale; //forward speed

    }


}
