package org.usfirst.frc.team236.robot.commands.camera;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CameraGear extends Command {

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.cameraServo.set(RobotMap.CAMERA_POS[0]);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
	}
}
