// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeRaiseCmd extends CommandBase {
  private final IntakeSubsystem intakeSubsystem;
  private final Supplier<Double> SpeedFuntion;
  
  public IntakeRaiseCmd(IntakeSubsystem subsystem, Supplier<Double> speedFuntion) {
    intakeSubsystem = subsystem;
    this.SpeedFuntion = speedFuntion;

    addRequirements(intakeSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double speed = this.SpeedFuntion.get();
    intakeSubsystem.raise(speed);
  }

  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.stopModules();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
