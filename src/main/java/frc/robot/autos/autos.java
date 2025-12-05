package frc.robot.autos;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.DriveCommands;


public class autos {

    private final DriveSubsystem driveSubsystem = new DriveSubsystem();
    SendableChooser<Command> autochooser = new SendableChooser<>();

    public Command rotateClockwise90 = DriveCommands.drive(driveSubsystem, -1, 1).withTimeout(0.5);
    public Command rotateCounterClockwise90 = DriveCommands.drive(driveSubsystem, 1, -1).withTimeout(0.5);
    public Command moveForward(double time) {return DriveCommands.drive(driveSubsystem, 1, 1).withTimeout(time);};
    
    //add launch mechanism.

    //sequential command group for blue side auto:
    public Command auto_turnRight_straight = new SequentialCommandGroup(
        DriveCommands.drive(driveSubsystem, -1, 1).withTimeout(0.5),
        DriveCommands.drive(driveSubsystem, 1, 1).withTimeout(1));


    //sequential command group for red side auto:
    public Command auto_turnLeft_straight = new SequentialCommandGroup(
        DriveCommands.drive(driveSubsystem, 1, -1).withTimeout(0.5),
        DriveCommands.drive(driveSubsystem, 1, 1).withTimeout(1));
}
