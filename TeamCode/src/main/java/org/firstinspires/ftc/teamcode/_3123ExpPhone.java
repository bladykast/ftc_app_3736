

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "3123Experimental", group = "TeleOp")
public class _3123ExpPhone extends OpMode {

    DcMotor rightSide;
    DcMotor leftSide;


    public _3123ExpPhone() {

    }

    @Override
    public void init()
    {

        rightSide = hardwareMap.dcMotor.get("MR");
        leftSide = hardwareMap.dcMotor.get("ML");
        leftSide.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop()
    {
        float y1 = gamepad1.left_stick_y;
        float y2 = gamepad1.right_stick_y;

        y1 = Range.clip(y1, -1, 1);
        y2 = Range.clip(y2, -1, 1);

        y1 = (float)scaleInput(y1);
        y2 = (float)scaleInput(y2);

        leftSide.setPower(y1);
        rightSide.setPower(y2);

        telemetry.addData("Text", "*** Robot Data***");
            }


    @Override
    public void stop() {

    }

    double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

        int index = (int) (dVal * 16.0);

        if (index < 0) {
            index = -index;
        }

        if (index > 16) {
            index = 16;
        }

        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        return dScale;
    }
}