package frc.robot.flywheel.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.flywheel.FlywheelSubsystem;

public class SetFlywheelFromVoltage extends CommandBase {
    FlywheelSubsystem flywheelSubsystem;
    DoubleSupplier voltage;
    boolean usingDashboard;

    public SetFlywheelFromVoltage(FlywheelSubsystem flywheelSubsystem, DoubleSupplier voltage) {
        this.voltage = voltage;
        this.flywheelSubsystem = flywheelSubsystem;
        addRequirements(flywheelSubsystem);
    }

    public SetFlywheelFromVoltage(FlywheelSubsystem flywheelSubsystem) {
        this.voltage = () -> SmartDashboard.getNumber("Flywheel Voltage", 0);
        this.flywheelSubsystem = flywheelSubsystem;
        addRequirements(flywheelSubsystem);
    }

    @Override
    public void initialize() {
        if (!usingDashboard)
            SmartDashboard.putNumber("Flywheel Voltage", voltage.getAsDouble());
        else
            SmartDashboard.putNumber("Flywheel Voltage", voltage.getAsDouble());

    }

    @Override
    public void execute() {
        flywheelSubsystem.setInputVoltage(voltage.getAsDouble());
        SmartDashboard.putNumber("Flywheel Velocity", flywheelSubsystem.getAngularVelocityRPM());
    }

    @Override
    public void end(boolean interrupted) {
        flywheelSubsystem.setInputVoltage(0);
    }
}
