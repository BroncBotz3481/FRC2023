/****************************** Header ******************************\
 Class Name: IntakeModule [final]
 File Name: IntakeModule.java
 Summary: Contains constant subclasses and variables for commands, subsystems, and utility methods
 Project: BroncBotzFRC2023
 Copyright (c) BroncBotz.
 All rights reserved.

 Author(s): Shruti Venkat and Samuel Zhao
 Email: Shruti.venkat05@gmail.com
 \********************************************************************/

package frc.robot.subsystems.shooter;

import frc.robot.subsystems.index.IndexPolicy;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class ShooterPolicy {
    public static double powerShooter;
    public static double targetSpeed;
    public static double encoderVelocity;
    public static double getShooterPower() {
        /*if (IndexPolicy.indexFull() && ShooterPolicy.powerShooter <= 0) { //logic for ramping shooter when ball is on pressurepad is flawed
            ShooterPolicy.powerShooter = 0.1;
        } */
        return ShooterPolicy.powerShooter;
    } 


    public static boolean shootReady() {
        return IndexPolicy.indexFull();
    }
    public static boolean inBound(double boundary){
        if(ShooterPolicy.encoderVelocity > targetSpeed - boundary && ShooterPolicy.encoderVelocity < targetSpeed + boundary)
        {
            IndexPolicy.overridePressurePad = true;
            return true;
        }
        else{
             IndexPolicy.overridePressurePad = false;
             return false;

        }
    }
}
