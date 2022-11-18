package frc.robot.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.IDConstants.*;


public class IntakeSubsystem extends SubsystemBase {

    /*
        Create 1 TalonFX intake Motor
        Create 2 DoubleSolenoid intake objects
     */

    private final TalonFX intakeMotor;
    private final DoubleSolenoid leftSolenoid;
    private final DoubleSolenoid rightSolenoid;

    public IntakeSubsystem(){
        intakeMotor = new TalonFX(INTAKE_MOTOR_ID);
        leftSolenoid = new DoubleSolenoid(PNEUMATICS_HUB_ID, PneumaticsModuleType.REVPH, INTAKE_SOLENOID_LEFT_FORWARD, INTAKE_SOLENOID_LEFT_BACKWARD);
        rightSolenoid = new DoubleSolenoid(PNEUMATICS_HUB_ID, PneumaticsModuleType.REVPH, INTAKE_SOLENOID_RIGHT_FORWARD, INTAKE_SOLENOID_RIGHT_BACKWARD);
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
