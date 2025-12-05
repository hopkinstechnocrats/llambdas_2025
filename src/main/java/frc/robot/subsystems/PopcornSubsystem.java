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
        accelerationMotor = new WPI_TalonSRX(Constants.popcornAcceleratorCANID); // Find real CANID 
        loadingMotor = new WPI_TalonSRX(Constants.popcornLoaderCANID); // TODO: Find real CANID
 
        accelerationMotor.configFactoryDefault();
        loadingMotor.configFactoryDefault();
	
        accelerationMotor.setNeutralMode(NeutralMode.Brake);
        loadingMotor.setNeutralMode(NeutralMode.Brake);
    }

    public static void setLauncherSpeed(double acceleratorSpeed , double launcherSpeed){
        accelerationMotor.set(acceleratorSpeed);
        loadingMotor.set(launcherSpeed);
    }

}