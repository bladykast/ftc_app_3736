/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;



@Autonomous(name="3736: ToB Code", group="Pushbot")

public class shotsfired extends LinearOpMode {

    /* Declare OpMode members. */
    SBHardware robot = new SBHardware();
    private ElapsedTime runtime = new ElapsedTime();


    static final double FORWARD_SPEED = 0.8;
    static final double TURN_SPEED = 0.5;
    static final double FLIP_SPEED = 1.0;
    static final double OFF_SPEED = 0.0;

    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        sleep(5000);
            robot.basket.setPower(-1);
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() < 1.5)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();

            robot.basket.setPower(OFF_SPEED);
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() < 1.0)) {
                telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                telemetry.update();

                robot.flicker.setPower(FLIP_SPEED);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 1.4)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }
                robot.flicker.setPower(OFF_SPEED);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 1.0)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }
                robot.ball.setPosition(1.3);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 1.0)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }
                robot.flicker.setPower(FLIP_SPEED);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 1.0)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }
                robot.flicker.setPower(OFF_SPEED);
               runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 1.0)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }

                telemetry.addData("Path", "Complete");
                telemetry.update();
                sleep(1000);
            }
        }
    }
}