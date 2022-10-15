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
package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    public VictorSPX intakeMotor;
    public DoubleSolenoid piston;

    public IntakeSubsystem() {
        intakeMotor = new VictorSPX(7);
        piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 9, 6);

        intakeMotor.setInverted(false); //true

    }

    public void runMotor(double power) {
        IntakePolicy.intakePower = 0;
        intakeMotor.set(ControlMode.PercentOutput, IntakePolicy.intakePower);

    }

    public void stopMotor() {
        intakeMotor.set(ControlMode.PercentOutput, 0);

    }

    public void drop() {
        piston.set(IntakePolicy.downPosition);

    }

    public void raise() {
        piston.set(IntakePolicy.upPosition);

    }

    public void toggle() {
        piston.toggle();

    }
}
  

