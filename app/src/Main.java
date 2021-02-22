import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Airfield airfield = new Airfield();

        AirfieldManager airfieldManager = new AirfieldManager(airfield, sc);

        airfieldManager.processRequest(sc);

    }

}
