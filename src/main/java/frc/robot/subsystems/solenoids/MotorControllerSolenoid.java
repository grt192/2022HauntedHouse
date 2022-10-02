package frc.robot.subsystems.solenoids;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class MotorControllerSolenoid implements SolenoidGroup {
    TalonSRX motorController;

    public MotorControllerSolenoid(int canID, boolean reverse) {
        this.motorController = new TalonSRX(canID);
        this.motorController.setInverted(!reverse);
    }

    public MotorControllerSolenoid(int canID) {
        this(canID, false);
    }

    @Override
    public void set(boolean extended) {
        this.motorController.set(TalonSRXControlMode.PercentOutput, extended ? 1 : 0);
    }
    
}
