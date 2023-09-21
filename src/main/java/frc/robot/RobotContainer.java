// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.IntakeCmd;
import frc.robot.joysticks.DriverJoystick;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;


public class RobotContainer {
  private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final DriverJoystick driverJoystick = new DriverJoystick(0);

  public RobotContainer() {
    this.elevatorSubsystem.setDefaultCommand(this.driverJoystick.generateElevatorCmd(this.elevatorSubsystem));
    this.intakeSubsystem.setDefaultCommand(this.driverJoystick.generateIntakeRaiseCmd(this.intakeSubsystem));
    configureBindings();
  }


  private void configureBindings() {
    new Trigger(this.driverJoystick::getYButtonPressed).whileTrue(new IntakeCmd(intakeSubsystem, true));
    new Trigger(this.driverJoystick::getAButtonPressed).whileTrue(new IntakeCmd(intakeSubsystem, false));
  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
