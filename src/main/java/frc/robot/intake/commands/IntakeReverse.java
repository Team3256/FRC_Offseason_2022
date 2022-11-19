package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.intake.IntakeSubsystem;

public class IntakeReverse extends CommandBase{

    private IntakeSubsystem intakeSubsystem;

    public IntakeReverse(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);

    }

    /*
     * Retract and run the intake motor at the speed defined in IntakeConstants
     */
    @Override
    public void initialize() {
        intakeSubsystem.setPercentSpeed(IntakeConstants.INTAKE_REVERSE_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.off();
    }
}
