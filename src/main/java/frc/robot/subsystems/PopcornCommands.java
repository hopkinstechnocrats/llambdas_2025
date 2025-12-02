package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.PopcornSubsystem;

public class PopcornCommands {
    public static Command setPopcornLauncherCommand(double acceleratorSpeed , double launcherSpeed , PopcornSubsystem popcornSubsystem){
        return Commands.run( ()->{
          popcornSubsystem.setLauncherSpeed(accelaratorSpeed , launcherSpeed);
        },popcornSubsystem);
    };

    public static Command LaunchPopcornCommand(PopcornSubsystem popcornSubsystem){
        return Commands.run( ()->{
	popcornSubsystem.setLauncherSpeed( Constants.accelerationMotorTopSpeed , Constants.loadingMotorTopSpeed );
        },popcornSubsystem);
    }; 	
}
