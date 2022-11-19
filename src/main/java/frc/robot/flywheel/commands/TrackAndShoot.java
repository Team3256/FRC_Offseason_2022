package frc.robot.flywheel.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.flywheel.FlywheelSubsystem;
import frc.robot.hardware.Limelight;
import frc.robot.turret.TurretSubsystem;
import frc.robot.turret.commands.SetTurretPosition;


// TODO: Make this extend a command grouper and finish this class
public class TrackAndShoot extends ParallelCommandGroup {
    FlywheelSubsystem flywheelSubsystem;
    TurretSubsystem turretSubsystem;

    // Run both the SetFlywheelVelocity command and SetTurretPosition commands 
    public TrackAndShoot() {
        addCommands(new SetFlywheelVelocityFromPID(flywheelSubsystem, () -> 300), new SetTurretPosition(turretSubsystem, () -> 100));

    }
}
