package robot.flywheel;

import static org.junit.Assert.*;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.flywheel.FlywheelSubsystem;
import frc.robot.flywheel.commands.SetFlywheelVelocity;
import frc.robot.flywheel.commands.StopFlywheel;

import org.junit.*;

public class SetFlywheelVelocityTest {
    public static final double DELTA = 0.05; // acceptable deviation range
    FlywheelSubsystem flywheelSubsystem;

    @Before
    public void setup() {
        assert HAL.initialize(500, 0); // initialize the HAL, crash if failed
        flywheelSubsystem = new FlywheelSubsystem();
    }

    @Test
    public void checkFollowing() {
        SetFlywheelVelocity setVelocityCommand = new SetFlywheelVelocity(flywheelSubsystem, 0.12);

        //run and check both speeds
        runCommandForSeconds(0.5, setVelocityCommand);
        assertEquals("Is Right Following Left?", flywheelSubsystem.getPercentSpeed(), flywheelSubsystem.getFollowingPercentSpeed(), DELTA);
    }

    /*
     * Runs the flywheel at 100%, then stops it, then at 50%
    */
    @Test()
    public void customVelocityRoutine() {
        SetFlywheelVelocity setVelocityCommand100 = new SetFlywheelVelocity(flywheelSubsystem, 1.0);
        runCommandForSeconds(0.5, setVelocityCommand100);
        assertEquals("Set Speed to 100", flywheelSubsystem.getPercentSpeed(), 1.0, DELTA);

        StopFlywheel stopFlywheelCommand = new StopFlywheel(flywheelSubsystem);
        runCommandForSeconds(0.5, stopFlywheelCommand);
        assertEquals("Stops flywheel", flywheelSubsystem.getPercentSpeed(), 0.0, DELTA);

        SetFlywheelVelocity setVelocityCommand50 = new SetFlywheelVelocity(flywheelSubsystem, 0.5);
        runCommandForSeconds(0.5, setVelocityCommand50);
        assertEquals("Set Speed to 50%", flywheelSubsystem.getPercentSpeed(), 0.5, DELTA);
    }

     private static void runCommandForSeconds(double seconds, Command... commands) {
        for (Command c : commands) {
            c.initialize();
        }
        try {
            for (int i = 0; i < 10; ++i) {
                com.ctre.phoenix.unmanaged.Unmanaged.feedEnable(100);
                for (Command c : commands) {
                    c.execute();
                }
                Thread.sleep((long) (seconds * 100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
