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
    public static double indexPower; // power for motors
    public static boolean overridePressurePad;
    public static int pressurePadSet;

    public static boolean indexFull() {
        if(pressurePadSet >= 100){
            return false;
        
        }
        else if(pressurePadSet < 10){
           return true;
        }  
        return false;
    }   

    public static double getIndexPower() {
        if (indexFull()) {
            if(overridePressurePad){
                return IndexPolicy.indexPower;
            }
            else{
                IndexPolicy.indexPower=0;
            }
        }
        return IndexPolicy.indexPower;
    }
}

