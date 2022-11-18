package frc.robot.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.IDConstants;
import frc.robot.Constants.IntakeConstants;


public class IntakeSubsystem extends SubsystemBase {

    /*
        Create 1 TalonFX intake Motor
        Create 2 DoubleSolenoid intake objects
     */

    private final TalonFX intakeMotor;
    private final DoubleSolenoid leftSolenoid;
    private final DoubleSolenoid rightSolenoid;

    public IntakeSubsystem(){
        intakeMotor = new TalonFX(IDConstants.INTAKE_MOTOR_ID);
        leftSolenoid = new DoubleSolenoid(IDConstants.PNEUMATICS_HUB_ID, PneumaticsModuleType.REVPH, 11, 12);
        rightSolenoid = new DoubleSolenoid(IDConstants.PNEUMATICS_HUB_ID, PneumaticsModuleType.REVPH, 5, 6);
    }

    public void setPercentSpeed(double percentSpeed){
        intakeMotor.set(ControlMode.PercentOutput, percentSpeed);
    }

    public double getPercentSpeed(){
        return intakeMotor.getMotorOutputPercent();
    }

    public void extend(){
        leftSolenoid.set(DoubleSolenoid.Value.kForward);
        rightSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void retract(){
        leftSolenoid.set(DoubleSolenoid.Value.kReverse);
        rightSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public DoubleSolenoid.Value getLeftSolenoid(){
        return leftSolenoid.get();
    }

    public DoubleSolenoid.Value getRightSolenoid(){
        return rightSolenoid.get();
    }

    public void off(){
        intakeMotor.neutralOutput();
    }

}
