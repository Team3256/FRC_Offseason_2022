package frc.robot.transfer.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Constants.TransferConstants.*;
import frc.robot.transfer.TransferSubsystem;

// TODO: Finish this class
public class TransferReverse extends CommandBase {
    TransferSubsystem transferSubsystem;

    public TransferReverse(TransferSubsystem transferSubsystem) {
        this.transferSubsystem = transferSubsystem;
        addRequirements(transferSubsystem);
    }

    /*
     * Run the transfer at the percent speed defined in TransferConstants
     */
    @Override
    public void initialize() {
        transferSubsystem.setPercentSpeed(TRANSFER_REVERSE_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        transferSubsystem.off();
    }
}
