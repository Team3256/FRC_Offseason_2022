package frc.robot.transfer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.networktables.TableListener;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.IDConstants;

public class TransferSubsystem extends SubsystemBase {

    public TransferSubsystem(){
        transferMotor = new TalonFX(IDConstants.TRANSFER_MOTOR_ID);
    }

    public void setPercentSpeed(double percentSpeed){
        transferMotor.set(ControlMode.PercentOutput, percentSpeed);
    }

    public double getPercentSpeed(){
        return transferMotor.getMotorOutputPercent();
    }

    public void off(){
        transferMotor.neutralOutput();
    }
}