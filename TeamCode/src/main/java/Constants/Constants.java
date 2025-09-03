package Constants;

import com.pedropathing.control.FilteredPIDFCoefficients;
import com.pedropathing.control.PIDFCoefficients;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.Encoder;
import com.pedropathing.ftc.localization.constants.ThreeWheelIMUConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Constants {

    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(10.5)
            .forwardZeroPowerAcceleration(
                    (-38.36594256449782 - -36.54677691157878 - -36.074312185378936) / 3
            )
            .lateralZeroPowerAcceleration(
                    (-52.832773017773546732628701 - -64.09170051001064 - -70.81132127072327) /
                            3
            )
            .centripetalScaling(0.0005)
            .useSecondaryTranslationalPIDF(true)
            .useSecondaryHeadingPIDF(true)
            .useSecondaryDrivePIDF(true)
            .translationalPIDFCoefficients(new PIDFCoefficients(0.1, 0, 0.01, 0.01))
            .headingPIDFCoefficients(new PIDFCoefficients(5, 0, 0.5, 0.01))
            .drivePIDFCoefficients(
                    new FilteredPIDFCoefficients(0.01, 0, 0.0001, 0.6, 0.01)
            )
            .secondaryTranslationalPIDFCoefficients(
                    new PIDFCoefficients(0.075, 0, 0.05, 0.0005)
            )
            .secondaryHeadingPIDFCoefficients(new PIDFCoefficients(1.5, 0, 0.1, 0.0005))
            .secondaryDrivePIDFCoefficients(
                    new FilteredPIDFCoefficients(0.02, 0, 0.0005, 0.6, 0.01)
            );

    public static MecanumConstants driveConstants = new MecanumConstants()
            .leftFrontMotorName("FLmotor")
            .leftRearMotorName("BLmotor")
            .rightFrontMotorName("FRmotor")
            .rightRearMotorName("BRmotor")
            .leftFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
            .leftRearMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightRearMotorDirection(DcMotorSimple.Direction.REVERSE)
            .xVelocity((54.71856302885552 + 53.911457926509435 + 53.19606524142703) / 3)
            .yVelocity(
                    (32.39116568603613 + 38.398982876912484 + 36.57152160820453) / 3
            );

    public static ThreeWheelIMUConstants localizerConstants =
            new ThreeWheelIMUConstants()
                    .forwardTicksToInches(0.003)
                    .strafeTicksToInches(0.00291049487428112)
                    .turnTicksToInches(0.003)
                    .leftPodY(6.2)
                    .rightPodY(-6)
                    .strafePodX(-2)
                    .leftEncoder_HardwareMapName("BLmotor")
                    .rightEncoder_HardwareMapName("BRmotor")
                    .strafeEncoder_HardwareMapName("FRmotor")
                    .leftEncoderDirection(Encoder.FORWARD)
                    .rightEncoderDirection(Encoder.REVERSE)
                    .strafeEncoderDirection(Encoder.FORWARD)
                    .IMU_HardwareMapName("imu")
                    .IMU_Orientation(
                            new RevHubOrientationOnRobot(
                                    RevHubOrientationOnRobot.LogoFacingDirection.DOWN,
                                    RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
                            )
                    );

    public static PathConstraints pathConstraints = new PathConstraints(
            0.95,
            50,
            2.5,
            1
    );


    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .mecanumDrivetrain(driveConstants)
                .threeWheelIMULocalizer(localizerConstants)
                .pathConstraints(pathConstraints)
                .build();
    }
}
