import java.util.Date;

public class AirCraft {

    /**
     * The amount of time from the radio call to landing time
     */
    protected static double MIKESOUT;

    /**
     * The types of aircraft this can be
     */
    protected enum ACTYPE{
        C130,
        C130J30,
        C17,
        C5
    };

    protected int MAXPALLETS;
    protected int MAXSEATS;

    public ACTYPE myACTYPE;
    protected String myCallSign;
    protected Date myLandTime;
    protected Date myTakeOffTime;

    protected String myParkingSpot;


}
