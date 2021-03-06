package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.commands.FlashlightOn;
import org.usfirst.frc.team236.robot.commands.camera.CameraCycle;
import org.usfirst.frc.team236.robot.commands.climber.ClimbOverride;
import org.usfirst.frc.team236.robot.commands.drive.Stop;
import org.usfirst.frc.team236.robot.commands.garage.Grasp;
import org.usfirst.frc.team236.robot.commands.garage.Raise;
import org.usfirst.frc.team236.robot.commands.garage.Release;
import org.usfirst.frc.team236.robot.commands.garage.SafeLower;
import org.usfirst.frc.team236.robot.commands.intake.Deploy;
import org.usfirst.frc.team236.robot.commands.intake.Intake;
import org.usfirst.frc.team236.robot.commands.intake.Retract;
import org.usfirst.frc.team236.robot.commands.shooter.PresetDown;
import org.usfirst.frc.team236.robot.commands.shooter.PresetUp;
import org.usfirst.frc.team236.robot.commands.shooter.ShootWithVariableFeed;
import org.usfirst.frc.team236.robot.lib.LogitechF310;
import org.usfirst.frc.team236.robot.triggers.JoystickPOV;
import org.usfirst.frc.team236.robot.triggers.JoystickPOV.Direction;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import ticktank.commands.ShiftDown;
import ticktank.commands.ShiftUp;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick left, right;
	public Joystick controller;

	public OI() {
		// Joysticks + controller
		left = new Joystick(ControlMap.PORT_LEFT);
		right = new Joystick(ControlMap.PORT_RIGHT);
		controller = new Joystick(ControlMap.PORT_CONTROLLER);

		// Add buttons below
		// ---------- LEFT ----------
		//JoystickButton align = new JoystickButton(left, ControlMap.Left.ALIGN_DRIVE);
		//align.whileHeld(new AlignDrive());

		JoystickPOV shiftUp = new JoystickPOV(left, Direction.DOWN);
		shiftUp.whenPressed(new ShiftUp(Robot.tank));

		JoystickPOV shiftDown = new JoystickPOV(left, Direction.UP);
		shiftDown.whenPressed(new ShiftDown(Robot.tank));

		JoystickButton climb = new JoystickButton(left, ControlMap.Left.CLIMB);
		climb.whileHeld(new ClimbOverride());

		// ---------- RIGHT ----------
		JoystickButton intake = new JoystickButton(right, ControlMap.Right.INTAKE);
		intake.whileHeld(new Intake());

		//JoystickButton reverso = new JoystickButton(right, ControlMap.Right.REVERSO);
		//reverso.whileHeld(new ReversoDrive());

		// ---------- Controller ----------
		JoystickButton cameraCycle = new JoystickButton(controller, ControlMap.Controller.CYCLE_CAMERA);
		cameraCycle.toggleWhenPressed(new CameraCycle());

		// Climber
		JoystickButton climbOverride = new JoystickButton(controller, ControlMap.Controller.CLIMB);
		//climbOverride.whileHeld(new ClimbOverride());

		//Shooter
		JoystickButton shoot = new JoystickButton(controller, ControlMap.Controller.SHOOT);
		shoot.whileHeld(new ShootWithVariableFeed());

		JoystickPOV presetUp = new JoystickPOV(controller, Direction.RIGHT);
		presetUp.whenPressed(new PresetUp());

		JoystickPOV presetDown = new JoystickPOV(controller, Direction.LEFT);
		presetDown.whenPressed(new PresetDown());

		// Intake
		JoystickButton retract = new JoystickButton(controller, ControlMap.Controller.RETRACT_INTAKE);
		retract.whileHeld(new Retract());

		JoystickButton deploy = new JoystickButton(controller, ControlMap.Controller.DEPLOY_INTAKE);
		deploy.whileHeld(new Deploy());

		// Garage Door
		JoystickButton grasp = new JoystickButton(controller, ControlMap.Controller.GRASP);
		grasp.whenPressed(new Grasp());

		JoystickButton release = new JoystickButton(controller, ControlMap.Controller.RELEASE);
		release.whenPressed(new Release());

		JoystickPOV doorUp = new JoystickPOV(controller, Direction.UP);
		doorUp.whenPressed(new Raise());

		JoystickPOV doorDown = new JoystickPOV(controller, Direction.DOWN);
		doorDown.whenPressed(new SafeLower());

		JoystickButton stop = new JoystickButton(controller, LogitechF310.RB);
		stop.whileHeld(new Stop());
	}
}
