// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorCmd extends CommandBase {
  private final ElevatorSubsystem elevatorSubsystem;
  private final Supplier<Double> SpeedFuntion;

  public ElevatorCmd(ElevatorSubsystem subsystem, Supplier<Double> speedFuntion) {
    elevatorSubsystem = subsystem;
    this.SpeedFuntion = speedFuntion;

    addRequirements(elevatorSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double speed = this.SpeedFuntion.get();
    elevatorSubsystem.raise(speed);
  }

  @Override
  public void end(boolean interrupted) {
    elevatorSubsystem.stopModules();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
