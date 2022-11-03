package robot.flywheel;

import static org.junit.Assert.*;
import edu.wpi.first.hal.HAL;
import org.junit.*;

public class SetFlywheelVelocityTest {
    public static final double DELTA = 1e-2; // acceptable deviation range


    @Before
    public void setup() {
        assert HAL.initialize(500, 0); // initialize the HAL, crash if failed
    }

    @Test
    public void test1() {

    }

}
