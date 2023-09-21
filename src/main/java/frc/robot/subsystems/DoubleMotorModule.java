package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DoubleMotorModule {
    private final CANSparkMax leftMotor;
    private final CANSparkMax rightMotor;

    public DoubleMotorModule(int leftPort, int rightPort) {
        leftMotor = new CANSparkMax(leftPort, MotorType.kBrushless);
        leftMotor.setSmartCurrentLimit(30);
        leftMotor.setIdleMode(IdleMode.kCoast);
        leftMotor.setInverted(false);
    
        rightMotor  = new CANSparkMax(rightPort, MotorType.kBrushless);
        rightMotor.setSmartCurrentLimit(30);
        rightMotor.setIdleMode(IdleMode.kCoast);
        rightMotor.setInverted(true);
      }

    public void setDesiredState(double speed) {
        leftMotor.set(speed);
        rightMotor.set(speed);
    }

    public void stop() {
        leftMotor.set(0);
        rightMotor.set(0);
    }
}
