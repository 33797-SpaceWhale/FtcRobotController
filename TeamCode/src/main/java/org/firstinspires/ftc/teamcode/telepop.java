package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp
public class telepop extends LinearOpMode {
    DcMotor CM;

    boolean isXpressed, isYpressed = false;

    //Shooter sh;
    Drivetrain dt;
    Shooter sh;
    Sosi ss;
    DistanceSensor sensorDistance;

    @Override
    public void runOpMode() {
        dt = new Drivetrain(this);
        sh = new Shooter(this);
        ss = new Sosi(this);

        //sh = new Shooter(this);

        // CM = hardwareMap.dcMotor.get("cm");
        // CM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // CM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sensorDistance = hardwareMap.get(DistanceSensor.class, "sensor_distance");
        telemetry.addData("deviceName", sensorDistance.getDeviceName() );
        telemetry.addData("range", String.format("%.01f mm", sensorDistance.getDistance(DistanceUnit.MM)));
        telemetry.addData("range", String.format("%.01f cm", sensorDistance.getDistance(DistanceUnit.CM)));
        telemetry.addData("range", String.format("%.01f m", sensorDistance.getDistance(DistanceUnit.METER)));
        telemetry.addData("range", String.format("%.01f in", sensorDistance.getDistance(DistanceUnit.INCH)));

        telemetry.update();

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
            if (gamepad1.a) sh.shoot(-1);
            if (gamepad1.b) sh.shoot(0);
            if (gamepad1.x) ss.sosat(-1);
            if (gamepad1.y) ss.sosat(0);
            telemetry.addData("deviceName", sensorDistance.getDeviceName() );
            telemetry.addData("range", String.format("%.01f mm", sensorDistance.getDistance(DistanceUnit.MM)));
            telemetry.addData("range", String.format("%.01f cm", sensorDistance.getDistance(DistanceUnit.CM)));
            telemetry.addData("range", String.format("%.01f m", sensorDistance.getDistance(DistanceUnit.METER)));
            telemetry.addData("range", String.format("%.01f in", sensorDistance.getDistance(DistanceUnit.INCH)));

            telemetry.update();

        }
    }
}
