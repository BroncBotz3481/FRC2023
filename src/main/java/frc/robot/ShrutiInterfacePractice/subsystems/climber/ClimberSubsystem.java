package frc.robot.ShrutiInterfacePractice.subsystems.climber;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class ClimberSubsystem extends SubsystemBase{
    private VictorSPX leftMotor;
    private VictorSPX rightMotor;

    public ClimberSubsystem(){
        leftMotor = new VictorSPX(0);
        rightMotor = new VictorSPX(0);
    }
    public void runLeftMotor(double power) {
        leftMotor.set(ControlMode.PercentOutput, power);
    }

    public void runRightMotor(double power) {
        rightMotor.set(ControlMode.PercentOutput, power);
    }
    
    public void stopLeftMotor() {
        runLeftMotor(0);
      }

    public void stopRightMotor() {
        runRightMotor(0);
      }
}
