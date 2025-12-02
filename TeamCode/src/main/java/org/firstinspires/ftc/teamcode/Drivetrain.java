package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "baza")
public class Drivetrain extends LinearOpMode {
    DcMotor TR, TL, BR, BL;

    @Override
    public void runOpMode() {
        TR = hardwareMap.dcMotor.get("tr");
        TL = hardwareMap.dcMotor.get("tl");
        BR = hardwareMap.dcMotor.get("br");
        BL = hardwareMap.dcMotor.get("bl");

        waitForStart();
        while (opModeIsActive()) {
            move(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_trigger-gamepad1.left_trigger);
        }
    }

    public void move(double x, double y, double r) {
        BL.setPower(x + y - r);
        BR.setPower(x - y - r);
        TL.setPower(-x + y - r);
        TR.setPower(-x - y - r);
    }
}
