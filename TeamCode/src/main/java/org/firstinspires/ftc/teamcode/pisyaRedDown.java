package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name= "baza REDDOWN")
public class pisyaRedDown extends LinearOpMode {
    DcMotor TR, TL, BR, BL;
    Shooter sh;

    @Override
    public void runOpMode() {
        TR = hardwareMap.dcMotor.get("tr");
        TL = hardwareMap.dcMotor.get("tl");
        BR = hardwareMap.dcMotor.get("br");
        BL = hardwareMap.dcMotor.get("bl");


        waitForStart();
        if (opModeIsActive()) {
            move(0,0,0.4);
            sleep(700);
            move(0,0,0);
            move(-0.4, 0, 0);
            sleep(800);
            move(0,0,0);
        }

    }

    public void move(double x, double y, double r) {
        BL.setPower(x + y - r);
        BR.setPower(x - y - r);
        TL.setPower(-x + y - r);
        TR.setPower(-x - y - r);
    }
}


