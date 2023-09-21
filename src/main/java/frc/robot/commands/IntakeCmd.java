// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCmd extends CommandBase {
  private final IntakeSubsystem intakeSubsystem;
  private final boolean Direction;
  
  public IntakeCmd(IntakeSubsystem subsystem, boolean direction) {
    intakeSubsystem = subsystem;
    this.Direction = direction;

    addRequirements(intakeSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    intakeSubsystem.intake(this.Direction);
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
