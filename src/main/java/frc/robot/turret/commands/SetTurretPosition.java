package frc.robot.turret.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.TurrentConstants;
import frc.robot.turret.TurretSubsystem;

// TODO: Finish this command
public class SetTurretPosition extends PIDCommand {
    DoubleSupplier position;
    TurretSubsystem turretSubsystem;

    public SetTurretPosition(TurretSubsystem turretSubsystem, DoubleSupplier position) {
        super(
                new PIDController(TurrentConstants.KP, TurrentConstants.KI, TurrentConstants.KD),
                turretSubsystem::getPosition,
                position,
                turretSubsystem::setPosition,
                turretSubsystem
             );

        this.position = position;
        this.turretSubsystem = turretSubsystem;
    }

    @Override
    public void execute() {
        super.execute();
        SmartDashboard.putNumber("Turret Position", turretSubsystem.getPosition());
    }
}
