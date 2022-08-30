/****************************** Header ******************************\
Class Name: ShooterSubsystem extends SubsystemBase
File Name: ExampleSubsystem.java
Summary: An example subsystem to use for learning and testing.
Project: BroncBotzFRC2023
Copyright (c) BroncBotz.
All rights reserved.

Author(s): Shruti Venkat and Samuel Zhao
Email: Shruti.venkat@gmail.com
\********************************************************************/
package frc.robot.daydream.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.ExampleSubsystemConstants;
public class ShooterSubsystem extends SubsystemBase {

  public TalonSRX turret;
  public TalonSRX shooter; 
  public DoubleSolenoid hood; 
  
  public ShooterSubsystem() {
    turret = new TalonSRX(0); // Created the new Talon motor controller 
    shooter = new TalonSRX(1);
    
  }
  
  // This could be "runintake" or "stopintake" or "liftclimber"
  public void SetHoodAngle(double angle) {

  }

  public void getVelocity(double rpm){



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
