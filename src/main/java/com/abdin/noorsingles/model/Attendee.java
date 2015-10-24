package com.abdin.noorsingles.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabdin
 */
public class Attendee implements Serializable{
    
    private String badge;
    private String firstName;
    private String lastName;
    private String email;
    private String cellphone;
    private String ticketType;
    private String dob;
    private String interest;
    List<Attendee> matches=new ArrayList<Attendee>();

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getFirstName() {
        
        firstName=firstName.substring(0,1).toUpperCase()+firstName.substring(1, firstName.length()).toLowerCase();
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        lastName=lastName.substring(0,1).toUpperCase()+lastName.substring(1, lastName.length()).toLowerCase();
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getInterest() {
        return interest;
    }
    public String[] getInterests(){
        if(interest==null) return new String[0];
        return interest.split(",");
    }
    
    public boolean hasInterest(String interest){
        
        for(String i:getInterests()){
            if(i.equals(interest)){
                return true;
            }
        }
        return false;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public List<Attendee> getMatches() {
        return matches;
    }

    public void setMatches(List<Attendee> matches) {
        this.matches = matches;
    }
    
    public void addMatch(Attendee attendee){
        this.matches.add(attendee);
    }
    

    List<Field> fields = new ArrayList<Field>();

    boolean INCLUDE_EMPTY_FIELD = false;

    public void add(String label, String value) {
        Field f = new Field(label.trim(), value);
        fields.add(f);
        setValue(label,value);
        
        
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setValue(String label,String value) {

         switch (label.trim()) {
            
            case ("Badge"): {
                this.badge = value;
                break;
            }
            case ("First Name"): {
                this.firstName = value;
                break;
            }
            case ("Last Name"): {
                this.lastName = value;
                break;
            }
            case ("Email"): {
                this.email = value;
                break;
            }
            case ("Cell Phone"): {
                this.cellphone = value;
                break;
            }
            case ("Ticket Type"): {
                this.ticketType = value;
                break;
            }
            case ("Birth Date"): {
                this.dob = value;
                break;
            }
            case ("Interest"): {
                this.interest = value;
                break;
            }

        }

    }

    @Override
    public String toString() {
        
        StringBuffer sb = new StringBuffer();
        for (Field f : fields) {
            //System.out.println(f);
            //sb.append("<br/> \n" + f.getLabel() + " : " + f.getValue());
        }
       // System.out.println("------------");
        return sb.toString();

    }
}
