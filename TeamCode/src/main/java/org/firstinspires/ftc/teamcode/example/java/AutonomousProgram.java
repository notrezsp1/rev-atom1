package org.firstinspires.ftc.teamcode.example.java;

import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;

import Constants.Constants;
import dev.nextftc.extensions.pedro.FollowPath;
import dev.nextftc.extensions.pedro.PedroComponent;
import dev.nextftc.ftc.NextFTCOpMode;

public class AutonomousProgram extends NextFTCOpMode {
    private final Pose startPose = new Pose(9.0, 111.0, Math.toRadians(-90.0));
    private final Pose scorePose = new Pose(16.0, 128.0, Math.toRadians(-45.0));
    private final Pose pickup1Pose = new Pose(30.0, 121.0, Math.toRadians(0.0));
    private final Pose pickup2Pose = new Pose(30.0, 131.0, Math.toRadians(0.0));
    private final Pose pickup3Pose = new Pose(45.0, 128.0, Math.toRadians(90.0));
    private final Pose parkPose = new Pose(68.0, 96.0, Math.toRadians(-90.0));
    public AutonomousProgram() {
        addComponents(
                new PedroComponent(Constants::createFollower)
        );
    }
    private FollowPath pathCommand;



    @Override
    public void onInit() {
        pathCommand = new FollowPath(PedroComponent.follower().pathBuilder()
                .addPath(new BezierLine(startPose, scorePose))
                .setLinearHeadingInterpolation(startPose.getHeading(), scorePose.getHeading())
                .build());
    }

    @Override
    public void onWaitForStart() {
        pathCommand.schedule();
    }
}