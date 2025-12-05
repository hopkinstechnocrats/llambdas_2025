package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.PopcornSubsystem;
import frc.robot.Constants;

public class PopcornCommands {
    public static Command setPopcornLauncherCommand(double acceleratorSpeed , double launcherSpeed , PopcornSubsystem popcornSubsystem){
        return Commands.run( ()->{
          popcornSubsystem.setLauncherSpeed(acceleratorSpeed , launcherSpeed);
        },popcornSubsystem);
    };

    public static Command launchPopcornCommand(PopcornSubsystem popcornSubsystem){
        return Commands.run( ()->{
	popcornSubsystem.setLauncherSpeed( Constants.accelerationMotorTopSpeed , Constants.loadingMotorTopSpeed );
        },popcornSubsystem);
    }; 	
}