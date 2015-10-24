package com.abdin.noorsingles.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Fadi Abdin
 */
public class PrivateProfile implements Serializable{
    
    private final List<Field> privateFields;
    
    public PrivateProfile(Application a){
        privateFields = a.getPrivate();
    }

    public List<Field> getPrivateFields() {
        return privateFields;
    }
    
    
    
    
}
