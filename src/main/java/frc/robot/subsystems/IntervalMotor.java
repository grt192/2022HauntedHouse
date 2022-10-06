package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class IntervalMotor extends IntervalMech {
    
    TalonSRX motor;
    double speed;

    public IntervalMotor(int canID, double speed, int startupDelay, int minPeriod, int maxPeriod, int holdDuration) {
        super(startupDelay, minPeriod, maxPeriod, holdDuration);

        this.motor = new TalonSRX(canID);
        motor.configFactoryDefault();
        // motor.setInverted(true);

        this.speed = speed;
    }

    @Override
    void run() {
        motor.set(TalonSRXControlMode.PercentOutput, speed); // ramp up/down power??        
    }

    @Override
    void stop() {
        motor.set(TalonSRXControlMode.PercentOutput, 0);
    }
}
