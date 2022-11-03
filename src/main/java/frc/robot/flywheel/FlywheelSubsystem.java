package frc.robot.flywheel;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FlywheelConstants;

public class FlywheelSubsystem extends SubsystemBase {
    private TalonFX masterLeftShooterMotor;
    private TalonFX followerRightShooterMotor;

    public FlywheelSubsystem() {
        if (RobotBase.isReal()) {
            realInit();
        } else {
            simInit();
        }
    }

    private void realInit() {
        masterLeftShooterMotor = new TalonFX(FlywheelConstants.LEFT_CAN_ID);
        followerRightShooterMotor = new TalonFX(FlywheelConstants.RIGHT_CAN_ID);

        followerRightShooterMotor.follow(masterLeftShooterMotor);
    }

    private void simInit() {

    }

    public void stopFlywheel() {
        masterLeftShooterMotor.neutralOutput();
    }

    public void setPercentSpeed(double percent) {
        masterLeftShooterMotor.set(ControlMode.PercentOutput, percent);
    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }
}
