package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Inches;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HopperSubsystem extends SubsystemBase {

    private final TalonFX motor = new TalonFX(3);

    public static final Distance INTAKE_DISTANCE = Inches.of(11);
    public static final Distance RETRACT_DISTANCE = Inches.of(4);
    public static final Distance TOLERANCE = Inches.of(0.5);

    private static final double VOLTAGE = 4.0;

    public HopperSubsystem() {
        motor.setPosition(0.0);
    }

    public void extend() {
        if (getPosition() < INTAKE_DISTANCE.in(Inches) - TOLERANCE.in(Inches)) {
            motor.setVoltage(VOLTAGE);
        } else {
            stop();
        }
    }

    public void retract() {
        if (getPosition() > RETRACT_DISTANCE.in(Inches) + TOLERANCE.in(Inches)) {
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