package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name= "baza BLUEHIGH")
public class pisyaBlueHigh extends LinearOpMode {
    DcMotor TR, TL, BR, BL;
    Drivetrain dt = new Drivetrain(this);
    Shooter sh = new Shooter(this);

    @Override
    public void runOpMode() {
       // TR = hardwareMap.dcMotor.get("tr");
       // TL = hardwareMap.dcMotor.get("tl");
      //  BR = hardwareMap.dcMotor.get("br");
       // BL = hardwareMap.dcMotor.get("bl");

        waitForStart();
        if (opModeIsActive()) {
            dt.moveByDistance(0,1,0,600);
            sh.shoot(1);
            dt.moveByDistance(1,0,0,50);
//            move(0, -0.4, 0);
//            sleep(500);
//            move(0, 0, 0);
//            //shooter.sh
//            move(0.4, 0, 0);
//            sleep(1000);
//            move(0, 0, 0);
        }
    }

    public void move(double x, double y, double r) {
        BL.setPower(x + y - r);
        BR.setPower(x - y - r);
        TL.setPower(-x + y - r);
        TR.setPower(-x - y - r);
    }
}

