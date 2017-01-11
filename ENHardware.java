package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


public class ENHardware
{

    public DcMotor  rightSide    = null;
    public DcMotor  leftSide   = null;




    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public ENHardware(){

    }

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;


        rightSide    = hwMap.dcMotor.get("MR");
        leftSide    = hwMap.dcMotor.get("ML");
        leftSide.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightSide.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors


        rightSide.setPower(0);
        leftSide.setPower(0);


        rightSide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftSide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


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

