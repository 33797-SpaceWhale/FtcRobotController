package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class telepop extends LinearOpMode {
    DcMotor CM;

    boolean isXpressed, isYpressed = false;

    //Shooter sh;
    Drivetrain dt;

    @Override
    public void runOpMode() {
        dt = new Drivetrain(this);
        //sh = new Shooter(this);

        // CM = hardwareMap.dcMotor.get("cm");
        // CM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // CM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        double x, y, r = 0;
        waitForStart();
        while (opModeIsActive()) {
            x = gamepad1.left_stick_x;
            y = gamepad1.left_stick_y;
            r = gamepad1.right_trigger - gamepad1.left_trigger;

            if (Math.abs(x) < 0.05) x = 0;
            if (Math.abs(y) < 0.05) y = 0;
            if (Math.abs(r) < 0.05) r = 0;
            dt.move(x, y, r);
            /*
            if (gamepad1.x && !isXpressed) { // shoot
                sh.shoot(1);
            }
            if (gamepad1.y && !isYpressed) { // shoot
                sh.shoot(-1);
            }
             */

            // CM.setPower(    gamepad1.right_stick_y);

            isXpressed = gamepad1.x;
            isYpressed = gamepad1.y;

        }
    }
}
