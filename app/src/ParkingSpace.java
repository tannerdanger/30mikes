import java.util.ArrayList;

public class ParkingSpace {
    private String ROWNAME; //Alpha one
    private ArrayList ROW;
    private int SPOT;
    private AirCraft myParkedAircraft;

    public ParkingSpace(ArrayList row, String theName, int theSpot){
        ROW= row;
        ROWNAME = theName;
        SPOT = theSpot;

    }

    public void parkAircraft(AirCraft theAc){
        this.myParkedAircraft = theAc;
    }

    public AirCraft getMyParkedAircraft(){
        return myParkedAircraft;
    }

    public String getSPOT_NAME(){
        return ROWNAME + SPOT;
    }

}
