package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.MecanumMath;

/**
 * Created by logan on 10/15/2017.
 */
@TeleOp(name="Mecanum Drive", group="Opmode")
@Disabled

public class MecanumDrive extends OpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor flDrive = null;
    private DcMotor rlDrive = null;
    private DcMotor frDrive = null;
    private DcMotor rrDrive = null;
    private DcMotor armDrive = null;
    private CRServo clawDrive = null;

    @Override
    public void init(){
        // Call for mecanum configuration
        flDrive  = hardwareMap.get(DcMotor.class, "flDrive");
        rlDrive = hardwareMap.get(DcMotor.class, "rlDrive");
        frDrive  = hardwareMap.get(DcMotor.class, "frDrive");
        rrDrive = hardwareMap.get(DcMotor.class, "rrDrive");
        armDrive = hardwareMap.get(DcMotor.class, "armDrive");
        clawDrive = hardwareMap.get(CRServo.class, "clawDrive");
        // Reverse one side to align motors
        flDrive.setDirection(DcMotor.Direction.REVERSE);
        rlDrive.setDirection(DcMotor.Direction.REVERSE);
        frDrive.setDirection(DcMotor.Direction.FORWARD);
        rrDrive.setDirection(DcMotor.Direction.FORWARD);
        armDrive.setDirection(DcMotor.Direction.FORWARD);
        clawDrive.setDirection(DcMotorSimple.Direction.FORWARD);

    }

    @Override
    public void init_loop(){
    }

       @Override
    public void start(){
        runtime.reset();
    }

    @Override
    public void loop(){
        //


        //MecanumMath.doMecanum(gamepad1.left_stick_x,gamepad1.left_stick_y,gamepad1.right_stick_x);
    }

    @Override
    public void stop() {
    }
}

