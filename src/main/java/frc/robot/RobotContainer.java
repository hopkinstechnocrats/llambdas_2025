// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//constants not added yet :(
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Launcher;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();

  private final Launcher launcher = new Launcher();

  private final XboxController driveController = new XboxController(Constants.driverXboxControllerPort);
  
  private final XboxController operatorController = new XboxController(Constants.operatorXboxControllerPort);

  WPI_TalonSRX motor = new WPI_TalonSRX(10);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    driveSubsystem.setDefaultCommand( 
            new RunCommand(
                    () -> {
                      driveSubsystem.drive(Constants.maxMotorOutput*driveController.getLeftY(),
                      Constants.maxMotorOutput*driveController.getRightY());
                    }
            , driveSubsystem)
    );
 
//tells motor to spin in the launcher hopefully.
    
    
    launcher.setDefaultCommand(
      new RunCommand(
        () -> {
          ((Launcher) launcher).motorSpin(
          Constants.maxMotorOutput*operatorController.getLeftX());
        }
      , launcher)
    );
  }   

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton aButton = new JoystickButton(operatorController, 1);
    JoystickButton bButton = new JoystickButton(operatorController, 2);
    JoystickButton aDriverButton = new JoystickButton(driveController, 1);
    JoystickButton bDriverButton = new JoystickButton(driveController, 2);
    
    aButton.whileTrue(commandify(1.0)).onFalse(commandify(0.0));
    bButton.whileTrue(commandify(-1.0)).onFalse(commandify(0.0));
  }
   public Command commandify(double speed){
    return Commands.run( () -> {
      literallyAnything(speed);
    });
   }

  public void literallyAnything(double speed){
    motor.set(speed);
  }

 
  public DriveSubsystem getDriveSubsystem() {
    return driveSubsystem;
  }
  
  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new SequentialCommandGroup(
      //put commands here
    );
  }
}