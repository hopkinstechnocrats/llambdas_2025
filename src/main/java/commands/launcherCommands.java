package commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Launcher;

public class launcherCommands{
    public static Command spinLauncher(Launcher m_launcher, double m_speed){
        return Commands.run(
            () -> {
                m_launcher.motorSpin(m_speed);
            }, m_launcher);
    }
}
