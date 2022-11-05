package frc.robot.flywheel;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
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
    TalonFX adi;
    TalonFX acky;
    public FlywheelSubsystem() {
        adi = new TalonFX(FlywheelConstants.LEFT_CAN_ID);
        acky = new TalonFX(FlywheelConstants.RIGHT_CAN_ID);

        acky.follow(adi);
    }
    /*
     * Stop the flywheel from moving
     */
    public void stopFlywheel() {
         adi.neutralOutput();
    }

    /*
     * Set the speed of the motor using the Percent ControlMode
     */
    public void setPercentSpeed(double percent) {
        adi.set(ControlMode.PercentOutput , percent);
    }

    /*
     * Get the percent speed of the master motor
     */
    public double getPercentSpeed() {
        return adi.getMotorOutputPercent();
    }

    /*
     * Get the percent speed of the following motor
     */
    public double getFollowingPercentSpeed() {
        return acky.getMotorOutputPercent();
    }


}
