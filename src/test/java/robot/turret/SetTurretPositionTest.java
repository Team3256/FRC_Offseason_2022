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

public class SetTurretPositionTest {
    public static final double DELTA = 10; // acceptable deviation range
    TurretSubsystem turretSubsystem;

    @Before
    public void setup() {
        assert HAL.initialize(500, 0); // initialize the HAL, crash if failed
        CommandScheduler.getInstance().enable(); 
        DriverStationSim.setEnabled(true);

        turretSubsystem = new TurretSubsystem();
    }

    @Test
    public void setTurretPosition(){
        SetTurretPosition setTurretPosition = new SetTurretPosition(turretSubsystem, () -> 3000000);
        turretSubsystem.setPosition(3000);
        CommandScheduler.getInstance().schedule(setTurretPosition);

        runScheduler(5);
        System.out.println(turretSubsystem.getPosition());
        assertEquals("Set turret position to 3000", turretSubsystem.getPosition(), 3000, DELTA);
    }

    private static void runScheduler(double seconds) {
        try {
            for (int i = 0; i < seconds * 1000 / 20; ++i) {
                com.ctre.phoenix.unmanaged.Unmanaged.feedEnable(100);
                CommandScheduler.getInstance().run();
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
