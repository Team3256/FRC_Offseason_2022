package frc.robot.helper;


import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.simulation.DriverStationSim;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.intake.IntakeSubsystem;
import frc.robot.intake.commands.ForwardOn;
import frc.robot.intake.commands.ReverseOn;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ControllerTest {
    public static final double DELTA = 0.05; // acceptable deviation range
//    IntakeSubsystem intakeSubsystem;

    @Before
    public void setup() {
        assert HAL.initialize(500, 0); // initialize the HAL, crash if failed
        CommandScheduler.getInstance().enable();
        DriverStationSim.setEnabled(true);
//        intakeSubsystem = new IntakeSubsystem();

    }



    //add tests for different command groups
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
