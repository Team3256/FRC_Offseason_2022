package frc.robot.flywheel.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.flywheel.FlywheelSubsystem;

/*
 * Set the percent speed of the flywheel motors
 */
public class SetFlywheelVelocity extends CommandBase {

    public double percentSpeed;
    public FlywheelSubsystem flywheelSubsystem;
    public SetFlywheelVelocity(FlywheelSubsystem flywheelSubsystem, double percentSpeed) {
        // Use addRequirements() here to declare subsystem dependencies.
        this.flywheelSubsystem = flywheelSubsystem;
        this.percentSpeed = percentSpeed;
        addRequirements(flywheelSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        this.flywheelSubsystem.setPercentSpeed(this.percentSpeed);
    }

    // Called once per loop run.
    @Override
    public void execute() {
        // pass
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        this.flywheelSubsystem.stopFlywheel();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
