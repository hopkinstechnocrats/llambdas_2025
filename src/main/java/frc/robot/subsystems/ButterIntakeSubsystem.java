package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;


public class ButterIntakeSubsystem extends SubsystemBase{
    WPI_TalonSRX intakeMotor;
    WPI_TalonSRX winchMotor; 

    public boolean isWinchRaised = false;
    public boolean isWinchWorking = false;

    public ButterIntakeSubsystem(){
        //Initilize motors // update the channels pretty pleeassse!! :)
        intakeMotor = new WPI_TalonSRX(Constants.intakeMotorCANID);  //TODO: update this
        winchMotor = new WPI_TalonSRX(Constants.winchMotorCANID); //TODO: update the device number

        //put motors to default settings
        intakeMotor.configFactoryDefault();
        winchMotor.configFactoryDefault();
        
        //Make the motors brake unless they're doing something else
        intakeMotor.setNeutralMode(NeutralMode.Brake);
        winchMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void setButterWinchPosition(double raiseTimeSeconds, double motorSpeed , WPI_TalonSRX motor ){
        //Spins the motor for a certin amount of time.
	//TODO: Update the value of motorSpeed (possibly make it negative depending on the wiring)
        
        motor.set(motorSpeed);
        motor.setExpiration(raiseTimeSeconds);
        return;
    }

    public void runWinch(double speed){
        winchMotor.set(speed);
    }

    public void runButterIntake(double speed){
        intakeMotor.set(speed);
    }

    public void runButterWinch(boolean isBeingRaised){
        if(isBeingRaised == isWinchRaised || isWinchWorking){
            //In the event that the winch is already raised or in the middle of being raised
            //      Don't do anything.
            return;
        }
        isWinchWorking = true;
        if(isBeingRaised){
            setButterWinchPosition(Constants.pullyRaiseTime, -Constants.winchMotorTopSpeed, winchMotor);
        }
        else{
            setButterWinchPosition(Constants.pullyLowerTime, Constants.winchMotorTopSpeed, winchMotor);
        }
        isWinchWorking = false;
    }
}