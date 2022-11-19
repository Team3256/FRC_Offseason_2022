package frc.robot.flywheel.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.flywheel.FlywheelSubsystem;
import frc.robot.hardware.Limelight;
import frc.robot.turret.TurretSubsystem;
import frc.robot.turret.commands.SetTurretPosition;

import java.util.function.DoubleSupplier;


// TODO: Make this extend a command grouper and finish this class
public class TrackAndShoot extends ParallelCommandGroup {
    // Run both the SetFlywheelVelocity command and SetTurretPosition commands 
    public TrackAndShoot(FlywheelSubsystem flywheelSubsystem, TurretSubsystem turretSubsystem) {
        addCommands(
                //set flywheel velocity
                new SetFlywheelVelocityFromPID(flywheelSubsystem, Limelight::getTy),
                //set turret position
                new SetTurretPosition(turretSubsystem, Limelight::getTx));
    }
}
