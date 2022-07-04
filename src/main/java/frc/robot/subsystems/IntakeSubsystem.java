package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    
    private VictorSPX IntakeMotor;
    private DoubleSolenoid IntakePiston;
    
    public IntakeSubsystem() {
        ConfigureSubsystem();
    }

    // TODO: This is a crude way to control this, we should have a combo method that controls both the piston and the motor
    public void SetIntakePower(double power) {
        IntakeMotor.set(VictorSPXControlMode.PercentOutput, power);
    }

    public void SetPistonPosition(DoubleSolenoid.Value value) {
        IntakePiston.set(value);
    }

    private void ConfigureSubsystem() {
        // TODO: CAN IDs
        // TODO: Move CAN IDs to Constants
        IntakeMotor = new VictorSPX(0);
        IntakeMotor.setInverted(false);
        // TODO: Move PCM type to Constants
        IntakePiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    }
}
