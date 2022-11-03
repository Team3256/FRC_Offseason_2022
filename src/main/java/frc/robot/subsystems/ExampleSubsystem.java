// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    public ExampleSubsystem() {
        if (RobotBase.isReal()) {
            realInit();
        } else {
            simInit();
        }
    }

    private void realInit() {

    }

    private void simInit() {

    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }
}
