/****************************** Header ******************************\
 Class Name: Robot extends TimedRobot
 File Name: Robot.java
 Summary: Main entry point for TimedRobot commands. CommandScheduler is run through this class.
 Project: BroncBotzFRC2023
 Copyright (c) BroncBotz.
 All rights reserved.

 Author(s): Dylan Watson
 Email: dylantrwatson@gmail.com
 \********************************************************************/
package frc.robot;

// import com.ctre.phoenix.sensors.CANCoder;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.math.geometry.Rotation2d;
//import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.cscore.UsbCamera;
//import frc.robot.subsystems.swerve.SwerveModule;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

// Commenting for test task

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
    private Command m_autonomousCommand;
    private NetworkTableEntry fiducialTableEntry;
    private NetworkTableEntry pitch;
    private NetworkTableEntry yaw;
    private NetworkTableEntry skew;
    private NetworkTableEntry area;
    private RobotContainer m_robotContainer;
    private UsbCamera m_usbCamera;
    //private PhotonCamera camera;
   // PhotonCamera c = new PhotonCamera("photonvision");
    /**
     * This function is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit() {
        // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
        // autonomous chooser on the dashboard.

        m_usbCamera = CameraServer.startAutomaticCapture();
        CameraServer.startAutomaticCapture();
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("pipeline");
        fiducialTableEntry = table.getEntry("fid");
        pitch = table.getEntry("pitch");
        yaw = table.getEntry("yaw");
        skew = table.getEntry("skew");
        area = table.getEntry("area");
        
        //camera = new PhotonCamera("Integrated_Webcam");

        m_robotContainer = new RobotContainer();
    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for items like
     * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
     *
     * <p>This runs after the mode specific periodic functions, but before LiveWindow and
     * SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
        // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
        // commands, running already-scheduled commands, removing finished or interrupted commands,
        // and running subsystem periodic() methods.  This must be called from the robot's periodic
        // block in order for anything in the Command-based framework to work.
        //var result = camera.getLatestResult();

        CommandScheduler.getInstance().run();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     */
    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }

    /**
     * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
     */
    @Override
    public void autonomousInit() {
        m_autonomousCommand = m_robotContainer.getAutonomousCommand();

        // schedule the autonomous command (example)
        if (m_autonomousCommand != null) {
            m_autonomousCommand.schedule();
        }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
        }
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
    }
   // SwerveModule swerve;
    @Override
    public void testInit() {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
        // swerve = new SwerveModule(4,3, false, false,
        //         0, 0, false);
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
        double num = SmartDashboard.getNumber("Rotation Degrees", 90);
       // swerve.setDesiredState(new SwerveModuleState(0,Rotation2d.fromDegrees(num)));

        //Set angle or set state here
    }
}
