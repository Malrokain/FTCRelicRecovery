package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by logan on 10/22/2017.
 */
/*
@TeleOp(name="Mecanum3", group="OpMode")
@Disabled

public class Mecanum3 extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor flDrive = null;
    private DcMotor rlDrive = null;
    private DcMotor frDrive = null;
    private DcMotor rrDrive = null;
    private DcMotor armDrive = null;
    private CRServo clawDrive = null;

    @Override
    public void init(){
        // Call for motor configuration
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

        //Init complete report
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void init_loop(){
    }

    @Override
    public void start(){
        runtime.reset();
    }

    public static double calc1(double Vd, double Td, double Vt){
        double V;

        V = Vd * Math.sin(Td + (Math.PI/4)) + Vt;
        return V;
    }

    public static double calc2(double Vd, double Td, double Vt){
        double V;

        V = Vd * Math.cos(Td + (Math.PI/4)) +Vt;
        return V;
    }
    public static void main(String[] args){
        double V1;          //Voltage multiplier for the LF wheel
        double V2;          //Voltage multiplier for the RF wheel
        double V3;          //Voltage multiplier for the LR wheel
        double V4;          //Voltage multiplier for the RR wheel
        double Vd = 1;      //Robot Speed [-1,1]

        double Td = 90;      //Robot Angle
        double Vt = 0;      //Direction change speed [-1,1]

        V1 = calc1(Vd, Td, Vt);
        V2 = calc2(Vd, Td, Vt);
        V3 = calc2(Vd, Td, Vt);
        V4 = calc1(Vd, Td, Vt);

        System.out.println("V1 = " + V1);
        System.out.println("V2 = " + V2);
        System.out.println("V3 = " + V3);
        System.out.println("V4 = " + V4);
    }

    @Override
    public void stop() {
    }
}
*/