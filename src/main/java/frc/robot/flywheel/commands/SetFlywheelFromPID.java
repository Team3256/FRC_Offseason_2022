package frc.robot.flywheel.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.FlywheelConstants;
import frc.robot.flywheel.FlywheelSubsystem;

public class SetFlywheelFromPID extends PIDCommand {
    DoubleSupplier velocity;
    FlywheelSubsystem flywheelSubsystem;
    boolean movingSetpoint = false;

    public SetFlywheelFromPID(FlywheelSubsystem flywheelSubsystem) {
        super(
                new PIDController(FlywheelConstants.KP, FlywheelConstants.KI, FlywheelConstants.KD),
                flywheelSubsystem::getAngularVelocityRPM,
                SmartDashboard.getNumber("Velocity Setpoint", 1200),
                voltage -> flywheelSubsystem.setInputVoltage(voltage + SmartDashboard.getNumber("Velocity Setpoint", 1200) * SmartDashboard.getNumber("Flywheel KFF", FlywheelConstants.KFF)),
                flywheelSubsystem
             );

        this.velocity = () -> SmartDashboard.getNumber("Velocity Setpoint", 1200);
        this.flywheelSubsystem = flywheelSubsystem;
    }

    public SetFlywheelFromPID(FlywheelSubsystem flywheelSubsystem, DoubleSupplier velocity) {
        super(
            new PIDController(FlywheelConstants.KP, FlywheelConstants.KI, FlywheelConstants.KD),
            flywheelSubsystem::getAngularVelocityRPM,
            velocity,
            voltage -> flywheelSubsystem.setInputVoltage(voltage + velocity.getAsDouble() * FlywheelConstants.KFF),
            flywheelSubsystem
            );

        this.movingSetpoint = true;
        this.velocity = velocity;
        this.flywheelSubsystem = flywheelSubsystem;
    }

    public SetFlywheelFromPID(FlywheelSubsystem flywheelSubsystem, double velocity) {
        super(
            new PIDController(FlywheelConstants.KP, FlywheelConstants.KI, FlywheelConstants.KD),
            flywheelSubsystem::getAngularVelocityRPM,
            velocity,
            voltage -> flywheelSubsystem.setInputVoltage(voltage + velocity * FlywheelConstants.KFF),
            flywheelSubsystem
        );

        this.velocity = () -> velocity;
        this.flywheelSubsystem = flywheelSubsystem;
    }

    @Override
    public void initialize() {
        SmartDashboard.putData(getController());
        SmartDashboard.putNumber("Velocity Setpoint", 1200);
        SmartDashboard.putNumber("Flywheel KFF", FlywheelConstants.KFF);
    }

    @Override
    public void end(boolean interrupted) {
        flywheelSubsystem.setInputVoltage(0);
    }

    @Override
    public void execute() {
        super.execute();
        if (movingSetpoint)
            SmartDashboard.putNumber("Velocity Setpoint", velocity.getAsDouble());
    }
}
