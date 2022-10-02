package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.solenoids.SolenoidGroup;

public class IntervalSolenoid extends SubsystemBase {
    SolenoidGroup solenoids;

    int maxPeriod, minPeriod;
    int startupDelay;
    int holdDuration;

    boolean firstLoop;
    boolean hasStarted;

    Timer timer;

    boolean extended;

    int nextPeriod;

    public IntervalSolenoid(SolenoidGroup solenoids, 
            int startupDelay, int minPeriod, int maxPeriod, int holdDuration) {
        CommandScheduler.getInstance().registerSubsystem(this);

        this.maxPeriod = maxPeriod;
        this.minPeriod = minPeriod;

        this.startupDelay = startupDelay;
        this.holdDuration = holdDuration;

        this.solenoids = solenoids;

        this.firstLoop = false;
        this.hasStarted = false;

        this.timer = new Timer();

        this.extended = false;
        this.solenoids.set(extended);

        this.nextPeriod = determineNextPeriod();
    }

    public IntervalSolenoid(SolenoidGroup solenoids,
            int startupDelay, int period, int holdDuration) {
        this(solenoids, startupDelay, period, period, holdDuration);
    }

    public void periodic() {
        if (!firstLoop) {
            timer.start();
            firstLoop = true;
        }

        if (!hasStarted && timer.hasElapsed(startupDelay)) {
            timer.reset();
            hasStarted = true;
        }

        if (hasStarted) {
            if (extended && timer.hasElapsed(holdDuration)) {
                extended = false;
                solenoids.set(false);
                timer.reset();
                
                nextPeriod = determineNextPeriod();
            } else if (!extended && timer.hasElapsed(nextPeriod)) {
                extended = true;
                solenoids.set(true);
                timer.reset();
            }
        }

        solenoids.update();
    }

    private int determineNextPeriod() {
        if (this.minPeriod == this.maxPeriod) {
            return minPeriod;
        } else {
            int range = maxPeriod - minPeriod;

            return minPeriod + ((int) (Math.random() * range));
        }
    }
}
