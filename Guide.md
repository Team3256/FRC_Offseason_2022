# Guide
Contains helpful information for developing and debugging software for FRC.

## Documentation
1. [FRC Docs](https://docs.wpilib.org/en/stable/index.html)
2. [WPILib Docs](https://first.wpi.edu/wpilib/allwpilib/docs/release/java/index.html)
3. [Team 3256 2022 Code](https://github.com/Team3256/FRC_Programming_2022) (For Reference)
## Git
###Pushing Code
>Standard Method
```java
git add .
git commit -m"<Your commit message>"
git pull
git push
```
>Merge Conflicts

Either (more common) merge your code with `git merge`. If you don't want to merge then temporarily shelve your changes before pulling with `git stash`
###Creating a branch
Give branches descriptive names (all lower case), replace spaces with “-”, prefix with “feature” or “fix". Good examples include `fix/5-ball-auto`, `feature/transfer-subsystem`, `feature/acceleration-limiting`.
> Creating a pull request

Go to the pull request tab on GitHub and select New pull request. Link the pull request to the proper GitHub issue if there is any. Add at least one lead as a reviewer.     
## Hardware
### Talon FX Motors
> Following Motors
1. Create a leading motor and a following motor.
2. Set the following motor to follow the leading motor

Example:
```java 
TalonFX followingMotor = new TalonFX(id);
followingMotor.follow(masterMotor);
```

###Pneumatics
>Double Solenoids
 
Example 
```java
DoubleSolenoid example = new DoubleSolenoid(PNEUMATICS_HUB_ID, PneumaticsModuleType.REVPH, FORWARD_ID, BACKWARD_ID);
```
###Flashing the Radio


### Commands

1. Create a new file for each command
2. Put the subsystems used in a command as dependencies
3. Each command should have `initialize`, `execute`, and `end` methods. Reference commands from 2022 FRC code

Example Command:
```java
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

> Command Groups

 
> Lambdas in Java 

###PID Controllers with feed forward

###Logging and debugging

###Vision and Odometry

### Checking Assignments in Terminal
Run `./gradlew test` in Terminal



