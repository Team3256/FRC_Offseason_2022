package frc.robot.transfer.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.TransferConstants;
import frc.robot.transfer.TransferSubsystem;

public class TransferForward extends CommandBase {
    TransferSubsystem transferSubsystem;

    public TransferForward(TransferSubsystem transferSubsystem) {
        this.transferSubsystem = transferSubsystem;

        addRequirements(transferSubsystem);
    }

    @Override
    public void initialize() {
        transferSubsystem.setPercentSpeed(TransferConstants.TRANSFER_FORWARD_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        transferSubsystem.off();
    }
}
