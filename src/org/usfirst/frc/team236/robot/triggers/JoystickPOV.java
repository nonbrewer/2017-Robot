package org.usfirst.frc.team236.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class JoystickPOV extends Button {

	private Joystick stick;
	private int pov;
	private Direction dir;

	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}

	public JoystickPOV(Joystick _stick, int _pov, Direction _dir) {
		this.stick = _stick;
		this.pov = _pov;
	}

	public JoystickPOV(Joystick _stick, Direction _dir) {
		this.stick = _stick;
		this.pov = 0;
	}

	@Override
	public boolean get() {
		switch (dir) {
		case UP:
			return stick.getPOV(pov) == 0;
		case DOWN:
			return stick.getPOV(pov) == 180;
		case LEFT:
			return stick.getPOV(pov) == 90;
		case RIGHT:
			return stick.getPOV(pov) == 270;
		default:
			return false;
		}
	}

}