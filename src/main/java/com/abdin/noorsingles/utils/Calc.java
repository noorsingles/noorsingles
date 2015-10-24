package com.abdin.noorsingles.utils;

import java.util.Objects;

/**
 *
 * @author fabdin
 */
public class Calc {
    
    public static int getHashCodeFromTimestamp(String timestamp){
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(timestamp);
        if(hash<0) hash=hash*-1;
        return hash;
    }
    
}
