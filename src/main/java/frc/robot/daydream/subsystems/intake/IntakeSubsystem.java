/****************************** Header ******************************\
Class Name: IntakeSubsystem extends SubsystemBase
File Name: IntakeSubsystem.java
Summary: An example subsystem to use for learning and testing.
Project: BroncBotzFRC2023
Copyright (c) BroncBotz.
All rights reserved.

Author(s): Shruti Venkat and Samuel Zhao
Email: shruti.venkat05@gmail.com
\********************************************************************/
package frc.robot.daydream.subsystems.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.daydream.subsystems.index.IndexPolicy;
import frc.robot.daydream.subsystems.intake.IntakePolicy;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class IntakeSubsystem extends SubsystemBase {

  public VictorSPX intakeMotor; 
  public DoubleSolenoid piston;

  public IntakeSubsystem() {
    intakeMotor = new VictorSPX(0); 
    piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 1);  
  }
  
  public void runMotor() {
   
    intakeMotor.set(ControlMode.PercentOutput, IntakePolicy.intakePower);

  }
  public void stopMotor() {
     
    intakeMotor.set(ControlMode.PercentOutput, 0);

  }

  public void drop() {

    piston.set(Value.kForward);

  }

  public void raise() {
      piston.toggle();

    }
  }
  

