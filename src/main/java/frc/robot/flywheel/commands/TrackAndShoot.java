package frc.robot.flywheel.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.flywheel.FlywheelSubsystem;
import frc.robot.hardware.Limelight;
import frc.robot.turret.TurretSubsystem;
import frc.robot.turret.commands.SetTurretPosition;


// TODO: Make this extend a command grouper and finish this class
public class TrackAndShoot extends /* Command group here */ {
    FlywheelSubsystem flywheelSubsystem;
    TurretSubsystem turretSubsystem;

    // Run both the SetFlywheelVelocity command and SetTurretPosition commands 
    public TrackAndShoot() {
    }
}
