
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.subsystems.ConveyorSubsystem;

public class RobotContainer {
    private final ConveyorSubsystem conveyor =
        new ConveyorSubsystem();

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

    }

    public Command getAutonomousCommand() {
        return null;
    }
}
