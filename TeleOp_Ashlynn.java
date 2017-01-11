

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "3736: TeleOpAshlynn", group = "TeleOp")
public class TeleOp_Ashlynn extends OpMode {


	//final static double ARM_MIN_RANGE  = 0;
	//final static double ARM_MAX_RANGE  = 1;
	//final static double BUTTON_MIN_RANGE  = 0;
	//final static double BUTTON_MAX_RANGE  = 1;

	//double armPosition;

	//double armDelta = 0.1;

	//double buttonPosition;

	//double buttonDelta = 0.1;

	 //DcMotor basket;
	 //DcMotor lift;
	 DcMotor rightSide;
	 DcMotor leftSide;
	// Servo button;
	 //Servo arm;

	 /**
	 * Constructor
	 */
	public TeleOp_Ashlynn() {

	}

	@Override
	public void init()
    {

		//basket = hardwareMap.dcMotor.get("MS");
		//lift = hardwareMap.dcMotor.get("MLift");
		rightSide = hardwareMap.dcMotor.get("MR");
		leftSide = hardwareMap.dcMotor.get("ML");
		rightSide.setDirection(DcMotor.Direction.REVERSE);

		//arm = hardwareMap.servo.get("dongus");
		//button = hardwareMap.servo.get("servo_6");

		//armPosition = 0.2;
		//buttonPosition = 0.2;
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


		//basket.setPower(y3);
		//lift.setPower(y4);

        leftSide.setPower(y2);
        rightSide.setPower(y1);

       // if (gamepad1.a)
        //{
			//armPosition += armDelta;
		//}

		//if (gamepad1.y)
       // {
			//armPosition -= armDelta;
		//}

		//if (gamepad2.x)
        //{
			//buttonPosition += buttonDelta;
		//}

		//if (gamepad2.b)
        //{
			//buttonPosition -= buttonDelta;
		//}


        //armPosition = Range.clip(armPosition, ARM_MIN_RANGE, ARM_MAX_RANGE);
       // buttonPosition = Range.clip(buttonPosition, BUTTON_MIN_RANGE, BUTTON_MAX_RANGE);


		//arm.setPosition(armPosition);
		//button.setPosition(buttonPosition);

        //telemetry.addData("Text", "*** Robot Data***");
        //telemetry.addData("arm", "arm:  " + String.format("%.2f", armPosition));
        //telemetry.addData("button", "button:  " + String.format("%.2f", buttonPosition));
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