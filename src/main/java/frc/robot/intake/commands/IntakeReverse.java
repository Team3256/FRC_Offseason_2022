package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.IntakeConstants;
import frc.robot.intake.IntakeSubsystem;

//DONE
public class IntakeReverse extends CommandBase{
    private IntakeSubsystem intake;

    public IntakeReverse(IntakeSubsystem intakeSubsystem) {
        intake=intakeSubsystem;
    }

    /*
     * Retract and run the intake motor at the speed defined in IntakeConstants
     */
    @Override
    public void initialize() {
        intake.retract();
        intake.setPercentSpeed(IntakeConstants.INTAKE_REVERSE_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
    }
}
