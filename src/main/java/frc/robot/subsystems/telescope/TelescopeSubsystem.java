package frc.robot.subsystems.telescope;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TelescopeSubsystem extends SubsystemBase {
    private final CANSparkMax telescopeMotor;

    public TelescopeSubsystem() {
        telescopeMotor = new CANSparkMax(2, MotorType.kBrushless);
    }


    public void runTelescope(double power) {
        TelescopePolicy.powerTele = power;
        telescopeMotor.set(TelescopePolicy.powerTele);
    }

    public void stopTelescope() {
        runTelescope(0);
    }

}
