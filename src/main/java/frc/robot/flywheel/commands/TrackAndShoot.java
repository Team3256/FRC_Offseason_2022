package frc.robot.flywheel.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.flywheel.FlywheelSubsystem;
import frc.robot.hardware.Limelight;
import frc.robot.turret.TurretSubsystem;
import frc.robot.turret.commands.SetTurretPosition;


// TODO: Make this extend a command grouper and finish this class
public class TrackAndShoot extends ParallelRaceGroup {
    FlywheelSubsystem flywheelSubsystem;
    TurretSubsystem turretSubsystem;

    public TrackAndShoot(TurretSubsystem turretSubsystem, FlywheelSubsystem flywheelSubsystem) {
        addCommands(
                new SetTurretPosition(turretSubsystem, Limelight::getTx),
                new SetFlywheelVelocityFromPID(flywheelSubsystem, () -> 2000)
                );
    }
}
