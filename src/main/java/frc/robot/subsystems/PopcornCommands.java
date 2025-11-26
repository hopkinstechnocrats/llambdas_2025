package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.PopcornSubsystem;

public class PopcornCommands {
    public static Command launchPopcornCommand(PopcornSubsystem popcornSubsystem){
        return Commands.run( ()->{
          popcornSubsystem.launchPopcorn();
        },popcornSubsystem);
    };
}
