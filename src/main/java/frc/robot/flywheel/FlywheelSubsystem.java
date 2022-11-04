package frc.robot.flywheel;

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

    public FlywheelSubsystem() {
    }

    /*
     * Stop the flywheel from moving
     */
    public void stopFlywheel() {
    }

    /*
     * Set the speed of the motor using the Percent ControlMode
     */
    public void setPercentSpeed(double percent) {
    }

    /*
     * Get the percent speed of the master motor
     */
    public double getPercentSpeed() {
        return 0.0;
    }

    /*
     * Get the percent speed of the following motor
     */
    public double getFollowingPercentSpeed() {
        return 0.0;
    }


}
