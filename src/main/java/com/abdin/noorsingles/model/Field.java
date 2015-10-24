package com.abdin.noorsingles.model;

import java.io.Serializable;

/**
 *
 * @author fabdin
 */
public class Field implements Serializable{
    String label;
    String value;

    Field(String label, String value) {
       this.label=label;
       this.value=value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
       
        return this.label+":"+this.value;
    }
    
    
}
