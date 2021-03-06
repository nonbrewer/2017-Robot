package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.commands.garage.Lower;

import edu.wpi.first.wpilibj.command.CommandGroup;
import ticktank.TickTank;
import ticktank.commands.FollowProfile;
import ticktank.motionProfile.Profile;

/**
 *
 */
public class StraightAuto extends CommandGroup {

	public StraightAuto(TickTank _tank, Profile p) {
		addSequential(new Lower());
		addSequential(new FollowProfile(_tank, p, true));
	}
}
