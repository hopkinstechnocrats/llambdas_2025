package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.ButterIntakeSubsystem;

public class ButterIntakeCommands extends Command{
    public static Command winchRaiseCommand(boolean isBeingRaised, ButterIntakeSubsystem bbbutterIntakeSubsystem){
  return Commands.run( ()->{
    bbbutterIntakeSubsystem.runButterWinch(isBeingRaised);
  },bbbutterIntakeSubsystem);
};

public static Command stopMotor(ButterIntakeSubsystem butterIntakeSubsystem){
  return Commands.run( ()->{
      butterIntakeSubsystem.runWinch(0);
  }, butterIntakeSubsystem);
};

public static Command butterIntakeCommand(double speed , ButterIntakeSubsystem babutterIntakeSubsystem){
  return Commands.run( ()->{
    babutterIntakeSubsystem.runButterIntake(speed);
  },babutterIntakeSubsystem);
}

    public static Command setWinchSpeedCommand(double speed, ButterIntakeSubsystem bbbutterIntakeSubsystem){
  return Commands.run( ()->{
    bbbutterIntakeSubsystem.runWinch(speed);
  },bbbutterIntakeSubsystem);
};
}