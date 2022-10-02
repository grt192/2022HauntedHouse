package frc.robot.subsystems.solenoids;

public class ParallelSolenoids implements SolenoidGroup {
    SolenoidGroup[] solenoids;

    public ParallelSolenoids(SolenoidGroup... solenoids) {
        this.solenoids = solenoids;
    }

    public void set(boolean extended) {
        for (SolenoidGroup solenoid : solenoids) {
            solenoid.set(extended);
        }
    }

    public void update() {
        for (SolenoidGroup solenoid : solenoids) {
            solenoid.update();
        }
    }
}
