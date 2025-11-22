package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.ButterIntakeSubsystem;
import edu.wpi.first.wpilibj.motorcontrol.WPI_TalonSRX;

public class ButterIntakeCommands extends Command{
    public static Command winchRaiseCommand(boolean isBeingRaised,ButterIntakeSubsystem bbbutterIntakeSubsystem){
  return Commands.run( ()->{
    bbbutterIntakeSubsystem.runButterWinch(isBeingRaised);
  },bbbutterIntakeSubsystem);
};

public static Command stopMotor(WPI_TalonSRX motor){
  return Commands.run( ()->{
      motor.set(0);
  });
};

public Command butterIntakeCommand(boolean intake , ButterIntakeSubsystem butterIntakeSubsystem){
  return Commands.run( ()->{
    butterIntakeSubsystem.runButterIntake(intake);
  },butterIntakeSubsystem);
}
public Command driveCommand(double leftJoystick, double rightJoystick , ButterIntakeSubsystem ButterIntakeSubsystem){
  return Commands.run( ()->{
    DriveSubsystem.drive(leftJoystick , rightJoystick);
  },ButterIntakeSubsystem);
}; 
}
