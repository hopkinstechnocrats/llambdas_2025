package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.ButterIntakeSubsystem;


public class ButterIntakeCommands extends Command{
    public static Command winchRaiseCommand(boolean isBeingRaised,ButterIntakeSubsystem bbbutterIntakeSubsystem){
  return Commands.run( ()->{
    bbbutterIntakeSubsystem.runButterWinch(isBeingRaised);
  },bbbutterIntakeSubsystem);
};

public Command driveCommand(double leftJoystick, double rightJoystick , ButterIntakeSubsystem ButterIntakeSubsystem){
  return Commands.run( ()->{
    DriveSubsystem.drive(leftJoystick , rightJoystick);
  },ButterIntakeSubsystem);
}; 
}
