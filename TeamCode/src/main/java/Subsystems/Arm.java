package Subsystems;



import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import dev.nextftc.core.subsystems.Subsystem;


public class Arm implements Subsystem {
    public static DcMotorEx arm;



    public Arm(HardwareMap hardwareMap) {
        arm = hardwareMap.get(DcMotorEx.class, "Angulo");
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public static void controlManual(double power) {
        if (Math.abs(power) > 0.1) { // deadzone
            arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            arm.setPower(Range.clip(power, -1.0, 1.0));
        } else {
            arm.setPower(0);
        }
    }
    public static void toPosition(int target, double power) {
        arm.setTargetPosition(target);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setPower(power);
    }

}