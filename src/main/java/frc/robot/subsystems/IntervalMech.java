package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class IntervalMech extends SubsystemBase {
    private final int maxPeriod, minPeriod;
    private final int startupDelay;
    private final int holdDuration;

    private final Timer startupTimer;
    private final Timer intervalTimer;

    private boolean running;
    private int nextPeriod;

    public IntervalMech(int startupDelay, int minPeriod, int maxPeriod, int holdDuration) {
        this.maxPeriod = maxPeriod;
        this.minPeriod = minPeriod;

        this.startupDelay = startupDelay;
        this.holdDuration = holdDuration;

        this.startupTimer = new Timer();
        this.intervalTimer = new Timer();

        this.running = false;
        this.nextPeriod = determineNextPeriod();

        stop();
        startupTimer.start();
    }

    public IntervalMech(int startupDelay, int period, int holdDuration) {
        this(startupDelay, period, period, holdDuration);
    }

    public void periodic() {
        // Wait for startupDelay seconds before running
        if (!startupTimer.hasElapsed(startupDelay)) return;

        intervalTimer.start();

        if (running && intervalTimer.advanceIfElapsed(holdDuration)) {
            running = false;
            stop();            
            nextPeriod = determineNextPeriod();
        } else if (!running && intervalTimer.advanceIfElapsed(nextPeriod)) {
            running = true;
            run();
        }
    }

    // run mechanism; ie. extend pneumatic, run motors
    abstract void run();

    // stop mechanism; ie. retract pneumatic, stop motors
    abstract void stop();
    
    private int determineNextPeriod() {
        if (this.minPeriod == this.maxPeriod) {
            return minPeriod;
        } else {
            int range = maxPeriod - minPeriod;
            return minPeriod + ((int) (Math.random() * range));
        }
    }
}
