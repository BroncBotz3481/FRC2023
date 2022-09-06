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

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.daydream.subsystems.index.IndexPolicy;

import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.ExampleSubsystemConstants;
import frc.robot.daydream.subsystems.shooter.ShooterPolicy;
public class ShooterSubsystem extends SubsystemBase {

  public TalonSRX shooterMotor; 
  public DigitalInput pressurePad;
  
  public ShooterSubsystem() {
    shooterMotor = new TalonSRX(1);
    pressurePad = new DigitalInput(12);
  }
  
  // This could be "runintake" or "stopintake" or "liftclimber"



  public void shoot(){
    
    shooterMotor.set(ControlMode.PercentOutput, ShooterPolicy.powerShooter);
  }

  // DON'T WORRY ABOUT periodic() and simulationPeriodic() right now
  @Override
  public void periodic() {
    IndexPolicy.pressurePadSet = pressurePad.get();
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
