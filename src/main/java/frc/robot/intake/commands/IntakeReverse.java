package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.IntakeConstants;
import frc.robot.intake.IntakeSubsystem;

public class IntakeReverse extends CommandBase{
    IntakeSubsystem intakeSubsystem;

    public IntakeReverse(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;

        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {
        intakeSubsystem.setPercentSpeed(IntakeConstants.INTAKE_REVERSE_SPEED);
        intakeSubsystem.retract();
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.off();
    }
}
