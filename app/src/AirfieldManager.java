import java.util.ArrayList;
import java.util.Scanner;

public class AirfieldManager {

    private Airfield myAirfield;
    private ArrayList<AirCraft> myAirCrafts;


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
        System.out.println("1) Register new 30 min out call\n");
        System.out.print("2) Register new XX min out call\n");

        double mikes = 0;
        //
        AirCraft ac = new AirCraft();
        if(theScanner.nextInt() != 1){
            //todo: prompt for minutes out
        }else{
            mikes = 30;
        }

        System.out.println();
        System.out.println("Aircraft Type");
        System.out.println("1)  C130");
        System.out.println("2)  C130J-30");
        System.out.println("3)  C17");
        System.out.println("4)  C5");

        int choice = theScanner.nextInt();
        switch (choice){
            case 1:
                ac.ACTYPE = "C130";
                ac.MAXPALLETS = 6;
                break;

            case 2:
                ac.ACTYPE = "C130J-30";
                ac.MAXPALLETS = 8;
                break;

            case 3:
                ac.ACTYPE = "C17";
                ac.MAXPALLETS = 18;
                break;

            case 4:
                ac.ACTYPE = "C5";
                ac.MAXPALLETS = 36;
        }


        myAirCrafts.add(ac);

    }

}
