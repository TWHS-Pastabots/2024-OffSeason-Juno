package frc.robot.subsystems.claw;
import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.Ports;


public class Claw {

    private CANSparkMax wheel1;
    private CANSparkMax wheel2;

    public static Claw instance;
 

    
    // public PneumaticHub junoHub;
    // public DoubleSolenoid cylinderR;
    // public DoubleSolenoid cylinderL;
    // public  Compressor compressor;


    public Claw() {
        wheel1 = new CANSparkMax(4, MotorType.kBrushless);
        wheel1.restoreFactoryDefaults();

        wheel1.setSmartCurrentLimit(20);
        wheel1.setIdleMode(IdleMode.kBrake);
        wheel1.setInverted(false);
        wheel1.burnFlash();

        wheel2 = new CANSparkMax(5, MotorType.kBrushless);
        wheel2.restoreFactoryDefaults();

        wheel2.setSmartCurrentLimit(20);
        wheel2.setIdleMode(IdleMode.kBrake);
        wheel2.setInverted(true);
        wheel2.burnFlash();

         // Initialize compressor and solenoids (assuming PCM module and double solenoids)
        //  compressor = new Compressor(0, PneumaticsModuleType.REVPH);
        //  cylinderR = new DoubleSolenoid(PneumaticsModuleType.REVPH, 15, 13); // PCM channels 0, 1
        //  cylinderL = new DoubleSolenoid(PneumaticsModuleType.REVPH, 14, 12); // PCM channels 2, 3

        //  compressor.enableAnalog(10, 100);
        //  retractCylinders();
    }

    public void setWheelsOn(){
        wheel1.set(.75);
        wheel2.set(.75);
    }

    public void setWheelsReverse(){
        wheel1.set(-.25);
        wheel2.set(-.25);
    }

    public void setWheelsOff(){
        wheel1.set(0.05);
        wheel2.set(0.05);
    }


    // Method to turn on compressor (already handled by enableDigital in constructor)
    // public void turnOnCompressor() {
    //     compressor.enableAnalog(10, 100);  // Compressor will automatically manage itself
    // }

    // Method to extend both cylinders
    // public void extendCylinders() {
    //     cylinderR.set(DoubleSolenoid.Value.kForward); // Extend right cylinder
    //     cylinderL.set(DoubleSolenoid.Value.kForward); // Extend left cylinder
    // }

    // Method to retract both cylinders
    // public void retractCylinders() {
    //     cylinderR.set(DoubleSolenoid.Value.kReverse); // Retract right cylinder
    //     cylinderL.set(DoubleSolenoid.Value.kReverse); // Retract left cylinder
    // }


    public static Claw getInstance() {
        if (instance == null)
            instance = new Claw();
        return instance;
    }
}

