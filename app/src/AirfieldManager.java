import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AirfieldManager {

    private Airfield myAirfield;
    private ArrayList<AirCraft> myAirCrafts;
    static final long ONE_MINUTE_IN_MILLIS=60000;//millisecs


    /**
     * Initializes a new airfield manager.
     * @param theAirfield the airfield that the manager is managing
     * @param sc the scanner used to get aircraft information
     */
    public AirfieldManager(Airfield theAirfield, Scanner sc) {

        myAirfield= theAirfield;
        myAirCrafts = new ArrayList<>();

    }

    public void processRequest(Scanner theScanner){
        System.out.println("1) Register new 30 min out call");
        System.out.println("2) Register new XX min out call");

        double mikes = 0;
        //
        AirCraft ac = new AirCraft();
        if(theScanner.nextInt() != 1){
            System.out.println("Enter mikes out");
            mikes = theScanner.nextInt();
        }else{
            mikes = 30;
        }

        System.out.println("Enter Callsign");

        ac.myCallSign = theScanner.next();

        System.out.println();
        System.out.println("Aircraft Type");
        System.out.println("1)  C130");
        System.out.println("2)  C130J-30");
        System.out.println("3)  C17");
        System.out.println("4)  C5");

        int choice = theScanner.nextInt();
        switch (choice){
            case 1:
                ac.myACTYPE = AirCraft.ACTYPE.C130;
                ac.MAXPALLETS = 6;
                ac.MAXSEATS = 92;

                break;

            case 2:
                ac.myACTYPE = AirCraft.ACTYPE.C130J30;
                ac.MAXPALLETS = 8;
                ac.MAXSEATS = 92;
                break;

            case 3:
                ac.myACTYPE = AirCraft.ACTYPE.C17;
                ac.MAXPALLETS = 18;
                ac.MAXSEATS = 188;
                break;

            case 4:
                ac.myACTYPE = AirCraft.ACTYPE.C5;
                ac.MAXPALLETS = 36;
                ac.MAXSEATS = 73;
        }



        Calendar date = Calendar.getInstance();
        long t= date.getTimeInMillis();
        Date landTime =new Date((long) (t + (mikes * ONE_MINUTE_IN_MILLIS)));

        ac.myLandTime = landTime;

        System.out.println("Land Time: "+ ac.myLandTime);



        myAirCrafts.add(ac);
        myAirfield.dispatch(ac);

        System.out.println(ac.myACTYPE.toString() + " " + ac.myCallSign + " report to parking spot: " + ac.myParkingSpot );

        System.out.println("END");
    }


}