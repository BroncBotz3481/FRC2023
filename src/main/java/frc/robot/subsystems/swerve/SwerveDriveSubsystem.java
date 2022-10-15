package frc.robot.subsystems.swerve;


import edu.wpi.first.wpilibj.command.Subsystem;

public class SwerveDriveSubsystem extends Subsystem {

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

    /**
     * The Singleton instance of this SwerveDriveSubsystem. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private final static SwerveDriveSubsystem INSTANCE = new SwerveDriveSubsystem();

    /**
     * Creates a new instance of this SwerveDriveSubsystem. This constructor
     * is private since this class is a Singleton. Code should use
     * the {@link #getInstance()} method to get the singleton instance.
     */
    private SwerveDriveSubsystem() {

    }

    /**
     * Returns the Singleton instance of this SwerveDriveSubsystem. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code SwerveDriveSubsystem.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static SwerveDriveSubsystem getInstance() {
        return INSTANCE;
    }

    @Override
    protected void initDefaultCommand() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       e.g. setDefaultCommand(new MyCommand());
    }
}

