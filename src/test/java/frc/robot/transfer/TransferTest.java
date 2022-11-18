package frc.robot.transfer;


import static org.junit.Assert.*;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.simulation.DriverStationSim;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import org.junit.*;

public class TransferTest {
    public static final double DELTA = 0.05; // acceptable deviation range
    TransferSubsystem transferSubsystem;


    public void setup() {
        assert HAL.initialize(500, 0); // initialize the HAL, crash if failed
        CommandScheduler.getInstance().enable();
        DriverStationSim.setEnabled(true);

        transferSubsystem = new TransferSubsystem();
    }


    public void customVelocityRoutine() {
//        SetFlywheelVelocity setVelocityCommand50 = new SetFlywheelVelocity(flywheelSubsystem, 0.5);
//        CommandScheduler.getInstance().schedule(setVelocityCommand50);
//
//        runScheduler(0.5);
//        assertEquals("Set Speed to 50%", flywheelSubsystem.getPercentSpeed(), 0.5, DELTA);
    }

    /*
     * Cancels a command when another command with the same subsystem is run
     */

    public void subsystemRequirementsSet() {
//        SetFlywheelVelocity setVelocityCommand100 = new SetFlywheelVelocity(flywheelSubsystem, 1.0);
//        StopFlywheel stopFlywheelCommand = new StopFlywheel(flywheelSubsystem);
//
//        CommandScheduler.getInstance().schedule(setVelocityCommand100);
//        CommandScheduler.getInstance().schedule(stopFlywheelCommand);
//
//        runScheduler(0.5);
//
//        boolean isStopScheduled = CommandScheduler.getInstance().isScheduled(stopFlywheelCommand);
//        assertEquals(isStopScheduled, true);
//        boolean isVelocityScheduled = CommandScheduler.getInstance().isScheduled(setVelocityCommand100);
//        assertEquals(isVelocityScheduled, false);
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