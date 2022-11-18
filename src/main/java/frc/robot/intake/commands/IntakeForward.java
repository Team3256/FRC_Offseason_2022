package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.IntakeConstants;
import frc.robot.intake.IntakeSubsystem;

public class IntakeForward extends CommandBase {
    IntakeSubsystem intakeSubsystem;

    public IntakeForward(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;

        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {
        intakeSubsystem.setPercentSpeed(IntakeConstants.INTAKE_FORWARD_SPEED);
        intakeSubsystem.extend();
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.off();
        intakeSubsystem.retract();
    }
}
