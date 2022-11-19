package frc.robot.flywheel.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.FlywheelConstants;
import frc.robot.flywheel.FlywheelSubsystem;

/*
 * Set the velocity of the flywheel using PID
 */
// TODO: Finish this command
public class SetFlywheelVelocityFromPID extends PIDCommand {
    double velocity;
    FlywheelSubsystem flywheelSubsystem;

    public SetFlywheelVelocityFromPID(FlywheelSubsystem flywheelSubsystem, double velocity) {
        super(
                new PIDController(FlywheelConstants.KP,FlywheelConstants.KI,FlywheelConstants.KD),
                flywheelSubsystem::getVelocity,
                velocity,
                flywheelSubsystem::setVoltage,
                flywheelSubsystem
             );
        this.velocity = velocity;
        this.flywheelSubsystem = flywheelSubsystem;
    }


    @Override
    public void execute() {
        super.execute();
        SmartDashboard.putNumber("Flywheel Velocity", flywheelSubsystem.getVelocity());
    }
}
