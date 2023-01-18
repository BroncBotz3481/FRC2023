package frc.robot.subsystems.climber;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase {
    private final VictorSPX leftMotorClimb;
    private final VictorSPX rightMotorClimb;

    public ClimberSubsystem() {
        leftMotorClimb = new VictorSPX(4);
        rightMotorClimb = new VictorSPX(5);

        leftMotorClimb.setInverted(true);
    }


    public void runLeftMotor(double powerLeft) {
        ClimberPolicy.leftPowerClimb = powerLeft; 
        leftMotorClimb.set(VictorSPXControlMode.PercentOutput, ClimberPolicy.leftPowerClimb);
    }

    public void runRightMotor(double powerRight) {
        ClimberPolicy.rightPowerClimb = powerRight; 
        rightMotorClimb.set(VictorSPXControlMode.PercentOutput, ClimberPolicy.rightPowerClimb);

    }

    public void stopLeftMotor() {
        leftMotorClimb.set(VictorSPXControlMode.PercentOutput, 0);

    }

    public void stopRightMotor() {
        rightMotorClimb.set(VictorSPXControlMode.PercentOutput, 0);

    }
}
