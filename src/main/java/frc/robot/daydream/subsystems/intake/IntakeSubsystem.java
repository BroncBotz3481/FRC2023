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
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants.ExampleSubsystemConstants;
//import com.qualcomm.robotcore.hardware.TouchSensor;

public class IntakeSubsystem extends SubsystemBase {

  public CANSparkMax intakeMotor; 
  public DoubleSolenoid piston;
  public DigitalInput pressurePad;

  public IntakeSubsystem() {
    intakeMotor = new CANSparkMax(0, MotorType.kBrushless); 
  }
  
  public void runMotor(double power) {
   

  }

  public void stopMotor() {
    runMotor(0); 


  }

  public void drop() {



  }

  public void raise() {



  }
  
}
