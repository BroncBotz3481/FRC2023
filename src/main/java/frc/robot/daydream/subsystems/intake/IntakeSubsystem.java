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
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


import edu.wpi.first.wpilibj.DoubleSolenoid;

public class IntakeSubsystem extends SubsystemBase {

  public VictorSPX intakeMotor; 
  public DoubleSolenoid piston;

  public IntakeSubsystem() {
    intakeMotor = new VictorSPX(0); 
  }
  
  public void runMotor() {
   


  }
  public void stopMotor() {
     


  }

  public void drop() {



  }

  public void raise() {



  }
  
}
