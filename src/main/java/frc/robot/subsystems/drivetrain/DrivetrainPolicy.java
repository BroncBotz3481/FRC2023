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
    public static double powerScale;
    public static boolean Overdrive;

    
    
    public static double rightEncoderPosition, rightEncoderVelocity,
            leftEncoderPosition, leftEncoderVelocity;


    public static double setPowerScale()
    {
        if(Overdrive)
        {
            return 1.0;
        }

        else if(powerLeft > 0 && powerRight > 0)
        {
            return 0.6;  //backward speed
        }

        return 0.7; //forward speed

    }


}
