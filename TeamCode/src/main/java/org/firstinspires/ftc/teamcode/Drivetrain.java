package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Drivetrain {
    DcMotor TR, TL, BR, BL;
    LinearOpMode opmode;
    private static final double WHEEL_PERIMETER_MM = 100 * Math.PI;
    private static final double TICKS_PER_REVOLUTION = 537.7;
    private static final double GEAR_RATIO = 1;
    private static final double TICKS_PER_MM = (TICKS_PER_REVOLUTION / WHEEL_PERIMETER_MM) * GEAR_RATIO;

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

    public double millimetersToTicks(double millimeters) {
        return millimeters * TICKS_PER_MM;
    }

    public void moveByDistance(double power_x, double power_y, double power_z, double distanceMM) {
        stopAndReset();
        double ticks = millimetersToTicks(distanceMM);
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
