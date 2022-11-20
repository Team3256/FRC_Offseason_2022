// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.flywheel.FlywheelSubsystem;
import frc.robot.flywheel.commands.SetFlywheelFromPID;
import frc.robot.flywheel.commands.SetFlywheelFromVoltage;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */

public class RobotContainer {
    private FlywheelSubsystem flywheelSubsystem;

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();
        configureFlywheel();
    }

    /**
    * Use this method to define your button->command mappings. Buttons can be created by
    * instantiating a {@link GenericHID} or one of its subclasses ({@link
    * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
    * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
    */
    private void configureButtonBindings() {}

    private void configureFlywheel() {
        flywheelSubsystem = new FlywheelSubsystem();

//         flywheelSubsystem.setDefaultCommand(new SetFlywheelFromPID(flywheelSubsystem, Math.random() * 600 + 601));
//        flywheelSubsystem.setDefaultCommand(new SetFlywheelFromPID(flywheelSubsystem));
         flywheelSubsystem.setDefaultCommand(new SetFlywheelFromVoltage(flywheelSubsystem));
    }

    /**
    * Use this to pass the autonomous command to the main {@link Robot} class.
    *
    * @return the command to run in autonomous
    */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        DoubleSupplier velocitySetpoint = () -> Math.sin(Timer.getFPGATimestamp()) * 200 + 1200;
        return new SetFlywheelFromPID(flywheelSubsystem, velocitySetpoint);
    }
}
