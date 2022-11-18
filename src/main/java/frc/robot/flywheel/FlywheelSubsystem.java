package frc.robot.flywheel;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FlywheelConstants;

/*
 * A class to control the hardware associated with the flywheeel subsystem
 */
// TODO: Finish this class
public class FlywheelSubsystem extends SubsystemBase {
    WPI_TalonFX leftMaster;
    WPI_TalonFX rightFollower;

    /*
     * Initialize hardware
     * 1 Master WPI_TalonFX (Left)
     * 1 Follower WPI_TalonFX (Right)
     * Total: 2 TalonFX motors
     */
    public FlywheelSubsystem() {
        leftMaster = new WPI_TalonFX(FlywheelConstants.LEFT_CAN_ID);
        rightFollower = new WPI_TalonFX(FlywheelConstants.RIGHT_CAN_ID);
        rightFollower.follow(leftMaster);
    }

    /*
     * Stop the flywheel from moving
     */
    public void stopFlywheel() {
        leftMaster.neutralOutput();
    }

    /*
     * Set the voltage of the motor 
     */
    public void setVoltage(double voltage) {
        leftMaster.setVoltage(voltage);
    }

    /*
     * Get the selected sensor velocity of the master motor and convert to rpm
     */
    public double getVelocity() {
        return rightFollower.getSelectedSensorVelocity() * 600/2048;
    }

    /*
     * Get the seleceted sensor velocity of the following motor
     */
    public double getFollowingVelocity() {
        return rightFollower.getSelectedSensorVelocity() * 600/2048;
    }


}
