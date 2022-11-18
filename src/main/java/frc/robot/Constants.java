// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class IDConstants {
        public static final int PNEUMATICS_HUB_ID = 17;

        public static final int INTAKE_MOTOR_ID = 5;
        public static final int TRANSFER_MOTOR_ID = 4;

        public static final int INTAKE_SOLENOID_LEFT_BACKWARD = 3; //backward is up
        public static final int INTAKE_SOLENOID_RIGHT_BACKWARD = 5;

        public static final int INTAKE_SOLENOID_LEFT_FORWARD = 4; // forward is down
        public static final int INTAKE_SOLENOID_RIGHT_FORWARD = 6;
    }
}
