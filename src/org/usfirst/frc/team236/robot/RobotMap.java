package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.subsystems.Shooter.Preset;

import pid.PIDParameters;

public class RobotMap {
	public static int[] DIO_SWITCHES = { 0, 1, 2 };

	public static final int PWM_CAM_SERVO = 8;
	public static final double GEAR_POS = 0.0;
	public static final double SHOOTER_POS = 0.7;

	public static final int RELAY_GEAR = 0;
	public static final int RELAY_SHOOTER = 1;

	public static class Drive {
		// Uses PWM 0 and 1: split to two motors
		public static final int DIO_LEFT_ENC_A = 3;
		public static final int DIO_LEFT_ENC_B = 4;

		public static final int DIO_RIGHT_ENC_A = 5;
		public static final int DIO_RIGHT_ENC_B = 6;

		// Gearshift
		public static final int SOL_FORWARD = 0;
		public static final int SOL_REVERSE = 1;

		// TODO determine distance per pulse
		public static double DISTANCE_PER_PULSE = 1;

		// TODO: tune auto mode
		public static double kV_left = 0.001;
		public static double kV_right = 0.001;
		
		public static double kA;
		public static double kP;

		// TODO: tune turning PID
		public static PIDParameters turnParams = new PIDParameters(0.001, 0.000, 0.000, 1 / 100.0);
	}

	public static class Shooter {
		public static final int PWM_SHOOTER = 2; // Splits to two motors
		public static final int PWM_FEEDER = 3;
		public static final int PWM_SERVO = 4;
		
		public static final boolean INV_SHOOTER = true;
		public static final boolean INV_FEEDER = true;

		public static final int DIO_COUNTER = 7;

		public static final double DEFAULT_FEED_SPEED = 1.0;

		// TODO improve kV tuning
		public static final double kV = 1 / 4400;

		@Deprecated
		public static final int RPM_INITIAL = 3200;
		@Deprecated
		public static final int RPM_INCREMENT = 100;

		public static PIDParameters pidParams = new PIDParameters(
				0.001,
				0.000,
				0.000,
				1 / 200.0
		);

		// TODO: find positions
		public static final Preset POS_KEY = Robot.shooter.new Preset("Key", 3200, 24, 0.35);
		public static final Preset POS_DS = Robot.shooter.new Preset("Driver Station", 3500, 80, 0.55);

		public static final Preset[] PRESETS = { POS_KEY, POS_DS };
	}

	public static class Intake {
		public static final int PWM_INTAKE = 5; // Splits to two motors
		public static final int PWM_DEPLOY = 6;
		
		public static final boolean INV_DEPLOY = true;

		public static final int DIO_LIMIT_BOTTOM = 8;
		public static final int DIO_LIMIT_TOP = 9;

		// TODO determine intake speeds
		public static final double INTAKE_SPEED = 1.00;
		public static final double EJECT_SPEED = -1.00;

		public static final double DEPLOY_SPEED = 0.60;
		public static final double RETRACT_SPEED = -0.60;
	}

	public static class Climber {
		public static final int PWM_CLIMBER = 7; // Splits to two motors 
		public static final double CLIMB_SPEED = 1.0; // TODO: determine climb speed

		public static final boolean INV_CLIMBER = true;

		public static final int DIO_LIMIT = 10;
	}

	public static class Garage {
		public static final int SOL_GRASPER_FORWARD = 2;
		public static final int SOL_GRASPER_REVERSE = 3;

		public static final int SOL_VERTICAL_FORWARD = 4;
		public static final int SOL_VERTICAL_REVERSE = 5;
	}
}
