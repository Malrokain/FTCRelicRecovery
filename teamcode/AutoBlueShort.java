package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by logan on 10/7/2017.
 */

@TeleOp(name="Auto Blue Short", group="Auto OpMode")
@Disabled

public class AutoBlueShort extends OpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor flDrive = null;
    private DcMotor rlDrive = null;
    private DcMotor frDrive = null;
    private DcMotor rrDrive = null;
    private DcMotor armDrive1 = null;
    private CRServo armDrive2 = null;
    private CRServo clawDrive = null;
    private ColorSensor color_Sensor;
    private Servo colorServo = null;

    //Controls


    // Init
    @Override
    public void init(){
        //Must map robot configuration names on app
        //Drive system
        flDrive  = hardwareMap.get(DcMotor.class, "flDrive");
        rlDrive = hardwareMap.get(DcMotor.class, "rlDrive");
        frDrive  = hardwareMap.get(DcMotor.class, "frDrive");
        rrDrive = hardwareMap.get(DcMotor.class, "rrDrive");
        //Gizmos
        armDrive1 = hardwareMap.get(DcMotor.class, "armDrive1");
        armDrive2 = hardwareMap.get(CRServo.class, "armDrive2");
        clawDrive = hardwareMap.get(CRServo.class, "clawDrive");
        color_Sensor = hardwareMap.get(ColorSensor.class, "colorSensor");
        colorServo = hardwareMap.get(Servo.class, "colorServo");

        //Aligning drive    Reversing left side
        flDrive.setDirection(DcMotor.Direction.REVERSE);
        rlDrive.setDirection(DcMotor.Direction.REVERSE);
        frDrive.setDirection(DcMotor.Direction.FORWARD);
        rrDrive.setDirection(DcMotor.Direction.FORWARD);
        //Setting gizmos
        armDrive1.setDirection(DcMotor.Direction.FORWARD);
        armDrive2.setDirection(DcMotorSimple.Direction.FORWARD);
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
        //Autonomous code
        if (getRuntime()<1){
            colorServo.setPosition(0);
            color_Sensor.enableLed(true);
            if (color_Sensor.red()<color_Sensor.blue()){ //sensor sees blue
                flDrive.setPower(-.1);
                rlDrive.setPower(-.1);
                frDrive.setPower(-.1);
                rrDrive.setPower(-.1);
            }
            else { //Sensor sees red
                flDrive.setPower(.1);
                rlDrive.setPower(.1);
                frDrive.setPower(.1);
                rrDrive.setPower(.1);

            }
        }
        else if (getRuntime()<3.1) {
            colorServo.setPosition(0.5);
            flDrive.setPower(-.5);
            rlDrive.setPower(-.5);
            frDrive.setPower(-.5);
            rrDrive.setPower(-.5);
        } else {
            colorServo.setPosition(0.5);
            flDrive.setPower(0);
            rlDrive.setPower(0);
            frDrive.setPower(0);
            rrDrive.setPower(0);
            color_Sensor.enableLed(false);
        }



        //Telemetry insert
        telemetry.addData("Left X", gamepad1.left_stick_x);
        telemetry.addData("Left Y", gamepad1.left_stick_y);
        telemetry.addData("Right X", gamepad1.right_stick_x);
        telemetry.addData("Left Bump", gamepad1.left_bumper);
        telemetry.addData("Right Bump", gamepad1.right_bumper);
        //telemetry.addData("Test", gamepad1.dpad_up);
        telemetry.addData("Red", color_Sensor.red());
        telemetry.addData("Blue", color_Sensor.blue());
        telemetry.addData("Green", color_Sensor.green());
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        //telemetry.addData("Motors", "left (%.2f), right (%.2f)");

    }

    //
}
