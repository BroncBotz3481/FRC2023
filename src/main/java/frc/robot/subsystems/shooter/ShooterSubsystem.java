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
package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.RelativeEncoder;

public class ShooterSubsystem extends SubsystemBase {

    private VictorSPX shooterMotorLeft;
    private TalonSRX shooterMotorRight;
    private ShuffleboardTab pidTab;
    private SuppliedValueWidget<Double> velocityWidget;
    private SimpleWidget kP;
    private SimpleWidget kI;
    private SimpleWidget kD;
    private SimpleWidget kF;

    enum slotIdx {
        DISTANCE,
        TURNING, 
        VELOCITY,
        MOTIONPROFILE,
    }
    enum pidIdx {
        PRIMARY,
        AUXILLARY
        
    }


    public ShooterSubsystem() {

        shooterMotorLeft = new VictorSPX(2);
        shooterMotorRight = new TalonSRX(1);
        pidTab = Shuffleboard.getTab("PID");
        velocityWidget = pidTab.addNumber("Velocity", ()->{return ShooterPolicy.encoderVelocity;});
        kP = pidTab.add("kP", 0.088);
        kI = pidTab.add("kI", 0);
        kD = pidTab.add("kD", 0);
        kF = pidTab.add("kF", 0.0365);
        shooterMotorLeft.setInverted(true);
        shooterMotorLeft.follow(shooterMotorRight);
        
        shooterMotorRight.selectProfileSlot(slotIdx.VELOCITY.ordinal(), pidIdx.PRIMARY.ordinal()); // First parameter "2" correlates to velocity, second parameter correlates to primary PID
        shooterMotorRight.config_kP(slotIdx.VELOCITY.ordinal(), 0.088);  // 0.087 First parameter is primary PID, second parameter is velocity
        shooterMotorRight.config_kI(slotIdx.VELOCITY.ordinal(), 0);
        shooterMotorRight.config_kD(slotIdx.VELOCITY.ordinal(), 0);
        shooterMotorRight.config_kF(slotIdx.VELOCITY.ordinal(), 0.0365);

        shooterMotorRight.config_IntegralZone(slotIdx.VELOCITY.ordinal(), 300);
        shooterMotorRight.configAllowableClosedloopError(slotIdx.VELOCITY.ordinal(), pidIdx.PRIMARY.ordinal());
        shooterMotorRight.configClosedLoopPeriod(slotIdx.VELOCITY.ordinal(), 1);

        shooterMotorRight.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 20, 50);
        shooterMotorRight.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 20, 50);
    }

    // This could be "runintake" or "stopintake" or "liftclimber"
    // https://docs.ctre-phoenix.com/en/stable/ch16_ClosedLoop.html#closed-loop-configs-per-slot-four-slots-available

    public void shoot(double power) {
        ShooterPolicy.powerShooter = power;
        shooterMotorRight.set(ControlMode.PercentOutput, ShooterPolicy.getShooterPower());
        

    }

    public void shootPID(){
        shooterMotorRight.set(ControlMode.Velocity, ShooterPolicy.targetSpeed);
    }

    public void stopShooter() {
        shoot(0);
    }

    @Override
    public void periodic() { 
        ShooterPolicy.encoderVelocity = shooterMotorRight.getSelectedSensorVelocity(pidIdx.PRIMARY.ordinal());
        System.out.println("Hey this is the shooter's current RPM: " + ShooterPolicy.encoderVelocity);
//        pidTab.

    }

}
