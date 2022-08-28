/****************************** Header ******************************\
Class Name: IndexSubsystem extends SubsystemBase
File Name: IndexSubsystem.java
Summary: Practice
Project: BroncBotzFRC2023
Copyright (c) BroncBotz.
All rights reserved.

Author(s): Shruti Venkat and Samuel Zhao
Email: shruti.venkat05@gmail.com
\********************************************************************/
package frc.robot.daydream.subsystems.index;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ExampleSubsystemConstants;

public class IndexSubsystem extends SubsystemBase {

  public VictorSPX Indexmotor; // This is the motor controller
  public DigitalInput pressurePad;

  //public static boolean isPressed; //if pressure pad is pressed or not

  /** Creates a new ExampleSubsystem. */
  public IndexSubsystem() {
    Indexmotor = new VictorSPX(1); // Create the new motor controller (make sure you check your ID!)
    
  }
  
  // This could be "runintake" or "stopintake" or "liftclimber"
  public void runIndex(double Indexpower, Boolean isShooting) {
   

  }


  public void stopIndex() {
    runIndex(0, false); 


  }
}
