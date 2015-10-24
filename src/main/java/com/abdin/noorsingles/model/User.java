package com.abdin.noorsingles.model;

import java.io.Serializable;

/**
 *
 * @author fabdin
 */
public class User implements Serializable {
    
    String name;
    String email;
    String cellPhone;
    String guardian;
    String address;
    String reference1;
    String reference2;    
//        fields.add("Full Name");
//        fields.add("Email");
//        fields.add("Cell Phone");
//        fields.add("Name of guardian");
//        fields.add("Address");
//        fields.add("Reference 1");
//        fields.add("Reference 2");
    
    public User(){
        
    }
    public User(Application a){
        a.getPrivate();
    }
    
}
