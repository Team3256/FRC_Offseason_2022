// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class FlywheelConstants {
        public static final int LEFT_CAN_ID = 10;
        public static final int RIGHT_CAN_ID = 11;
        public static final double FLYWHEEL_INERTIA =
              0.5 * Units.lbsToKilograms(2) * Math.pow(Units.inchesToMeters(3), 2); // 1/2*M*R^2
        public static final double FLYWHEEL_GEARING = 1.0;

        public static final double KP = 0.01;
        public static final double KI = 0.0;
        public static final double KD = 0.0;
        public static final double KFF = 0.0;
    }

    public static class SimConstants {
        public static final double VOLTAGE_NOISE_RANGE = 0.0;
    }
}
