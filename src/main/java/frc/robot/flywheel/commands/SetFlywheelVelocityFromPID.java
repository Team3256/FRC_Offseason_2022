package frc.robot.flywheel.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import static frc.robot.Constants.FlywheelConstants.*;
import frc.robot.flywheel.FlywheelSubsystem;

/*
 * Set the velocity of the flywheel using PID
 */

public class SetFlywheelVelocityFromPID extends PIDCommand {
    DoubleSupplier velocity;
    FlywheelSubsystem flywheelSubsystem;

    public SetFlywheelVelocityFromPID(FlywheelSubsystem flywheelSubsystem, DoubleSupplier velocity) {
        super(
                new PIDController(KP, KI, KD),
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

    @Override
    public boolean isFinished(){
        return getController().atSetpoint();
    }
}
