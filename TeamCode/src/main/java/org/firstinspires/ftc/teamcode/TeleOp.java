

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "3736: TeleOp", group = "TeleOp")
public class TeleOp extends OpMode {


	final static double BALL_MIN_RANGE  = 0;
	final static double BALL_MAX_RANGE  = 1;


	double ballPosition;

	double ballDelta = 0.1;

	 DcMotor basket;
	 DcMotor Rlift;
	 DcMotor Llift;
	 DcMotor rightSide;
	 DcMotor leftSide;
	 //Servo ball;


	public TeleOp() {

	}

	@Override
	public void init()
    {

		basket = hardwareMap.dcMotor.get("MS");
		Rlift = hardwareMap.dcMotor.get("RMLift");
		Llift = hardwareMap.dcMotor.get("LMLift");
		rightSide = hardwareMap.dcMotor.get("MR");
		leftSide = hardwareMap.dcMotor.get("ML");
		rightSide.setDirection(DcMotor.Direction.REVERSE);
		//ball = hardwareMap.servo.get("ball");

		//ballPosition = 0.1;
	}

	@Override
	public void loop()
	{
		float y1 = gamepad1.left_stick_y;
		float y2 = gamepad1.right_stick_y;
		float y3 = gamepad2.left_stick_y;
		float y4 = gamepad2.right_stick_y;

		y1 = Range.clip(y1, -1, 1);
		y2 = Range.clip(y2, -1, 1);
		y3 = Range.clip(y3, -1, 1);
		y4 = Range.clip(y4, -1, 1);

		y1 = (float)scaleInput(y1);
		y2 = (float)scaleInput(y2);
		y3 = (float)scaleInput(y3);
        y4 = (float)scaleInput(y4);


		basket.setPower(y3);
		Rlift.setPower(y4);
		Llift.setPower(y4);

        leftSide.setPower(y2);
        rightSide.setPower(y1);

		//if (gamepad1.a)
		{
		//	ballPosition += ballDelta;
		}

		//if (gamepad1.y)
		{
		//	ballPosition -= ballDelta;
		}



        //ballPosition = Range.clip(ballPosition, BALL_MIN_RANGE, BALL_MAX_RANGE);

		//ball.setPosition(ballPosition);

        telemetry.addData("Text", "*** Robot Data***");
        //telemetry.addData("ball", "ball:  " + String.format("%.2f", ballPosition));
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