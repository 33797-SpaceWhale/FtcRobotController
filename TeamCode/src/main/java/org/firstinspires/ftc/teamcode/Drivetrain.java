package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Drivetrain {
    DcMotor TR, TL, BR, BL;
    LinearOpMode opmode;
    private static final double TICKS_PER_CENTIMETER = (2 * Math.PI * 100) / 537.7 / 10;

    public Drivetrain(LinearOpMode linearOpMode) {
        opmode = linearOpMode;

        TR = linearOpMode.hardwareMap.dcMotor.get("tr");
        TL = linearOpMode.hardwareMap.dcMotor.get("tl");
        BR = linearOpMode.hardwareMap.dcMotor.get("br");
        BL = linearOpMode.hardwareMap.dcMotor.get("bl");

        TR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        TL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        TR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        TL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        TR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        TL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void move(double x, double y, double r) {
        BL.setPower(x + y - r);
        BR.setPower(x - y - r);
        TL.setPower(-x + y - r);
        TR.setPower(-x - y - r);
    }

    public double centimetersToTicks(double centimeters) {
        return centimeters * TICKS_PER_CENTIMETER;
    }
// System.out.println("hellow ofvfvyg");
    public void moveByDistance(double power_x, double power_y, double power_z, double distance) {
        stopAndReset();
        double ticks = centimetersToTicks(distance);
        while (Math.abs(BL.getCurrentPosition()) <= ticks && opmode.opModeIsActive()) {
            move(power_x, power_y, power_z);
        }

        move(0,0,0);

        stopAndReset();
    }


    public void stopAndReset() {
        TR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        TL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        TR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        TL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}
