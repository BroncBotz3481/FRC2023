/****************************** Header ******************************\
Class Name: ExampleSubsystem extends SubsystemBase
File Name: ExampleSubsystem.java
Summary: An example subsystem to use for learning and testing.
Project: BroncBotzFRC2023
Copyright (c) BroncBotz.
All rights reserved.

Author(s): Dylan Watson
Email: dylantrwatson@gmail.com
\********************************************************************/
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ExampleSubsystemConstants;

public class ExampleSubsystem extends SubsystemBase {
  // EXAMPLE COMMENT
  public VictorSPX motor; // This is the motor controller
  
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    motor = new VictorSPX(0); // Create the new motor controller (make sure you check your ID!)
    System.out.println(ExampleSubsystemConstants.testConstant); // Example of how to use the "Constants" class and subclasses
  }
  
  // This could be "runintake" or "stopintake" or "liftclimber"
  public void runMotor(double power) {
    motor.set(ControlMode.PercentOutput, power); // This is how you set power to a VictorSPX or a TalonSRX
  }

  public void stopMotor() {
    runMotor(0); // motor.set(ControlMode.PercentOutput, 0)
  }

  // DON'T WORRY ABOUT periodic() and simulationPeriodic() right now
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
