package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Sosi {

    public final DcMotor SS;

    public Sosi(LinearOpMode linearOpMode) {
        this.SS = linearOpMode.hardwareMap.get(DcMotor.class, "ss");
    }

    public void sosat(double power) {
        SS.setPower(power);
    }
}