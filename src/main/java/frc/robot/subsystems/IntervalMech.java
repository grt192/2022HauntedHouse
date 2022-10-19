package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class IntervalMech extends SubsystemBase {
    
    int maxPeriod, minPeriod;
    int startupDelay;
    int holdDuration;

    boolean firstLoop;
    boolean hasStarted;

    Timer timer;

    boolean running;

    int nextPeriod;

    public IntervalMech(int startupDelay, int minPeriod, int maxPeriod, int holdDuration) {
        this.maxPeriod = maxPeriod;
        this.minPeriod = minPeriod;

        this.startupDelay = startupDelay;
        this.holdDuration = holdDuration;

        
        this.firstLoop = false;
        this.hasStarted = false;

        this.timer = new Timer();

        this.running = false;
        
        this.nextPeriod = determineNextPeriod();
    }

    public IntervalMech(int startupDelay, int period, int holdDuration) {
        this(startupDelay, period, period, holdDuration);
    }

    public void periodic() {
        if (!firstLoop) {
            timer.start();
            stop(); // set to OFF position
            firstLoop = true;
        }

        if (!hasStarted && timer.hasElapsed(startupDelay)) {
            timer.reset();
            hasStarted = true;
        }

        if (hasStarted) {
            if (running && timer.hasElapsed(holdDuration)) {
                running = false;
                stop();
                timer.reset();
                
                nextPeriod = determineNextPeriod();
            } else if (!running && timer.hasElapsed(nextPeriod)) {
                running = true;
                run();
                timer.reset();

            }
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
