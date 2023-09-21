// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IntakeSubsystem extends SubsystemBase {
  private final DoubleMotorModule IntakeRaiseMotorSet;
  private final CANSparkMax IntakeMotor;

  public IntakeSubsystem() {
    IntakeRaiseMotorSet = new DoubleMotorModule(RobotMap.kLeftIntakeMotorPort, RobotMap.kRightIntakeMotorPort);

    IntakeMotor = new CANSparkMax(RobotMap.kIntakeMotorPort, MotorType.kBrushless);
    IntakeMotor.setSmartCurrentLimit(30);
    IntakeMotor.setIdleMode(IdleMode.kCoast);
    IntakeMotor.setInverted(false);
  }

  public void raise(double speed) {
    IntakeRaiseMotorSet.setDesiredState(speed * Constants.IntakeConstants.kIntakeRaiseSpeed);
    SmartDashboard.putNumber("IntakeRaise", speed * Constants.IntakeConstants.kIntakeRaiseSpeed);
  }

  public void intake(boolean direction) {
    IntakeMotor.set(Constants.IntakeConstants.kIntakeSpeed * (direction ? 1 : -1));
    SmartDashboard.putBoolean("Intake", direction);
  }

  public void stopModules() {
    IntakeRaiseMotorSet.stop();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
