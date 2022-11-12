package frc.robot.flywheel.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.flywheel.FlywheelSubsystem;

/*
 * Set the percent speed of the flywheel motors
 */
public class SetFlywheelVelocity extends CommandBase {

    private FlywheelSubsystem flywheelSubsystem;
    private double percentSpeed;

    public SetFlywheelVelocity(FlywheelSubsystem flywheelSubsystem, double percentSpeed) {
        // Use addRequirements() here to declare subsystem dependencies.
        this.flywheelSubsystem = flywheelSubsystem;
        this.percentSpeed = percentSpeed;
        addRequirements(flywheelSubsystem);
        
        
        //flywheelSubsystem.stopFlywheel();
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called once per loop run.
    @Override
    public void execute() {
        flywheelSubsystem.setPercentSpeed(percentSpeed);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
