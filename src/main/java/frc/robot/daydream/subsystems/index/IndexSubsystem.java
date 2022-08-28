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
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ExampleSubsystemConstants;
public class IndexSubsystem extends SubsystemBase {

  public CANSparkMax motor; // This is the motor controller
  
  
  /** Creates a new ExampleSubsystem. */
  public IndexSubsystem() {
    motor = new CANSparkMax(0, MotorType.kBrushless); // Create the new motor controller (make sure you check your ID!)
    System.out.println(ExampleSubsystemConstants.testConstant); // Example of how to use the "Constants" class and subclasses
  }
  
  // This could be "runintake" or "stopintake" or "liftclimber"
  public void runIndex(double power, Boolean isShooting) {
   

  }

  public void stopIndex() {
    runIndex(0, false); 


  }
}
