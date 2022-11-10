package frc.robot.flywheel;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FlywheelConstants;

/*
 * A class to control the hardware associated with the flywheel subsystem
 */
public class FlywheelSubsystem extends SubsystemBase {
    /*
     * Initialize hardware
     * 1 Master TalonFX (Left)
     * 1 Follower TalonFX (Right)
     * Total: 2 TalonFX motors
     */

    private TalonFX motorLeft;
    private TalonFX motorRight;

    public FlywheelSubsystem() {
        motorLeft = new TalonFX(FlywheelConstants.LEFT_CAN_ID);
        motorRight = new TalonFX(FlywheelConstants.RIGHT_CAN_ID);
        motorLeft.follow(motorRight);
    }

    /*
     * Stop the flywheel from moving
     */
    public void stopFlywheel() {
        motorRight.neutralOutput();
    }

    /*
     * Set the speed of the motor using the Percent ControlMode
     */
    public void setPercentSpeed(double percent) {
        motorRight.set(ControlMode.PercentOutput, percent);
    }

    /*
     * Get the percent speed of the master motor
     */
    public double getPercentSpeed() {
        return motorRight.getMotorOutputPercent();
    }

    /*
     * Get the percent speed of the following motor
     */
    public double getFollowingPercentSpeed() {
        return motorLeft.getMotorOutputPercent();
    }

}
