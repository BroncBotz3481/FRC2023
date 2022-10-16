package frc.robot.subsystems.swerve;


import edu.wpi.first.wpilibj.command.Subsystem;

public class SwerveSubsystem extends Subsystem {

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

    /**
     * The Singleton instance of this SwerveSubsystem. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private final static SwerveSubsystem INSTANCE = new SwerveSubsystem();

    /**
     * Creates a new instance of this SwerveSubsystem. This constructor
     * is private since this class is a Singleton. Code should use
     * the {@link #getInstance()} method to get the singleton instance.
     */
    private SwerveSubsystem() {

    }

    /**
     * Returns the Singleton instance of this SwerveSubsystem. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code SwerveSubsystem.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static SwerveSubsystem getInstance() {
        return INSTANCE;
    }

    @Override
    protected void initDefaultCommand() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       e.g. setDefaultCommand(new MyCommand());
    }
}

