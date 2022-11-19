package frc.robot.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import static frc.robot.Constants.IDConstants.*;


//DONE
public class IntakeSubsystem extends SubsystemBase {
    private TalonFX motor;
    private DoubleSolenoid leftSolenoid;
    private DoubleSolenoid rightSolenoid;

    public IntakeSubsystem(){
        motor = new TalonFX(INTAKE_MOTOR_ID);
        leftSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH,INTAKE_SOLENOID_LEFT_FORWARD, INTAKE_SOLENOID_LEFT_BACKWARD);
        rightSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH,INTAKE_SOLENOID_RIGHT_FORWARD, INTAKE_SOLENOID_RIGHT_BACKWARD);
    }

    public void setPercentSpeed(double percentSpeed){
        motor.set(TalonFXControlMode.PercentOutput, percentSpeed);
    }

    /*
     * Turn off the intake motor
     */
    public void off(){ motor.neutralOutput(); }

    public double getPercentSpeed(){
        return motor.getMotorOutputPercent();
    }

    /* 
     * Set both left and right solenoids to kForward
     */
    public void extend(){
        leftSolenoid.set(DoubleSolenoid.Value.kForward);
        rightSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    /* 
     * Set both left and right solenoids to kReverse
     */
    public void retract(){
        leftSolenoid.set(DoubleSolenoid.Value.kReverse);
        rightSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    /*
     * Return the state of the left solenoid
     */
    public DoubleSolenoid.Value getLeftSolenoid(){
        return leftSolenoid.get();
    }

    /*
     * Return the state of the right solenoid
     */
    public DoubleSolenoid.Value getRightSolenoid(){ return rightSolenoid.get(); }
}
