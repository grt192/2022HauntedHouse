package frc.robot.subsystems.solenoids;

public interface SolenoidGroup {
    public void set(boolean extended);

    default public void update() {} // in case an implementation needs to be ticked regularly
}
