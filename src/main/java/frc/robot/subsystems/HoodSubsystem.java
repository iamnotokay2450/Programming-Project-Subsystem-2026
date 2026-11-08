package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Degrees;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HoodSubsystem extends SubsystemBase {

    private final TalonFX motor = new TalonFX(4);

    public static final Angle MIN_ANGLE = Degrees.of(15);
    public static final Angle MAX_ANGLE = Degrees.of(60);
    public static final Angle TOLERANCE = Degrees.of(1);

    private static final double VOLTAGE = 4.0;

    public HoodSubsystem() {
        motor.setPosition(0.0);
    }

    public void raise() {
        if (getPosition() < MAX_ANGLE.in(Degrees) - TOLERANCE.in(Degrees)) {
            motor.setVoltage(VOLTAGE);
        } else {
            stop();
        }
    }

    public void lower() {
        if (getPosition() > MIN_ANGLE.in(Degrees) + TOLERANCE.in(Degrees)) {
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