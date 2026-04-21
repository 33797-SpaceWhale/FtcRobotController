package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp
public class telepop extends LinearOpMode {
    DcMotor CM;
    Drivetrain dt;
    Shooter sh;
    Intake ss;
    DistanceSensor sensorDistance;
    Servo servo;

    @Override
    public void runOpMode() {
        dt = new Drivetrain(this);
        sh = new Shooter(this);
        ss = new Intake(this);

        sensorDistance = hardwareMap.get(DistanceSensor.class, "sensor_distance");
        servo = hardwareMap.get(Servo.class, "left_hand");

        telemetry.addData("deviceName", sensorDistance.getDeviceName());
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
            if (gamepad1.x) ss.work(-1);
            if (gamepad1.y) ss.work(0);

            if (gamepad1.dpad_down) servo.setPosition(0);
            if (gamepad1.dpad_up) servo.setPosition(1);

            telemetry.addData("range", String.format("%.01f cm", sensorDistance.getDistance(DistanceUnit.CM)));
            telemetry.update();
        }
    }
}
