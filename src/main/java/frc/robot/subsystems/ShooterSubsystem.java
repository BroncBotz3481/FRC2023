package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
    
    private VictorSPX LeftMotor;
    private TalonSRX RightMotor;
    
    public ShooterSubsystem() {
        ConfigureSubsystem();
    }

    public void SetPIDVelocity(double velocity) {
        RightMotor.set(ControlMode.Velocity, velocity);
    }

    public void SetPower(double power) {
        RightMotor.set(ControlMode.PercentOutput, power);
    }

    public void ConfigureSubsystem() {
        // TODO: CAN IDs
        // TODO: Move CAN IDs to Constants
        LeftMotor = new VictorSPX(0);
        RightMotor = new TalonSRX(1);

        LeftMotor.setInverted(true);
        RightMotor.setInverted(false);

        LeftMotor.follow(RightMotor);
    }
}
