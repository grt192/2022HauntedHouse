package frc.robot.subsystems.solenoids;

import edu.wpi.first.wpilibj.Timer;

/*
 * When instructed to extend, repeater solenoids will go in
 * and out with a constant period n (in for n seconds, out
 * for n seconds, repeat)
*/
public class RepeaterSolenoids implements SolenoidGroup {
    SolenoidGroup solenoids;
    boolean extended;
    boolean activated;

    Timer timer;

    int period;

    public RepeaterSolenoids(SolenoidGroup solenoids, int period) {
        this.solenoids = solenoids;
        this.period = period;

        this.extended = false;
        this.activated = false;

        this.timer = new Timer();
        this.timer.start();
    }

    public void set(boolean extended) {
        this.extended = extended;
    }

    public void update() {
        if (extended) {
            if (timer.hasElapsed(period)) {
                activated = !activated;
                timer.reset();
            }

            solenoids.set(activated);
        } else {
            solenoids.set(extended);
            timer.reset();
        }
    }
}
