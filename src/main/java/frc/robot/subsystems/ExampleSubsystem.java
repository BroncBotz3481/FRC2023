// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// Adapted by Dylan Watson

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
  
  public VictorSPX motor; // This is the motor controller
  
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    motor = new VictorSPX(0); // Create the new motor controller (make sure you check your ID!)
  }
  // This could be "runintake" or "stopintake" or "liftclimber"
  public void runMotor(double power) {
    motor.set(ControlMode.PercentOutput, power); // This is how you set power to a VictorSPX or a TalonSRX
  }
  //aidulhfjanlrhing
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
