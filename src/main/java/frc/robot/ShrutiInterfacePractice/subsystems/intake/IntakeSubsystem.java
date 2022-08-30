/****************************** Header ******************************\
Class Name: IntakeSubsystem extends SubsystemBase
File Name: IntakeSubsystem.java
Summary: An example subsystem to use for learning and testing.
Project: BroncBotzFRC2023
Copyright (c) BroncBotz.
All rights reserved.

Author(s): Shruti Venkat
Email: shruti.venkat05@gmail.com
\********************************************************************/
package frc.robot.ShrutiInterfacePractice.subsystems.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.DigitalInput;




import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants.ExampleSubsystemConstants;
//import com.qualcomm.robotcore.hardware.TouchSensor;

public class IntakeSubsystem extends SubsystemBase {

  public CANSparkMax intakeMotor; // This is the motor controller
  public DoubleSolenoid piston;
  public ColorSensorV3 colorSensor;
  public DigitalInput pressurePad;
  /** Creates a new ExampleSubsystem. */
  public IntakeSubsystem() {
    intakeMotor = new CANSparkMax(0, MotorType.kBrushless); // Create the new motor controller (make sure you check your ID!)
    System.out.println(ExampleSubsystemConstants.testConstant); // Example of how to use the "Constants" class and subclasses
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
