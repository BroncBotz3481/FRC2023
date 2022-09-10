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

package frc.robot.daydream.subsystems.drivetrain;
import edu.wpi.first.wpilibj.Timer;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class DrivetrainPolicy {
        public static double powerLeft; //power for left motors
        public static double powerRight; //power for right motors
        public static boolean leftSide;  //the complete left side of the robot
        public static Timer time;

        public static double rightEncoderPosition, rightEncoderVelocity,
                                leftEncoderPosition, leftEncoderVelocity;

}
