import java.util.Date;

public class AirCraft {
    protected static double MIKESOUT;
    //TODO: Enum
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
