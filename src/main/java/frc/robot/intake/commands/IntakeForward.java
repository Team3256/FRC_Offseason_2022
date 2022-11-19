package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.IntakeConstants;
import frc.robot.intake.IntakeSubsystem;

//DONE
public class IntakeForward extends CommandBase {
    private IntakeSubsystem intake;

    public IntakeForward(IntakeSubsystem intakeSubsystem) {
        addRequirements(intakeSubsystem);
        intake = intakeSubsystem;
    }

    /*
     * Extend and run the intake motor at the speed defined in IntakeConstants
     */
    @Override
    public void initialize() {
        intake.extend();
        intake.setPercentSpeed(IntakeConstants.INTAKE_FORWARD_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        intake.off();
    }
}
