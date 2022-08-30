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
package frc.robot.ShrutiInterfacePractice.subsystems.shooter;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.ExampleSubsystemConstants;
public class ShooterSubsystem extends SubsystemBase {

  public CANSparkMax turret;
  public CANSparkMax shooter; 
  public DoubleSolenoid hood; // This is the motor controller
  
  /** Creates a new ExampleSubsystem. */
  public ShooterSubsystem() {
    turret = new CANSparkMax(0, MotorType.kBrushless); // Create the new motor controller (make sure you check your ID!)
    shooter = new CANSparkMax(0, MotorType.kBrushless);
    System.out.println(ExampleSubsystemConstants.testConstant); // Example of how to use the "Constants" class and subclasses
  }
  
  // This could be "runintake" or "stopintake" or "liftclimber"
  public void SetHoodAngle() {

  }

  public void shoot() {

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
