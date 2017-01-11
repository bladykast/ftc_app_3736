package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Motor channel:  Manipulator drive motor:  "left_arm"
 * Servo channel:  Servo to open left claw:  "left_hand"
 * Servo channel:  Servo to open right claw: "right_hand"
 */
public class SBHardware
{
    /* Public OpMode members. */
    public DcMotor  basket   = null;
    public DcMotor  Rlift  = null;
    public DcMotor  Llift    = null;
    public DcMotor  rightSide    = null;
    public DcMotor  leftSide   = null;
    public DcMotor  flicker    = null;
    public Servo    ball   = null;

    public static final double MID_SERVO       =  0.5 ;
    public static final double BALL_UP_POWER    =  0.45 ;
    public static final double BALL_DOWN_POWER  = -0.45 ;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public SBHardware(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        basket   = hwMap.dcMotor.get("MS");
        Rlift  = hwMap.dcMotor.get("RMLift");
        Llift    = hwMap.dcMotor.get("LMLift");
        flicker  = hwMap.dcMotor.get("fl");
        rightSide    = hwMap.dcMotor.get("MR");
        leftSide    = hwMap.dcMotor.get("ML");
        leftSide.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightSide.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors

        // Set all motors to zero power
        basket.setPower(0);
        Rlift.setPower(0);
        Llift.setPower(0);
        rightSide.setPower(0);
        leftSide.setPower(0);
        flicker.setPower(0);
        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        basket.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Rlift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Llift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightSide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftSide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        flicker.setMode (DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        // Define and initialize ALL installed servos.
        ball = hwMap.servo.get("left_hand");
        ball.setPosition(MID_SERVO);

    }

    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     */
    public void waitForTick(long periodMs) {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}

