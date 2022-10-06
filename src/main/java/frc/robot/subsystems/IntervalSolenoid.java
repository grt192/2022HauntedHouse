package frc.robot.subsystems;

import frc.robot.subsystems.solenoids.SolenoidGroup;

public class IntervalSolenoid extends IntervalMech {
    SolenoidGroup solenoids;

    public IntervalSolenoid(SolenoidGroup solenoids,
            int startupDelay, int minPeriod, int maxPeriod, int holdDuration) {
        super(startupDelay, minPeriod, maxPeriod, holdDuration);

        this.solenoids = solenoids;
    }

    public IntervalSolenoid(SolenoidGroup solenoids,
            int startupDelay, int period, int holdDuration) {

        this(solenoids, startupDelay, period, period, holdDuration);
    }

    @Override
    public void run() {
        this.solenoids.set(true);
    }

    @Override
    public void stop() {
        this.solenoids.set(false);
    }

    // public void periodic() {
        // solenoids.update();
    // }

}
