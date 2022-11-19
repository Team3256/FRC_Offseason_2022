package frc.robot.transfer.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.TransferConstants;
import frc.robot.transfer.TransferSubsystem;

public class TransferReverse extends CommandBase {
    TransferSubsystem transferSubsystem;

    public TransferReverse(TransferSubsystem transferSubsystem) {
        this.transferSubsystem = transferSubsystem;
    }

    /*
     * Run the transfer at the percent speed defined in TransferConstants
     */
    @Override
    public void initialize() {
        transferSubsystem.setPercentSpeed(TransferConstants.TRANSFER_REVERSE_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        transferSubsystem.off();
    }
}
