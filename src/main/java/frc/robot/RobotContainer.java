
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class RobotContainer {
    private final ConveyorSubsystem conveyor =
        new ConveyorSubsystem();

    private final IntakeSubsystem intake =
        new IntakeSubsystem();

    private final HopperSubsystem hopper =
     new HopperSubsystem();

    private final CommandPS5Controller driverController =
        new CommandPS5Controller(0);

    public RobotContainer() {
        driverController.L2().whileTrue(
            Commands.startEnd(
                () -> conveyor.setVoltage(6.0),
                conveyor::stop,
                conveyor
            )
        );

        driverController.R2().whileTrue(
            Commands.startEnd(
                () -> conveyor.setVoltage(-6.0),
                conveyor::stop,
                conveyor
            )
        );
        driverController.L1().whileTrue(
            Commands.startEnd(
                () -> intake.setVoltage(6.0),
                intake::stop,
                intake
            )
        );

        driverController.R1().whileTrue(
            Commands.startEnd(
                () -> intake.setVoltage(-6.0),
                intake::stop,
                intake
            )
        );

        driverController.cross().whileTrue(
            Commands.startEnd(
            () -> hopper.extend(),
            hopper::retract,
            hopper
    )
);
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
