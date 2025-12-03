// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import java.security.interfaces.XECPublicKey;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveSubsystem;
// import frc.robot.subsystems.PopcornCommands;
// import frc.robot.subsystems.PopcornSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

import frc.robot.subsystems.ButterIntakeCommands;
// import frc.robot.subsystems.PopcornSubsystem;
import frc.robot.subsystems.ButterIntakeSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();

  private final ButterIntakeSubsystem  butterIntakeSubsystem = new ButterIntakeSubsystem();
  // private final PopcornSubsystem  popcornSubsystem = new PopcornSubsystem();

  private final CommandXboxController driveController = new CommandXboxController(Constants.driverXboxControllerPort);
  
  private final CommandXboxController operatorController = new CommandXboxController(Constants.operatorXboxControllerPort);

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

    butterIntakeSubsystem.setDefaultCommand(
      new RunCommand(() -> {
        butterIntakeSubsystem.runButterIntake(0);
      }, butterIntakeSubsystem)
    );

    // popcornSubsystem.setDefaultCommand(
    //   new RunCommand(() -> {
    //     popcornSubsystem.setLauncherSpeed(0.0 , 0.0);
    //   }, popcornSubsystem)
    // );
  }
        /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
    //write joystick driver here
    
    //winchCode
    operatorController.y().onTrue(ButterIntakeCommands.winchRaiseCommand(true, butterIntakeSubsystem));
    operatorController.a().onTrue(ButterIntakeCommands.winchRaiseCommand(false, butterIntakeSubsystem));
    
    //Butter intake code
    operatorController.b().whileTrue(ButterIntakeCommands.butterIntakeCommand(-Constants.butterIntakeTopSpeed, butterIntakeSubsystem));

    operatorController.x().whileTrue(ButterIntakeCommands.butterIntakeCommand(Constants.butterIntakeTopSpeed, butterIntakeSubsystem));

    //TODO: Test this load of garbage to make sure that the motor stops when the button isn't being pressed
    
    // operatorController.rightBumper().whileTrue(PopcornCommands.launchPopcornCommand( popcornSubsystem));

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