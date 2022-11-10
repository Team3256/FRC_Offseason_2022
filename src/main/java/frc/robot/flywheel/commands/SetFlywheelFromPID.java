package frc.robot.flywheel.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.flywheel.FlywheelSubsystem;

public class SetFlywheelFromPID extends PIDCommand {
    DoubleSupplier velocity;
    public SetFlywheelFromPID(FlywheelSubsystem flywheelSubsystem, DoubleSupplier velocity) {
        super(
            new PIDController(0.01, 0, 0),
            flywheelSubsystem::getAngularVelocityRPM,
            velocity,
            voltage -> flywheelSubsystem.setInputVoltage(voltage),
            flywheelSubsystem
        );

        this.velocity = velocity;
    }

    public SetFlywheelFromPID(FlywheelSubsystem flywheelSubsystem, double velocity) {
        super(
            new PIDController(0.01, 0, 0),
            flywheelSubsystem::getAngularVelocityRPM,
            velocity,
            voltage -> flywheelSubsystem.setInputVoltage(voltage),
            flywheelSubsystem
        );

        this.velocity = () -> velocity;
    }

    @Override
    public void initialize() {
        SmartDashboard.putData(getController());
    }

    @Override
    public void execute() {
        super.execute();
        SmartDashboard.putNumber("Velocity Setpoint", velocity.getAsDouble());
    }
}
