package frc.robot.subsystems;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.MotControllerJNI;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Launcher extends SubsystemBase{
    WPI_TalonSRX launcherMotor;
    public Launcher(){
        launcherMotor = new WPI_TalonSRX(0); // Find CANID
        launcherMotor.configFactoryDefault();
        launcherMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void motorSpin(double speed){
        launcherMotor.set(speed);

    }


    
    
}