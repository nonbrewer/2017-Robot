package org.usfirst.frc.team236.robot.commands.garage;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Raise extends Command {

	public Raise() {
		requires(Robot.garage);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.garage.raise();
		Robot.garage.lightOff();
		Robot.cameraServo.set(RobotMap.CAMERA_POS[1]);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	// Called once after timeout
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
