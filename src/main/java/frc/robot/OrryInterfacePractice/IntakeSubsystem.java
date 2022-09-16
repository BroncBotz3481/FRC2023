package frc.robot.OrryInterfacePractice;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ColorSensorV3;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants.ExampleSubsystemConstants;

public class IntakeSubsystem extends SubsystemBase {
    public CANSparkMax intakeMotor;
    public DoubleSolenoid piston;
    public ColorSensorV3 colorSensor;

    public IntakeSubsystem() {
        intakeMotor = new CANSparkMax(0, MotorType.kBrushless);
    }

    public void togglePistons(){

    }
    public void runMotor(double power){

    }
    
}
