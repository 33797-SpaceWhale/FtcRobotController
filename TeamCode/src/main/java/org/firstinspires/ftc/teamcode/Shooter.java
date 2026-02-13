package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Shooter {

    public final DcMotor CM;

    public Shooter(LinearOpMode linearOpMode) {
        this.CM = linearOpMode.hardwareMap.get(DcMotor.class, "cm");
    }

    public void shoot(double power) {
        CM.setPower(power);
    }
}
