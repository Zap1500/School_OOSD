package Assignment1;

import java.util.Objects;

//import exceptions
import Assignment1.exception.BadParameterException;
import Assignment1.exception.NullParameterException;

public class Airport{

    // private instances
    private String name;

    // constructor with error popping
    public Airport(String n)
        throws NullParameterException, BadParameterException {
            setName(n);
        }

    // getters and setters
    public String getName() {
        return name;
    }

    private void setName(String n) throws NullParameterException, BadParameterException{
        if (n.equals(null)){
            throw new NullParameterException("Please provide input.");
        }
        if (n.length() != 3) {
            throw new BadParameterException("Please provide only 3 characters in your input.");
        }
        for(int i = 0; i<3; i++) {
            if (!Character.isLetter(n.charAt(i))) {
                throw new BadParameterException("Please provide only letters in your input: " + n);
            }
        }
        for(int i = 0; i<3; i++){
            if (Character.isLowerCase(n.charAt(i))){
                throw new BadParameterException("Please provide only Uppercase Characters in your input: " + n);
            }
        }

        name = n;
    }
    // override toString() / equals()/ hashCode()
    public String toString(){
        StringBuilder sb = new StringBuilder();
        // contents
        sb.append( String.format("%-20s %s%n","Airport:", getName()) );

        return sb.toString();
    }
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass()) return false;
        Airport a = (Airport) o;
        if (!getName().equals(a.getName())){
            return false;
        }
        return true;
    }

    public int hashCode(){
        return Objects.hash(name);
    }
}
