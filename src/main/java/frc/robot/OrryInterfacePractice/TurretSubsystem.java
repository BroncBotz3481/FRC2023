package frc.robot.OrryInterfacePractice;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants.ExampleSubsystemConstants;

public class TurretSubsystem {
    public CANSparkMax shooterMotor;
    public CANSparkMax turretMotor;
    public DoubleSolenoid piston;
    public TurretSubsystem() {
        shooterMotor = new CANSparkMax(0, MotorType.kBrushless);
    }

    public void shootBall() {

    }

    public void setHoodAngle() {

    }

}
