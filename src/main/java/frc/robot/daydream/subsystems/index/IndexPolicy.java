/****************************** Header ******************************\
Class Name: IntakePolicyClass 
File Name: IntakePolicy.java
Summary: Contains constant subclasses and variables for commands, subsystems, and utility methods 
Project: BroncBotzFRC2023
Copyright (c) BroncBotz.
All rights reserved.

Author(s): Shruti Venkat and Samuel Zhao
Email: Shruti.venkat05@gmail.com
\********************************************************************/

package frc.robot.daydream.subsystems.index;

public class IndexPolicy {
    public static double Indexpower; // power for motors
    public static boolean isShooting;
    public static boolean pressurePadSet;

    public static boolean indexFull() {
        return pressurePadSet;
    }

    public static double getIndexPower() {
        if (indexFull()) {
            IndexPolicy.Indexpower = 0;
        }
        return IndexPolicy.Indexpower;
    }
}
