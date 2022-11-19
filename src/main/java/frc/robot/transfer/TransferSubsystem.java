package frc.robot.transfer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.networktables.TableListener;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.IDConstants;

//DONE
public class TransferSubsystem extends SubsystemBase {
    private TalonFX motor;

    public TransferSubsystem(){
        motor = new TalonFX(IDConstants.TRANSFER_MOTOR_ID);
    }

    public void setPercentSpeed(double percentSpeed){
        motor.set(TalonFXControlMode.PercentOutput, percentSpeed);
    }

    public double getPercentSpeed(){
        return motor.getMotorOutputPercent();
    }

    public void off(){
        motor.neutralOutput();
    }
}
