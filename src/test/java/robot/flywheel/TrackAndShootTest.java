package robot.flywheel;

import static org.junit.Assert.*;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.simulation.DriverStationSim;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.flywheel.FlywheelSubsystem;
import frc.robot.flywheel.commands.SetFlywheelVelocityFromPID;
import frc.robot.turret.TurretSubsystem;
import frc.robot.turret.commands.SetTurretPosition;

import org.junit.*;

public class TrackAndShootTest {
    public static final double DELTA = 10; // acceptable deviation range
    FlywheelSubsystem flywheelSubsystem;

    @Before
    public void setup() {
        assert HAL.initialize(500, 0); // initialize the HAL, crash if failed
        CommandScheduler.getInstance().enable(); 
        DriverStationSim.setEnabled(true);

        flywheelSubsystem = new FlywheelSubsystem();
    }

    private static void runScheduler(double seconds) {
        try {
            for (int i = 0; i < 10; ++i) {
                com.ctre.phoenix.unmanaged.Unmanaged.feedEnable(100);
                CommandScheduler.getInstance().run();
                Thread.sleep((long) (seconds * 100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
