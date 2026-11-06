package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HopperSubsystem extends SubsystemBase {

    private final TalonFX motor = new TalonFX(3);

    private static final double EXTEND_LIMIT = 20.0;
    private static final double RETRACT_LIMIT = 0.0;
    private static final double VOLTAGE = 4.0;

    public HopperSubsystem() {
        motor.setPosition(0.0);
    }

    public void extend() {
        if (getPosition() < EXTEND_LIMIT) {
            motor.setVoltage(VOLTAGE);
        } else {
            stop();
        }
    }

    public void retract() {
        if (getPosition() > RETRACT_LIMIT) {
            motor.setVoltage(-VOLTAGE);
        } else {
            stop();
        }
    }

    public double getPosition() {
        return motor.getPosition().getValueAsDouble();
    }

    public void stop() {
        motor.setVoltage(0.0);
    }
}