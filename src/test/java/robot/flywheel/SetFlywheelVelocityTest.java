package robot.flywheel;

import static org.junit.Assert.*;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.simulation.DriverStationSim;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
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
        CommandScheduler.getInstance().enable(); 
        DriverStationSim.setEnabled(true);

        flywheelSubsystem = new FlywheelSubsystem();
    }

    @Test
    public void setVelocity0(){
        StopFlywheel stopFlywheelCommand = new StopFlywheel(flywheelSubsystem);
        CommandScheduler.getInstance().schedule(stopFlywheelCommand);

        runScheduler(0.5);
        assertEquals("Stops flywheel", flywheelSubsystem.getPercentSpeed(), 0.0, DELTA);
    }

    @Test
    public void setVelocity100(){
        SetFlywheelVelocity setVelocityCommand100 = new SetFlywheelVelocity(flywheelSubsystem, 1.0);
        CommandScheduler.getInstance().schedule(setVelocityCommand100);

        runScheduler(0.5);
        assertEquals("Set Speed to 100", flywheelSubsystem.getPercentSpeed(), 1.0, DELTA);
    }

    @Test
    public void setVelocity50(){
        SetFlywheelVelocity setVelocityCommand50 = new SetFlywheelVelocity(flywheelSubsystem, 0.5);
        CommandScheduler.getInstance().schedule(setVelocityCommand50);

        runScheduler(0.5);
        assertEquals("Set Speed to 50%", flywheelSubsystem.getPercentSpeed(), 0.5, DELTA);
    }

    /*
     * Runs the flywheel at 100%, then stops it, then at 50%
    */
    @Test
    public void customVelocityRoutine() {
        SetFlywheelVelocity setVelocityCommand100 = new SetFlywheelVelocity(flywheelSubsystem, 1.0);
        CommandScheduler.getInstance().schedule(setVelocityCommand100);

        runScheduler(0.5);
        assertEquals("Set Speed to 100", flywheelSubsystem.getPercentSpeed(), 1.0, DELTA);

        StopFlywheel stopFlywheelCommand = new StopFlywheel(flywheelSubsystem);
        CommandScheduler.getInstance().schedule(stopFlywheelCommand);

        runScheduler(0.5);
        assertEquals("Stops flywheel", flywheelSubsystem.getPercentSpeed(), 0.0, DELTA);

        SetFlywheelVelocity setVelocityCommand50 = new SetFlywheelVelocity(flywheelSubsystem, 0.5);
        CommandScheduler.getInstance().schedule(setVelocityCommand50);

        runScheduler(0.5);
        assertEquals("Set Speed to 50%", flywheelSubsystem.getPercentSpeed(), 0.5, DELTA);
    }

    /*
     * Cancels a command when another command with the same subsystem is run
     */
    @Test
    public void subsystemRequirementsSet() {
        SetFlywheelVelocity setVelocityCommand100 = new SetFlywheelVelocity(flywheelSubsystem, 1.0);
        StopFlywheel stopFlywheelCommand = new StopFlywheel(flywheelSubsystem);

        CommandScheduler.getInstance().schedule(setVelocityCommand100);
        CommandScheduler.getInstance().schedule(stopFlywheelCommand);

        runScheduler(0.5);

        boolean isStopScheduled = CommandScheduler.getInstance().isScheduled(stopFlywheelCommand);
        assertEquals(isStopScheduled, true);
        boolean isVelocityScheduled = CommandScheduler.getInstance().isScheduled(setVelocityCommand100);
        assertEquals(isVelocityScheduled, false);
    }

    @Test
    public void checkFollowing() {
        SetFlywheelVelocity setVelocityCommand = new SetFlywheelVelocity(flywheelSubsystem, 0.12);

        CommandScheduler.getInstance().schedule(setVelocityCommand);
        runScheduler(0.5);
        System.out.println(CommandScheduler.getInstance().timeSinceScheduled(setVelocityCommand));
        //run and check both speeds
        assertEquals("Is Right Following Left?", flywheelSubsystem.getPercentSpeed(), flywheelSubsystem.getFollowingPercentSpeed(), DELTA);
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
