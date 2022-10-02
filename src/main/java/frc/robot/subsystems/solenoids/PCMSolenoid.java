package frc.robot.subsystems.solenoids;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class PCMSolenoid implements SolenoidGroup {
    Solenoid solenoid;
    boolean reverse;

    public PCMSolenoid(int pcmChannel, boolean reverse) {
        this.solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, pcmChannel);
        this.reverse = reverse;
    }

    public PCMSolenoid(int pcmChannel) {
        this(pcmChannel, false);
    }

    @Override
    public void set(boolean extended) {
        solenoid.set(reverse ? extended : !extended);
    }
}
