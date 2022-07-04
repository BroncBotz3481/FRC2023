package frc.robot.subsystems.Daydream;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
    
    private VictorSPX LeftMotor;
    private TalonSRX RightMotor;
    
    public ShooterSubsystem() {
        configureSubsystem();
    }

    public void setPIDVelocity(double velocity) {
        RightMotor.set(ControlMode.Velocity, velocity);
    }

    public void setPower(double power) {
        RightMotor.set(ControlMode.PercentOutput, power);
    }

    private void configureSubsystem() {
        // TODO: CAN IDs
        // TODO: Move CAN IDs to Constants
        LeftMotor = new VictorSPX(0);
        RightMotor = new TalonSRX(1);

        LeftMotor.setInverted(true);
        RightMotor.setInverted(false);

        LeftMotor.follow(RightMotor);
    }
}
