package Assignment1;

import Assignment1.exception.BadParameterException;
import Assignment1.exception.NullParameterException;

import java.util.Objects;

public class Airline {

    // private instances
    private String name;

    // constructor with error popping
    public Airline(String n)
        throws NullParameterException, BadParameterException {
            setName(n);
        }

    // getters and setters
    public String getName() {
        return name;
    }
    private void setName(String n) throws NullParameterException, BadParameterException{
        if (n.equals(null) || n.length() < 1){
            throw new NullParameterException("Please provide input.");
        }
        if (n.length() > 8) {
            throw new BadParameterException("Please provide only 8 characters or less in your input.");
        }

        name = n;
    }
    // override toString() / equals()/ hashCode()
    public String toString(){
        StringBuilder sb = new StringBuilder();
        // contents
        sb.append( String.format("%-20s %s%n","Airline:", getName()) );

        return sb.toString();
    }
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass()) return false;
        Airline a = (Airline) o;
        if(!getName().equals(a.getName())){
            return false;
        }
        return true;
    }

    public int hashCode(){
        return Objects.hash(name);
    }

}
