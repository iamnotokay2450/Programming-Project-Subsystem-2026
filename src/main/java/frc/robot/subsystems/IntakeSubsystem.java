package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    private final TalonFX motor = new TalonFX(2);

    // sets the voltage of the intake motor to the voltage specified
    public void setVoltage(double volts) {
    motor.setVoltage(Math.max(-12.0, Math.min(12.0, volts)));
    }

    // stops the intake motors 
    public void stop() {
        motor.setVoltage(0.0);
    }

}