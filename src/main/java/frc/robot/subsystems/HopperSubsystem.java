
package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Timer;

public class HopperSubsystem extends SubsystemBase {

    private final TalonFX motor = new TalonFX(3);
    private final Timer timer = new Timer();

    private static final double EXTEND_TIME = 1.5;
    private static final double RETRACT_TIME = 1.5;
    private static final double VOLTAGE = 4.0;

    private double targetTime;

    public void extend() {
        targetTime = EXTEND_TIME;
        motor.setVoltage(VOLTAGE);
        timer.restart();
    }

    public void retract() {
        targetTime = RETRACT_TIME;
        motor.setVoltage(-VOLTAGE);
        timer.restart();
    }

    @Override
    public void periodic() {
        if (timer.hasElapsed(targetTime)) {
            stop();
        }
    }

    public void stop() {
        motor.setVoltage(0.0);
        timer.stop();
    }
}
