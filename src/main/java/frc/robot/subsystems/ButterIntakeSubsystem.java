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
// This subsystem allows the grabber to grab
public class ButterIntakeSubsystem extends SubsystemBase{
    WPI_TalonSRX intakeMotor;
    WPI_TalonSRX winchMotor; 

    public boolean isWinchRaised = false;
    public boolean isWinchWorking = false;

    public ButterIntakeSubsystem(){
        //Initilize motors // update the channels pretty pleeassse!! :)
        intakeMotor = new WPI_TalonSRX(0);  //TODO: update this
        winchMotor = new WPI_TalonSRX(0); //TODO: update the device number

        //put motors to default settings
        intakeMotor.configFactoryDefault();
        winchMotor.configFactoryDefault();
        
        //Make the motors brake unless they're doing something else
        intakeMotor.setNeutralMode(NeutralMode.Brake);
        winchMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void setGenericMotorPosition(double positionRadian, WPI_TalonSRX motor ){
        //Spins the motor a number of radians.
        double motorSpeed = 0.3;//TODO: update this and/ or make it into a constant :)
        if(positionRadian < 0){
            motorSpeed *= -1;
        }
        motor.set(motorSpeed);
        motor.setExpiration(positionRadian);
        return;
    }

    public void runButterIntake(boolean intake){
        //intake dictates if the Butter is going in or not.\
        double motorSpeed = Constants.butterIntakeTopSpeed;
        if(!intake){
            motorSpeed *= -1;
        }
        intakeMotor.set(motorSpeed);
        return;
    }

    public void runButterWinch(boolean isBeingRaised){
        if(isBeingRaised == isWinchRaised || isWinchWorking){
            return;
        }
        isWinchWorking = true;
        if(isBeingRaised){
            setGenericMotorPosition(Constants.pullyHeight, winchMotor);
        }
        else{
            setGenericMotorPosition(-1*Constants.pullyHeight, winchMotor);
        }
        isWinchWorking = false;
    }
}
