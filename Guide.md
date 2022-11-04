# Guide
Contains helpful information for software and assignments

## Documentation (Docs)
1. [FRC Docs](https://docs.wpilib.org/en/stable/index.html)
2. [WPILib Docs](https://first.wpi.edu/wpilib/allwpilib/docs/release/java/index.html)
3. [Team 3256 2022 Code](https://github.com/Team3256/FRC_Programming_2022) (For Reference)
## Hardware
### Talon FX Motors
> Following Motors


1. Create a leading motor and a following motor.
2. Set the following motor to follow the leading motor

Example:
``` 
TalonFX followingMotor = new TalonFX(id);
followingMotor.follow(masterMotor);
```

### Commands

1. Create a new file for each command
2. Put the subsystems used in a command as dependencies
3. Each command should have `initialize`, `execute`, and `end` methods. Reference commands from 2022 FRC code

Example Command:
```
public class CommandName extends CommandBase {
    private IntakeSubsystem intake;
    public CommandName(IntakeSubsystem intake){
        this.intake = intake;
    }
    
    public void initialize() {...}
    public void execute() {...}
    public void end(boolean interrupted) {...}
}
```

### Checking Assignments in Terminal
Run `./gradlew test` in Terminal



