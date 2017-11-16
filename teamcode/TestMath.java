package org.firstinspires.ftc.teamcode;

/**
 * Created by logan on 10/13/2017.
 */

public class TestMath extends TestOpMode {
    //Setting up math to control the wheels for Mecanum
    double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
    double robotAngle = Math.atan2(gamepad1.left_stick_y,gamepad1.left_stick_x) - Math.PI / 4;
    double rightX = gamepad1.left_stick_x;
    final double flPower = r * Math.cos(robotAngle) + rightX;
    final double rlPower = r * Math.sin(robotAngle) + rightX;
    final double frPower = r * Math.sin(robotAngle) - rightX;
    final double rrPower = r * Math.cos(robotAngle) - rightX;

}
