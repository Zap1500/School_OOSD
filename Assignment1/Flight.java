package Assignment1;

import Assignment1.exception.BadParameterException;
import Assignment1.exception.NullParameterException;

import java.util.Date;
import java.util.UUID;
import java.util.Objects;

public class Flight {
    // private instances
    private Airline aline;
    private Airport orig;
    private Airport destin;
    private String flynum;
    private Date depart;

    // constructor with error popping
    public Flight(Airline a, Airport o, Airport des, String fn, Date dep)
            throws NullParameterException, BadParameterException {
        setAirline(a);
        setOrigin(o);
        setDestination(des);
        setFlightNumber(fn);
        setDepartureTime(dep);
    }


    // getters and setters
    public Airline getAirline() {
        return aline;
    }
    public Airport getOrigin() {
        return orig;
    }
    public Airport getDestination() {
        return destin;
    }
    public String getFlightNumber() {
        return flynum;
    }
    public Date getDate() {
        return depart;
    }

    private void setAirline(Airline nwline) throws NullParameterException{
    if (nwline.equals(null)){
        throw new NullParameterException("There is no airline inputted.");
    }
    aline = nwline;
    }

    private void setOrigin(Airport nwOrg) throws NullParameterException{
    if (nwOrg.equals(null)){
        throw new NullParameterException("There is no origin inputted.");
    }
    orig = nwOrg;
    }

    private void setDestination(Airport nwDestin) throws NullParameterException{
    if (nwDestin.equals(null)){
        throw new NullParameterException("There is no destination inputted.");
    }
    destin = nwDestin;
    }

    private void setFlightNumber(String nwFlynum) throws NullParameterException, BadParameterException{
        if (nwFlynum.equals(null)){
            throw new NullParameterException("There is no Flight Number inputted.");
        }

        flynum = nwFlynum;
    }

    private void setDepartureTime(Date nwDepart) throws NullParameterException, BadParameterException{
        if (nwDepart.equals(null)){
            throw new NullParameterException("There is no Date inputted.");
        }

        depart = nwDepart;
    }

  //   override toString() / equals()/ hashCode()
    public String toString(){
        StringBuilder sb = new StringBuilder();
        // contents
        sb.append( String.format("%-20s %s%n","Airline:", getAirline()) );
        sb.append( String.format("%-20s %s%n","Airport Origin:", getOrigin()) );
        sb.append( String.format("%-20s %s%n","Airport Destination:", getDestination()) );
        sb.append( String.format("%-20s %s%n","Flight Number:", getFlightNumber()) );
        sb.append( String.format("%-20s %s%n","Departure Time:", getDate()) );
        return sb.toString();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight a = (Flight) o;
        if(!getAirline().equals(a.getAirline())){
            return false;
        }
        if(!getOrigin().equals(a.getOrigin())){
            return false;
        }
        if(!getFlightNumber().equals(a.getFlightNumber())){
            return false;
        }
        if(!getDestination().equals(a.getDestination())){
            return false;
        }
        if(!getDate().equals(a.getDate())){
            return false;
        }
        return true;
    }

    public int hashCode(){
        return Objects.hash(aline, orig, destin, flynum, depart);
    }
}
