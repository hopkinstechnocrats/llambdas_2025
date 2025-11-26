package frc.robot.subsystems;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.MotControllerJNI;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PopcornSubsystem extends SubsystemBase{
    static WPI_TalonSRX accelerationMotor;
    static WPI_TalonSRX loadingMotor;

    public PopcornSubsystem(){
        accelerationMotor = new WPI_TalonSRX(0); // Find CANID
        accelerationMotor.configFactoryDefault();
        accelerationMotor.setNeutralMode(NeutralMode.Brake);
    }

    public static void launchPopcorn(){
        accelerationMotor.set(Constants.accelerationMotorTopSpeed);
        loadingMotor.set(Constants.loadingMotorTopSpeed);
    }

    public static void stopLauncherMotors(){
        accelerationMotor.set(0);
        loadingMotor.set(0);
    }
}