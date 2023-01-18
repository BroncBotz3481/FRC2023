package frc.robot.subsystems.intakeNew;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    private final CANSparkMax intakeMotor;

    public IntakeSubsystem() {
        intakeMotor = new CANSparkMax(3, MotorType.kBrushless);

    }

    public void runIntake(double power) {
        IntakePolicy.powerIntake = power;
        intakeMotor.set(IntakePolicy.powerIntake);
    }


    public void stopIntake() {
        runIntake(0);

    }
}
