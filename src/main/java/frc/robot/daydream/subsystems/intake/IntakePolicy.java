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

package frc.robot.daydream.subsystems.intake;

import frc.robot.daydream.subsystems.index.IndexPolicy;

public class IntakePolicy {

    public static double intakePower; // power for motors
    // public static boolean isUpIntake; //whether the intake is up or not

    public static double getIntakePower() {
        if (IndexPolicy.indexFull()) {
            IntakePolicy.intakePower = 0;
        }
        return IntakePolicy.intakePower;
    }

}
