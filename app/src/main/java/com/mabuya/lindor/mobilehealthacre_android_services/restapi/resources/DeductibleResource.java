package com.mabuya.lindor.mobilehealthacre_android_services.restapi.resources;


import java.io.Serializable;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class DeductibleResource implements Serializable {

    public DeductibleResource(){
    }

    public boolean isDeductible(){
        System.out.print("DeductibleResource: Validating health insurance claim.....\n");
        return true;
    }
    public static class Builder{
        public DeductibleResource build(){return  new DeductibleResource();}
    }
}
