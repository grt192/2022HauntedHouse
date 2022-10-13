package frc.robot.subsystems.solenoids;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class MotorControllerSolenoid implements SolenoidGroup {
    WPI_TalonSRX motorController;

    public MotorControllerSolenoid(int canID, boolean reverse) {
        this.motorController = new WPI_TalonSRX(canID);
        this.motorController.setInverted(!reverse);
    }

    public MotorControllerSolenoid(int canID) {
        this(canID, false);
    }

    @Override
    public void set(boolean extended) {
        this.motorController.set(extended ? 1 : 0);
    }
}
