package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.PWMOutput;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by logan on 10/7/2017.
 */

@TeleOp(name="Driver Mode", group="Teleop Opmode")
//Disabled

public class TestOpMode extends OpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor flDrive = null;
    private DcMotor rlDrive = null;
    private DcMotor frDrive = null;
    private DcMotor rrDrive = null;
    private DcMotor armDrive1 = null;
    private CRServo clawDrive = null;

    //Controls


    // Init
    @Override
    public void init(){
        //Drive system
        //Must map robot configuration names on app
        flDrive  = hardwareMap.get(DcMotor.class, "flDrive");
        rlDrive = hardwareMap.get(DcMotor.class, "rlDrive");
        frDrive  = hardwareMap.get(DcMotor.class, "frDrive");
        rrDrive = hardwareMap.get(DcMotor.class, "rrDrive");
        armDrive1 = hardwareMap.get(DcMotor.class, "armDrive1");
        clawDrive = hardwareMap.get(CRServo.class, "clawDrive");

        //Aligning drive
        //Reversing left side
        flDrive.setDirection(DcMotor.Direction.REVERSE);
        rlDrive.setDirection(DcMotor.Direction.REVERSE);
        frDrive.setDirection(DcMotor.Direction.FORWARD);
        rrDrive.setDirection(DcMotor.Direction.FORWARD);
        armDrive1.setDirection(DcMotor.Direction.FORWARD);
        clawDrive.setDirection(DcMotorSimple.Direction.FORWARD);

        //Init complete report
        telemetry.addData("Status", "Initialized");
    }

    //Init loop runs until started
    @Override
    public void init_loop(){
    }

    //Run when starting
    @Override
    public void start() {
        runtime.reset();
}

    //Code to loop between starting and stopping
    @Override
    public void loop(){
        //Set motors
        /*
        double flPower;
        double rlPower;
        double frPower;
        double rrPower;
        double armPower1;
        double armPower2;
        double clawPower;
        */

        /*
        //Set controller inputs
        double forward  = gamepad1.left_stick_x;
        double strafe   = gamepad1.left_stick_y;
        double rotate   = gamepad1.right_stick_x;
        boolean turnU   = gamepad1.dpad_up;
        boolean turnD   = gamepad1.dpad_down;
        boolean turnL   = gamepad1.dpad_left;
        boolean turnR   = gamepad1.dpad_right;
        if (turnU && turnL){boolean turnUL = true;};
        if (turnU && turnR){boolean turnUR = true;};
        if (turnD && turnR){boolean turnDL = true;};
        if (turnD && turnR){boolean turnDR = true;};
        */

        //basic drive control test
        /*
        flPower = gamepad1.left_stick_y;
        rlPower = gamepad1.left_stick_y;
        frPower = gamepad1.right_stick_y;
        rrPower = gamepad1.right_stick_y;
        */

        //Mecanum drive test

        double r = Math.hypot(-gamepad1.left_stick_x, gamepad1.left_stick_y);
        double robotAngle = Math.atan2(gamepad1.left_stick_y,-gamepad1.left_stick_x) - Math.PI / 4;
        double rightX = -gamepad1.right_stick_x;
        final double flPower = r * Math.sin(robotAngle) - rightX;
        final double rlPower = r * Math.cos(robotAngle) - rightX;
        final double frPower = r * Math.cos(robotAngle) + rightX;
        final double rrPower = r * Math.sin(robotAngle) + rightX;

        flDrive.setPower(flPower*flPower*flPower);
        rlDrive.setPower(rlPower*rlPower*rlPower);
        frDrive.setPower(frPower*frPower*frPower);
        rrDrive.setPower(rrPower*rrPower*rrPower);

        //Arm controls


        if (gamepad1.left_trigger > 0) {
            final double armPower1 = gamepad1.left_trigger*gamepad1.left_trigger*gamepad1.left_trigger*.7;
            armDrive1.setPower(armPower1);
        }
        else if (gamepad1.right_trigger > 0) {
            final double armPower1 = -gamepad1.right_trigger*gamepad1.right_trigger*gamepad1.right_trigger*.7;
            armDrive1.setPower(armPower1);
        }
        else {
            armDrive1.setPower(0);
        }


        if (gamepad1.left_bumper) {
            final double clawPower = .4;
            clawDrive.setPower(clawPower);
        }
        else if(gamepad1.right_bumper) {
            final double clawPower = -.4;
            clawDrive.setPower(clawPower);
        }
        else {
            clawDrive.setPower(0);
        }




        //Telemetry insert
        telemetry.addData("Left X", gamepad1.left_stick_x);
        telemetry.addData("Left Y", gamepad1.left_stick_y);
        telemetry.addData("Right X", gamepad1.right_stick_x);
        telemetry.addData("Left Bump", gamepad1.left_bumper);
        telemetry.addData("Right Bump", gamepad1.right_bumper);
        //telemetry.addData("Test", gamepad1.dpad_up);
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        //telemetry.addData("Motors", "left (%.2f), right (%.2f)");

    }

    //
}
