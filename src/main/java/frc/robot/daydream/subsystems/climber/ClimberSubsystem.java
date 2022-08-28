package frc.robot.daydream.subsystems.climber;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class ClimberSubsystem extends SubsystemBase{
    private VictorSPX leftMotorClimb;
    private VictorSPX rightMotorClimb;

    public ClimberSubsystem(){
        leftMotorClimb = new VictorSPX(2);
        rightMotorClimb = new VictorSPX(3);
    }




    public void runLeftMotor(double leftPowerClimb) {

    }

    public void runRightMotor(double rightPowerClimb) {
  
    }
    
    public void stopLeftMotor() {
        runLeftMotor(0);
      }

    public void stopRightMotor() {
        runRightMotor(0);
      }
}
