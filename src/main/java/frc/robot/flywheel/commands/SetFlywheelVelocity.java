// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.flywheel.commands;

import frc.robot.flywheel.FlywheelSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class SetFlywheelVelocity extends CommandBase {
    private final FlywheelSubsystem flywheelSubsystem;
    private double percentSpeed;

    public SetFlywheelVelocity(FlywheelSubsystem flywheelSubsystem, double percentSpeed) {
        this.flywheelSubsystem = flywheelSubsystem;
        this.percentSpeed = percentSpeed;
    
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(flywheelSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        flywheelSubsystem.setPercentSpeed(this.percentSpeed);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        flywheelSubsystem.stopFlywheel();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
