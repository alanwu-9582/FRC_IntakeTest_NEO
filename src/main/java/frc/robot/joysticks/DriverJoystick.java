package frc.robot.joysticks;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ElevatorCmd;
import frc.robot.subsystems.ElevatorSubsystem;

import frc.robot.commands.IntakeCmd;
import frc.robot.commands.IntakeRaiseCmd;
import frc.robot.subsystems.IntakeSubsystem;

@SuppressWarnings("unused")
public class DriverJoystick extends XboxController {
    public static final double DEADBAND = 0.05;

    public DriverJoystick(int port) {
        super(port);
    }

    @SuppressWarnings("SuspiciousNameCombination")
    public Command generateElevatorCmd(ElevatorSubsystem elevatorSubsystem) {
        return new ElevatorCmd(elevatorSubsystem, this::getLeftY);
    }

    @SuppressWarnings("SuspiciousNameCombination")
    public Command generateIntakeRaiseCmd(IntakeSubsystem intakeSubsystem) {
        return new IntakeRaiseCmd(intakeSubsystem, this::getRightY);
    }
}
