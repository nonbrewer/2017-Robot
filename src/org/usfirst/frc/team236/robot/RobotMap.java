package org.usfirst.frc.team236.robot;

import pid.PIDParameters;

public class RobotMap {
	public static class Drive {
		// Uses PWM 0 and 1: split to two motors
		public static final int DIO_LEFT_ENC_A = 0;
		public static final int DIO_LEFT_ENC_B = 1;

		public static final int DIO_RIGHT_ENC_A = 2;
		public static final int DIO_RIGHT_ENC_B = 3;

		public static double DISTANCE_PER_PULSE;

		// TODO: tune auto mode
		public static double kV_left, kV_right;
		public static double kA;
		public static double kP;

		// TODO: tune turning PID
		public static PIDParameters turnParams;
	}

	public static class Shooter {
		public static final int PWM_SHOOTER = 2; // Splits to two motors
		public static final int PWM_FEEDER = 3;
		public static final int PWM_SERVO = 4;

		public static final int DIO_COUNTER = 4;

		public static final double kV = 1 / 4600;

		public static final int RPM_INITIAL = 3200;
		public static final int RPM_INCREMENT = 100;

		public static class PID {
			public static final double kP = 0.001;
			public static final double kI = 0.000;
			public static final double kD = 0.000;
			public static final double interval = 1 / 200.0;
		}
	}

	public static class Intake {
		public static final int PWM_INTAKE = 5; // Splits to two motors
		public static final int PWM_DEPLOY = 6;

		public static final int DIO_LIMIT_BOTTOM = 5;
	}

	public static class Climber {
		public static final int PWM_CLIMBER = 7; // Splits to two motors 
	}

	public static class Garage {
		public static final int PWM_DOOR = 8;
		public static final int PWM_GRASPER = 9;

		// power to send to window motor
		public static final double GRASP_STRENGTH = 0.5;
		public static final double RAISE_SPEED = 0.75;
		public static final double LOWER_SPEED = -0.5;
	}
}
