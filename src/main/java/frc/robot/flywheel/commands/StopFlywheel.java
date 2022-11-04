package frc.robot.flywheel.commands;

import frc.robot.flywheel.FlywheelSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class StopFlywheel extends CommandBase {
    private FlywheelSubsystem flywheelSubsystem;

    public StopFlywheel(FlywheelSubsystem flywheelSubsystem) {
        this.flywheelSubsystem = flywheelSubsystem;
    
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(flywheelSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        flywheelSubsystem.stopFlywheel();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return true;
    }
}
