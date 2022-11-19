package frc.robot.flywheel.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.flywheel.FlywheelSubsystem;
import frc.robot.hardware.Limelight;
import frc.robot.turret.TurretSubsystem;
import frc.robot.turret.commands.SetTurretPosition;



// TODO: Make this extend a command grouper and finish this class
public class TrackAndShoot extends ParallelCommandGroup {
    FlywheelSubsystem flywheelSubsystem;
    TurretSubsystem turretSubsystem;

    // Run both the SetFlywheelVelocity command and SetTurretPosition commands 
    public TrackAndShoot(FlywheelSubsystem flywheelSubsystem, TurretSubsystem turretSubsystem) {
        this.flywheelSubsystem = flywheelSubsystem;
        this.turretSubsystem = turretSubsystem;

        addCommands (
                new SetFlywheelVelocityFromPID(flywheelSubsystem, ()->2000),
                new SetTurretPosition(turretSubsystem,Limelight::getTx)
        );

    }
}
