package com.example.jag.ex02passingdatatodialog;

import java.io.Serializable;

/**
 * Created by jpulakhandam on 3/27/2015.
 */
public class SampleData implements Serializable {
    String _value;

    public void setValue(String value){
        _value = value;
    }

    public String Value(){
        return _value;
    }

}
