/****************************** Header ******************************\
 Class Name: ShooterSubsystem extends SubsystemBase
 File Name: ExampleSubsystem.java
 Summary: An example subsystem to use for learning and testing.
 Project: BroncBotzFRC2023
 Copyright (c) BroncBotz.
 All rights reserved.

 Author(s): Shruti Venkat and Samuel Zhao
 Email: Shruti.venkat@gmail.com
 \********************************************************************/
package frc.robot.daydream.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    public VictorSPX shooterMotorLeft;
    public TalonSRX shooterMotorRight;

    public ShooterSubsystem() {
        shooterMotorLeft = new VictorSPX(2);
        shooterMotorRight = new TalonSRX(1);

        shooterMotorLeft.setInverted(true);
        shooterMotorLeft.follow(shooterMotorRight);
        
        shooterMotorRight.selectProfileSlot(2,0); // First parameter "2" correlates to velocity, second parameter correlates to primary PID
        shooterMotorRight.config_kP(0, 0);  // First parameter is primary PID, second parameter is velocity
        shooterMotorRight.config_kI(0, 0);  
        shooterMotorRight.config_kD(0, 0);
        shooterMotorRight.config_kF(0, 0);

        shooterMotorRight.config_IntegralZone(0, 300);
        shooterMotorRight.configAllowableClosedloopError(0, 0);
        shooterMotorRight.configClosedLoopPeriod(0, 1);

        shooterMotorRight.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 20, 50);
        shooterMotorRight.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 20, 50);
    }

    // This could be "runintake" or "stopintake" or "liftclimber"
    // https://docs.ctre-phoenix.com/en/stable/ch16_ClosedLoop.html#closed-loop-configs-per-slot-four-slots-available

    public void shoot() {
        shooterMotorRight.set(ControlMode.PercentOutput, ShooterPolicy.getShooterPower());

    }

    public void shootPID(){
        shooterMotorRight.set(ControlMode.Velocity, ShooterPolicy.targetSpeed);
    }

    public void stopShooter() {
        ShooterPolicy.powerShooter = 0;
        shoot();
    }

    @Override
    public void periodic() {
    }

}
