package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Constants.IntakeConstants.*;
import frc.robot.intake.IntakeSubsystem;

// TODO: Finish this class
public class IntakeForward extends CommandBase {

    private IntakeSubsystem intakeSubsystem;

    public IntakeForward(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    /*
     * Extend and run the intake motor at the speed defined in IntakeConstants
     */
    @Override
    public void initialize() {
        intakeSubsystem.extend();
        intakeSubsystem.setPercentSpeed(INTAKE_FORWARD_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.off();
    }
}
