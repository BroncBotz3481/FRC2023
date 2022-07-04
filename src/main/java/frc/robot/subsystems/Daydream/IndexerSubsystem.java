package frc.robot.subsystems.Daydream;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IndexerSubsystem extends SubsystemBase {
    
    private VictorSPX IndexerMotor;
    private AnalogInput PressurePad;
    
    public IndexerSubsystem() {
        ConfigureSubsystem();
    }

    public void SetIndexerPower(int power, boolean ignorePressurePad) {
        if(PressurePad.getValue() <= 100 || ignorePressurePad)
            IndexerMotor.set(ControlMode.PercentOutput, power);
    }

    private void ConfigureSubsystem() {
        // TODO: CAN IDs
        // TODO: Move CAN IDs to Constants
        IndexerMotor = new VictorSPX(0);
        IndexerMotor.setInverted(false);
        PressurePad = new AnalogInput(0);
    }
}
