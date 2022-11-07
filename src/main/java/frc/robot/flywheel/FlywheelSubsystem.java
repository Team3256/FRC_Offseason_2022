package frc.robot.flywheel;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.flywheel.commands.StopFlywheel;

import static frc.robot.Constants.FlywheelConstants;

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
    TalonFX left = new TalonFX(FlywheelConstants.LEFT_CAN_ID);
    TalonFX right = new TalonFX(FlywheelConstants.RIGHT_CAN_ID);

    public FlywheelSubsystem() {
        right.follow(left);
    }

    /*
     * Stop the flywheel from moving
     */
    public void stopFlywheel() {
        left.set(ControlMode.PercentOutput,0);
    }

    /*
     * Set the speed of the motor using the Percent ControlMode
     */
    public void setPercentSpeed(double percent) {
        left.set(ControlMode.PercentOutput,percent);
    }

    /*
     * Get the percent speed of the master motor
     */
    public double getPercentSpeed() {
        return left.getMotorOutputPercent();
    }

    /*
     * Get the percent speed of the following motor
     */
    public double getFollowingPercentSpeed() {
        return right.getMotorOutputPercent();
    }
}
