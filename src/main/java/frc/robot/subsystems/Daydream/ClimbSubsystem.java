package frc.robot.subsystems.Daydream;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase {
    
    private VictorSPX LeftClimbMotor;
    private VictorSPX RightClimbMotor;
    
    public ClimbSubsystem() {
        configureSubsystem();
    }

    public void setLeftClimberPower(double power){
        LeftClimbMotor.set(ControlMode.PercentOutput, power);
    }

    public void setRightClimberPower(double power){
        RightClimbMotor.set(ControlMode.PercentOutput, power);
    }

    public void configureSubsystem() {
        // TODO: CAN IDs
        // TODO: Move CAN IDs to Constants
        LeftClimbMotor = new VictorSPX(0);
        RightClimbMotor = new VictorSPX(1);
        LeftClimbMotor.setInverted(false);
        RightClimbMotor.setInverted(false);
    }
}
