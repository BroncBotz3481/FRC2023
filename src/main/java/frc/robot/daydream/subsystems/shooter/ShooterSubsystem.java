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
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

  public VictorSPX shooterMotorLeft; 
  public TalonSRX shooterMotorRight;
  
  public ShooterSubsystem() {
    shooterMotorLeft = new VictorSPX(2);
    shooterMotorRight = new TalonSRX(1);
  }
  
  // This could be "runintake" or "stopintake" or "liftclimber"

  public void shoot(){
    shooterMotorRight.set(ControlMode.PercentOutput, ShooterPolicy.getShooterPower());
    shooterMotorLeft.set(ControlMode.PercentOutput, ShooterPolicy.getShooterPower());
  }

  public void stopShooter()
  {
    ShooterPolicy.powerShooter = 0;
    shoot();
  }

  @Override
  public void periodic()
  {
    if(ShooterPolicy.shootReady())
    {
      shoot();
    }
  }

}
