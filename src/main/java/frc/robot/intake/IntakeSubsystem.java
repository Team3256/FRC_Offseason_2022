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
        Create 2 DoubleSolenoid intake objects (left and right)
     */
    private TalonFX intakeMotor;
    private DoubleSolenoid left, right;

    public IntakeSubsystem(){
        intakeMotor = new TalonFX(INTAKE_MOTOR_ID);

        left = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,INTAKE_SOLENOID_LEFT_FORWARD, INTAKE_SOLENOID_LEFT_BACKWARD);
        right = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,INTAKE_SOLENOID_RIGHT_FORWARD, INTAKE_SOLENOID_RIGHT_BACKWARD);
    }

    public void setPercentSpeed(double percentSpeed){
        intakeMotor.set(ControlMode.PercentOutput, percentSpeed);
    }

    public double getPercentSpeed(){
        return intakeMotor.getMotorOutputPercent();
    }

    /* 
     * Set both left and right solenoids to kForward
     */
    public void extend(){
        left.set(DoubleSolenoid.Value.kForward);
        right.set(DoubleSolenoid.Value.kForward);
    }

    /* 
     * Set both left and right solenoids to kReverse
     */
    public void retract(){
        left.set(DoubleSolenoid.Value.kReverse);
        left.set(DoubleSolenoid.Value.kReverse);
    }

    /*
     * Return the state of the left solenoid
     */
    public DoubleSolenoid.Value getLeftSolenoid(){
        return left.get();
    }

    /*
     * Return the state of the right solenoid
     */
    public DoubleSolenoid.Value getRightSolenoid(){
        return right.get();
    }

    /*
     * Turn off the intake motor
     */
    public void off(){
        intakeMotor.neutralOutput();
    }

}
