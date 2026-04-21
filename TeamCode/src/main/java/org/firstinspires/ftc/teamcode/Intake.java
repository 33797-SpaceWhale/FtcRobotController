package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 *  Класс описывающий захват установленный на роботе.
 *
 */
public class Intake {

    public final DcMotor SS;

    /**
     * Конструктор класса, который создает необходимые для его работы переменные и конфигурационные строчки
     * @param linearOpMode опмод в котором запускается и используется наш захват. Поставь {@code this} и не ошибешься.
     */
    public Intake(LinearOpMode linearOpMode) {
        // тут ничего кроме конфига нет :)
        this.SS = linearOpMode.hardwareMap.get(DcMotor.class, "ss");
    }

    /**
     * Метод для запуска захвата
     * @param power мощность с которой запускается захват (значения от {@code -1} до {@code 1})
     */
    public void work(double power) {
        SS.setPower(power);
    }
}