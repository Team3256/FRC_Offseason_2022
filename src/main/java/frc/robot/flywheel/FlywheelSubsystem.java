package frc.robot.flywheel;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FlywheelConstants;

public class FlywheelSubsystem extends SubsystemBase {
    private TalonFX masterLeftShooterMotor;
    private TalonFX followerRightShooterMotor;
    private FlywheelSim flywheelSim;

    public FlywheelSubsystem() {
        if (RobotBase.isReal()) {
            configureRealHardware();
        } else {
            configureSimHardware();
        }
    }

    private void configureRealHardware() {
        masterLeftShooterMotor = new TalonFX(FlywheelConstants.LEFT_CAN_ID);
        followerRightShooterMotor = new TalonFX(FlywheelConstants.RIGHT_CAN_ID);

        followerRightShooterMotor.follow(masterLeftShooterMotor);
    }

    private void configureSimHardware() {
        FlywheelSim flywheelSim =
              new FlywheelSim(DCMotor.getNEO(1), FlywheelConstants.FLYWHEEL_GEARING, FlywheelConstants.FLYWHEEL_INERTIA);
    }

    public void stopFlywheel() {
        masterLeftShooterMotor.neutralOutput();
    }

    public void setPercentSpeed(double percent) {
        masterLeftShooterMotor.set(ControlMode.PercentOutput, percent);
    }

    public double getPercentSpeed() {
        return masterLeftShooterMotor.getMotorOutputPercent();
    }

    public double getFollowingPercentSpeed() {
        return followerRightShooterMotor.getMotorOutputPercent();
    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }
}
