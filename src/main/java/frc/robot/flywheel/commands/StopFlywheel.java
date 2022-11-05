package frc.robot.flywheel.commands;

import frc.robot.flywheel.FlywheelSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/*
 * A command to stop the flywheel motors
 */
public class StopFlywheel extends CommandBase {
    public double percentSpeed;
    public FlywheelSubsystem flywheelSubsystem;

    public StopFlywheel(FlywheelSubsystem flywheelSubsystem) {
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(flywheelSubsystem);
        this.flywheelSubsystem = flywheelSubsystem;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        this.flywheelSubsystem.stopFlywheel();
    }

    // Called once per loop run.
    @Override
    public void execute() {
        this.flywheelSubsystem.stopFlywheel();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }
}
