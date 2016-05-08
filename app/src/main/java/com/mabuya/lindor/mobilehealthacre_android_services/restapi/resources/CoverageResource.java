package com.mabuya.lindor.mobilehealthacre_android_services.restapi.resources;

import java.io.Serializable;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class CoverageResource implements Serializable {
    public CoverageResource() {
    }

    public boolean isCovered(){
        System.out.print("CoverageResource: Validating health insurance claim.....\n");
        return true;
    }

    public static class Builder{
        }
        public CoverageResource build(){return  new CoverageResource();}
    }

