package com.abdin.noorsingles.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author fabdin
 */
public class Application implements Serializable{

    List<Field> fields = new ArrayList<Field>();
    
    boolean INCLUDE_EMPTY_FIELD=false;
    
    public void add(String label, String value) {

        fields.add(new Field(label.trim(),value));
    }

    public List<Field> getFields() {
        return fields;
    }

    
    
    public List<Field> getPrivate(){
        List<Field> privateFields=new ArrayList<Field>();
        
        for(Field f:fields){
            if(isPrivate(f.getLabel())){
                if(INCLUDE_EMPTY_FIELD){
                    privateFields.add(f);
                }else if(f.getValue()!=null && !f.getValue().equals("")){
                    privateFields.add(f);
                }
            }
        }
        return privateFields;
    }

    public List<Field> getPublic(){
        List<Field> publicFields=new ArrayList<Field>();
        
        for(Field f:fields){
            if(isPublic(f.getLabel())){
                if(INCLUDE_EMPTY_FIELD){
                    publicFields.add(f);
                }else if(f.getValue()!=null && !f.getValue().equals("")){
                    publicFields.add(f);
                }
            }
        }
        return publicFields;
    }
        
    public List<Field> getPartnerPreferences(){
        List<Field> prefList=new ArrayList<Field>();
        
        for(Field f:fields){
            if(isPartner(f.getLabel())){
                
                if(INCLUDE_EMPTY_FIELD){
                    prefList.add(f);
                }else if(f.getValue()!=null && !f.getValue().equals("")){
                    prefList.add(f);
                }
            }
        }
        
        return prefList;
    }
    
    
     private List<String> getPrivateFields() {
        List<String> fields = new ArrayList<String>();

        fields.add("Full Name");
        fields.add("Email");
        fields.add("Cell Phone");
        fields.add("Name of guardian");
        fields.add("Address");
        fields.add("Reference 1");
        fields.add("Reference 2");
        
        return fields;
    }
    

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();

        for (Field f : fields) {

            sb.append("\n" + f.getLabel() + " : " + f.getValue());
        }
        return sb.toString();

    }

    private boolean isPrivate(String label) {
        
        return getPrivateFields().contains(label);
    }
    
    private boolean isPublic(String label){
        if(!isPrivate(label) && !isPartner(label)){
            return true;
        }
        return false;
    }
    
    private boolean isPartner(String label){
        if(label.startsWith("P:")) return true;
        
        return false;
    }
    
    public String getFieldValue(String label){
        for(Field f:fields){
            if(f.getLabel().equals(label)){
                return f.value;
            }
        }
        return null;
    }

    public String getTimeStamp() {
        
        for(Field f: getPublic()){
          if(f.getLabel().equals("Timestamp")){
              return f.getValue();
          }
        }
        
        return null;
    }

}
