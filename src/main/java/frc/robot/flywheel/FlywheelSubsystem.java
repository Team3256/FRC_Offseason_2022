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
    }

    /*
     * Stop the flywheel from moving
     */
    public void stopFlywheel() {
    }

    /*
     * Set the voltage of the motor 
     */
    public void setVoltage(double voltage) {
    }

    /*
     * Get the selected sensor velocity of the master motor and convert to rpm
     */
    public double getVelocity() {
        // conversion factor: 600/2048;
        return 0.0;
    }

    /*
     * Get the seleceted sensor velocity of the following motor
     */
    public double getFollowingVelocity() {
        // conversion factor: 600/2048;
        return 0.0;
    }


}
