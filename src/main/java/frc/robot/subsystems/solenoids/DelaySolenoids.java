package frc.robot.subsystems.solenoids;

import edu.wpi.first.wpilibj.Timer;

public class DelaySolenoids implements SolenoidGroup {
    SolenoidGroup first, second;
    int delay;

    boolean target;
    Timer timer;

    public DelaySolenoids(SolenoidGroup first, SolenoidGroup second, int delay) {
        this.first = first;
        this.second = second;

        this.delay = delay;

        this.target = false;

        first.set(target);
        second.set(target);

        this.timer = new Timer();
        this.timer.start();
    }

    public void set(boolean extended) {
        if (extended != target) {
            target = extended;
            timer.reset();

            first.set(target);
        }
    }

    public void update() {
        if (timer.hasElapsed(this.delay)) {
            second.set(target);
        }
    }
}
