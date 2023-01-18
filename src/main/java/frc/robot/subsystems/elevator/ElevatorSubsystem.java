package frc.robot.subsystems.elevator;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {
    private final CANSparkMax eleMotor1, eleMotor2;

    public ElevatorSubsystem() {
        eleMotor1 = new CANSparkMax(0, MotorType.kBrushless);
        eleMotor2 = new CANSparkMax(1, MotorType.kBrushless);
        eleMotor2.follow(eleMotor1);//eleMotor1 is the leader
        // TODO: Check if one motor needs to be reversed
    }

    public void runEle(double powerOne) {
        ElevatorPolicy.powerEle = powerOne;
        eleMotor1.set(ElevatorPolicy.powerEle);
    }


    public void stopEle() {
        runEle(0);

    }
}
