package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.TurrentConstants.*;

/*
 * A class to control the hardware associated with the turret subsystem
 */

public class TurretSubsystem extends SubsystemBase {
    private TalonFX turretMotor;

    /*
     * Initialize hardware
     * 1 Master TalonFX 
     */
    public TurretSubsystem() {
        turretMotor = new TalonFX(TURRENT_ID);
    }

    /*
     * Set the position of the turrent
     */
    public void setPosition(double position) {
        turretMotor.set(ControlMode.Position, position);
    }

    /*
     * Get the current position of the turret
     */
    public double getPosition() {
        return turretMotor.getSelectedSensorPosition();
    }
}

