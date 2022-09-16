package frc.robot.daydream.subsystems.climber;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.daydream.subsystems.climber.ClimberPolicy;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class ClimberSubsystem extends SubsystemBase{
    private VictorSPX leftMotorClimb;
    private VictorSPX rightMotorClimb;

    public ClimberSubsystem(){
        leftMotorClimb = new VictorSPX(2);
        rightMotorClimb = new VictorSPX(3);
    }



    public void runLeftMotor() {
      leftMotorClimb.set(VictorSPXControlMode.PercentOutput, ClimberPolicy.leftPowerClimb);
    }

    public void runRightMotor() {
      rightMotorClimb.set(VictorSPXControlMode.PercentOutput, ClimberPolicy.rightPowerClimb);

    }
    
    public void stopLeftMotor() {
      leftMotorClimb.set(VictorSPXControlMode.PercentOutput, 0);

      }

    public void stopRightMotor() {
      rightMotorClimb.set(VictorSPXControlMode.PercentOutput, 0);

      }
}
