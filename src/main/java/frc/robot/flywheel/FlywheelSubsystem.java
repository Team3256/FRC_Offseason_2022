package frc.robot.flywheel;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.FlywheelConstants;

import javax.swing.plaf.basic.BasicSplitPaneUI;

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
    private TalonFX mainMotor;
    private TalonFX followMotor;
    public FlywheelSubsystem() {
        mainMotor = new TalonFX(FlywheelConstants.LEFT_CAN_ID);
        followMotor = new TalonFX(FlywheelConstants.RIGHT_CAN_ID);
        followMotor.follow(mainMotor);
    }

    /*
     * Stop the flywheel from moving
     */
    public void stopFlywheel() {
        mainMotor.set(TalonFXControlMode.PercentOutput, 0.0);
    }

    /*
     * Set the speed of the motor using the Percent ControlMode
     */
    public void setPercentSpeed(double percent) {
        mainMotor.set(TalonFXControlMode.Velocity, percent);
    }

    /*
     * Get the percent speed of the motor
     */
    public double getPercentSpeed() {
        return mainMotor.getMotorOutputPercent();
    }
    public double getFollowingPercentSpeed() {
        return followMotor.getMotorOutputPercent();
    }
}
