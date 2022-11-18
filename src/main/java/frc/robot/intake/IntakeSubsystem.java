package frc.robot.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.IDConstants.*;


// TODO: Finish this class
public class IntakeSubsystem extends SubsystemBase {

    /*
        Create 1 TalonFX intake Motor
        Create 2 DoubleSolenoid intake objects (left and right)
     */

    public IntakeSubsystem(){
    }

    public void setPercentSpeed(double percentSpeed){
    }

    public double getPercentSpeed(){
        return 0.0;
    }

    /* 
     * Set both left and right solenoids to kForward
     */
    public void extend(){
    }

    /* 
     * Set both left and right solenoids to kReverse
     */
    public void retract(){
    }

    /*
     * Return the state of the left solenoid
     */
    public DoubleSolenoid.Value getLeftSolenoid(){
        return DoubleSolenoid.Value.kOff;
    }

    /*
     * Return the state of the right solenoid
     */
    public DoubleSolenoid.Value getRightSolenoid(){
        return DoubleSolenoid.Value.kOff;
    }

    /*
     * Turn off the intake motor
     */
    public void off(){
    }

}
