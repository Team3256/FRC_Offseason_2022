package frc.robot.transfer.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.TransferConstants;
import frc.robot.transfer.TransferSubsystem;

//DONE
public class TransferReverse extends CommandBase {
    private TransferSubsystem transfer;

    public TransferReverse(TransferSubsystem transferSubsystem) {
        addRequirements(transferSubsystem);
        transfer=transferSubsystem;
    }

    /*
     * Run the transfer at the percent speed defined in TransferConstants
     */
    @Override
    public void initialize() {
        transfer.setPercentSpeed(TransferConstants.TRANSFER_REVERSE_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
    }
}
