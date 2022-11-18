package frc.robot.intake;

import static org.junit.Assert.*;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.simulation.DriverStationSim;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.intake.commands.ForwardOn;
import frc.robot.intake.commands.ReverseOn;
import org.junit.*;

public class IntakeTest {
    public static final double DELTA = 0.05; // acceptable deviation range
    IntakeSubsystem intakeSubsystem;

    @Before
    public void setup() {
        assert HAL.initialize(500, 0); // initialize the HAL, crash if failed
        CommandScheduler.getInstance().enable();
        DriverStationSim.setEnabled(true);

    }

    @Test
    public void checkExtend() {
        intakeSubsystem = new IntakeSubsystem();
        intakeSubsystem.extend();

        assertEquals("message", intakeSubsystem.getLeftSolenoid(), DoubleSolenoid.Value.kForward);
        assertEquals("message", intakeSubsystem.getLeftSolenoid(), DoubleSolenoid.Value.kForward);
    }

    @Test
    public void checkRetract() {
        intakeSubsystem = new IntakeSubsystem();
        intakeSubsystem.retract();

        assertEquals("message", intakeSubsystem.getLeftSolenoid(), DoubleSolenoid.Value.kReverse);
        assertEquals("message", intakeSubsystem.getLeftSolenoid(), DoubleSolenoid.Value.kReverse);
    }

    @Test
    public void checkPercentSpeed() {
        try {
            ForwardOn forwardOnCommand = new ForwardOn(intakeSubsystem);
            ReverseOn reverseOnCommand = new ReverseOn(intakeSubsystem);

            CommandScheduler.getInstance().schedule(forwardOnCommand);
            runScheduler(0.5);
            assertEquals("Ran intake forward command with 75% speed", intakeSubsystem.getPercentSpeed(), 0.75, DELTA);

            CommandScheduler.getInstance().schedule(reverseOnCommand);
            runScheduler(0.5);
            assertEquals("Ran intake reverse command with 25% speed", intakeSubsystem.getPercentSpeed(), -0.25, DELTA);
        }
        catch(Exception e) {
            System.out.println("Error with ForwardOn command or ReverseOn command");
        }
    }
    /*
     * Cancels a command when another command with the same subsystem is run
     */
    @Test
    public void subsystemRequirementsSet() {
        try {
            ForwardOn forwardOnCommand = new ForwardOn(intakeSubsystem);
            ReverseOn reverseOnCommand = new ReverseOn(intakeSubsystem);

            CommandScheduler.getInstance().schedule(forwardOnCommand);
            CommandScheduler.getInstance().schedule(reverseOnCommand);

            runScheduler(0.5);

            boolean isReverseScheduled = CommandScheduler.getInstance().isScheduled(reverseOnCommand);
            assertEquals(isReverseScheduled, true);
            boolean isForwardScheduled = CommandScheduler.getInstance().isScheduled(forwardOnCommand);
            assertEquals(isForwardScheduled, false);

        } catch (Exception e){
            System.err.println("addRequirements not set in commands");
        }

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
