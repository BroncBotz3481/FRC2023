package frc.robot.OrryInterfacePractice;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DoubleSolenoid;

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
