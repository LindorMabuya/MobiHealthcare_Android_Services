package com.mabuya.lindor.mobilehealthacre_android_services.domain;

import java.io.Serializable;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class Coverage implements Serializable {
    private Long id;

    public Coverage() {
    }
    public Coverage(Builder builder){
        id = builder.id;
    }

    public Long getId() {
        return id;
    }

    public boolean isCovered(){
        System.out.print("CoverageResource: Validating health insurance claim.....\n");
        return true;

    }

    public static class Builder{
        private Long id;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder copy(Coverage value)
        {
            this.id = value.getId();
            return this;
        }
        public Coverage build(){return  new Coverage();}
    }

}
