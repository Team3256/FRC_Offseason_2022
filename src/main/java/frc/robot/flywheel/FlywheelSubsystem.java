package frc.robot.flywheel;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FlywheelConstants;

/*
 * A class to control the hardware associated with the flywheeel subsystem
 */
public class FlywheelSubsystem extends SubsystemBase {
    /*
     * Initialize hardware
     * 1 Master TalonFX (Left)
     * 1 Follower TalonFX (Right)
     * Total: 2 TalonFX motors
     */

    public TalonFX masterMotor;
    public TalonFX followerMotor;

    public FlywheelSubsystem() {
        masterMotor = new TalonFX(FlywheelConstants.LEFT_CAN_ID);
        followerMotor = new TalonFX(FlywheelConstants.RIGHT_CAN_ID);

        followerMotor.follow(masterMotor);
    }

    /*
     * Stop the flywheel from moving
     */
    public void stopFlywheel() {
        this.masterMotor.neutralOutput();
        this.followerMotor.neutralOutput();
    }

    /*
     * Set the speed of the motor using the Percent ControlMode
     */
    public void setPercentSpeed(double percent) {
        this.masterMotor.set(TalonFXControlMode.PercentOutput, percent);
    }

    /*
     * Get the percent speed of the master motor
     */
    public double getPercentSpeed() {
        return this.masterMotor.getMotorOutputPercent();
    }

    /*
     * Get the percent speed of the following motor
     */
    public double getFollowingPercentSpeed() {
        return this.followerMotor.getMotorOutputPercent();
    }


}
