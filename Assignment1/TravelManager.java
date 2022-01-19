package Assignment1;

import Assignment1.exception.BadParameterException;
import Assignment1.exception.NullParameterException;
import java.util.Date;
import java.util.UUID;

public class TravelManager {
    public static void main(String[] args) throws BadParameterException, NullParameterException {

        //String z = "Traveller";
//        String z2 = "Station";
//        String z3 = "Challenger";
//        String z4 = "Moon Station";
        String z2 = "STA";
        String z3 = "Call";
        String z4 = "MOO";
        String z5 = "Random";
        Date t = new Date();

        UUID uuid = UUID.randomUUID();
        String nwUuid = uuid.toString().replaceAll("-", "");
        nwUuid = nwUuid.substring(0,4);
        //Airline a1 = new Airline(z);

        Airport b1 = new Airport(z2);

        Airline a2 = new Airline(z3);
        Airport b2 = new Airport(z4);
        Flight c1 = new Flight(a2, b1, b2, nwUuid, t);

        System.out.println(c1);
    }
}
