package frc.robot.flywheel;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.simulation.BatterySim;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj.simulation.RoboRioSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FlywheelConstants;
import frc.robot.Constants.SimConstants;

public class FlywheelSubsystem extends SubsystemBase {
    public class PeriodicIO {
        // inputs
        public double voltage = 0;
        public double lastUpdateTime = -1;
        
        // outputs
        public double angularVelocity = 0;
        public double currentDrawAmps = 0;

        public double getDt(double currentTime) {
            if (lastUpdateTime != -1) {
                return currentTime - lastUpdateTime;
            } else {
                return 0.02; // Average loop rate, use if its first loop
            }
        }
    }

    private PeriodicIO periodicIO;

    private TalonFX masterLeftShooterMotor;
    private TalonFX followerRightShooterMotor;
    private FlywheelSim flywheelSim;

    public FlywheelSubsystem() {
        periodicIO = new PeriodicIO();

        if (RobotBase.isReal()) {
            configureRealHardware();
        } else {
            configureSimHardware();
        }
    }

    private void configureRealHardware() {
        masterLeftShooterMotor = new TalonFX(FlywheelConstants.LEFT_CAN_ID);
        masterLeftShooterMotor.enableVoltageCompensation(true);
        followerRightShooterMotor = new TalonFX(FlywheelConstants.RIGHT_CAN_ID);

        followerRightShooterMotor.follow(masterLeftShooterMotor);
    }

    private void configureSimHardware() {
        flywheelSim =
              new FlywheelSim(DCMotor.getFalcon500(2), FlywheelConstants.FLYWHEEL_GEARING, FlywheelConstants.FLYWHEEL_INERTIA);
    }

    public void stopFlywheel() {
        masterLeftShooterMotor.neutralOutput();
    }

    public void setInputVoltage(double voltage) {
        periodicIO.voltage = MathUtil.clamp(voltage, 0, 12);
        if (RobotBase.isSimulation()) {
            flywheelSim.setInputVoltage(periodicIO.voltage);
        } else {
            masterLeftShooterMotor.set(ControlMode.PercentOutput, periodicIO.voltage / 12);
        }
    }

    public double getAngularVelocityRPM() {
        return periodicIO.angularVelocity;
    }

    @Override
    public void simulationPeriodic() {
        double currentTime = Timer.getFPGATimestamp();
        flywheelSim.update(periodicIO.getDt(currentTime));
        
        periodicIO.lastUpdateTime = currentTime;
        periodicIO.angularVelocity = flywheelSim.getAngularVelocityRPM();
        periodicIO.currentDrawAmps = flywheelSim.getCurrentDrawAmps();

        RoboRioSim.setVInVoltage(
            BatterySim.calculateDefaultBatteryLoadedVoltage(flywheelSim.getCurrentDrawAmps()));

        simulationOutputToDashboard();
    }

    private void simulationOutputToDashboard() {
        SmartDashboard.putNumber("Flywheel Angular Velocity", periodicIO.angularVelocity);
        SmartDashboard.putNumber("Current Draw", periodicIO.currentDrawAmps);
        SmartDashboard.putNumber("Flywheel Voltage", periodicIO.voltage);
    }
}
