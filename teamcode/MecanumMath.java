package org.firstinspires.ftc.teamcode;

/**
 * Created by logan on 10/22/2017.
 */

public class MecanumMath extends MecanumDrive {
    //Inits for the math
    static final double cWidth          =18;
    static final double cLength         =18;
    static final double wheelDiameter   =4.0;
    static final double wheelRadius     =wheelDiameter/2;
    static final double disPerRev       =wheelDiameter*Math.PI;

    static final double cRotK           =((cWidth + cLength)/2)/wheelRadius;

    /*  Axes of Motion
        First Column: X Axis
        Second Column: Y Axis
        Third Column: Rotate Axis   */

    static double invMatrix[][] = new double[][]{
            {  1, 1, cRotK },   /* Left Front */
            { -1, 1,-cRotK },   /* Right Front*/
            {  1, 1,-cRotK },   /* Right Rear */
            { -1, 1, cRotK }    /* Left Rear  */
    };

    void mecanumDriveFwdKinematics( double wheelSpeeds[], double velocities[]){


    }

    public void doMecanum(double vX, double vY, double vRot) {
        try {
            doMecanumInternal(vX, vY, vRot);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void doMecanumInternal(double vX, double vY, double vRot) {

    	/* Scale input values if any of them exceeds 1.0*/
        double excessRatio = (double) 1.0 / (Math.abs(vX) + Math.abs(vY) + Math.abs(vRot));
        if (excessRatio < 1.0) {
            vX *= excessRatio;
            vY *= excessRatio;
            vRot *= excessRatio;
        }
    }


}
