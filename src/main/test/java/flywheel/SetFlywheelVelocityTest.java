import static org.junit.Assert.*;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.simulation.DoubleSolenoidSim;
import edu.wpi.first.wpilibj.simulation.PWMSim;
import frc.robot.Constants.IntakeConstants;
import org.junit.*;

public class SetFlywheelVelocityTest {
    public static final double DELTA = 1e-2; // acceptable deviation range
    Intake intake;
    PWMSim simMotor;
    DoubleSolenoidSim simPiston;

    @Before // this method will run before each test
    public void setup() {
        assert HAL.initialize(500, 0); // initialize the HAL, crash if failed
    }

    @Test
    public void test1() {

    }

}
