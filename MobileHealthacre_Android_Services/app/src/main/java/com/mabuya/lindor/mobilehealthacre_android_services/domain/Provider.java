package com.mabuya.lindor.mobilehealthacre_android_services.domain;


import java.io.Serializable;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class Provider implements Serializable{
    private Long id;
    private String providerName;
    private double chargePerMonth;

    private Provider(){

    }
    public Provider(Builder builder) {
        id = builder.id;
        providerName = builder.providerName;
        chargePerMonth = builder.chargePerMonth;
    }

    public Long getId() {
        return id;
    }

    public String getProviderName() {
        return providerName;
    }

    public double getChargePerMonth() {
        return chargePerMonth;
    }

    public class Builder{
        private Long id;
        private String providerName;
        private double chargePerMonth;


        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder providerName(String value){
            this.providerName = value;
            return this;
        }
        public Builder chargePerMonth(double value){
            this.chargePerMonth = value;
            return this;
        }
        public Builder copy(Provider value){
            this.id = value.getId();
            this.providerName = value.getProviderName();
            this.chargePerMonth = value.getChargePerMonth();
            return this;
        }
        public Provider build(){return new Provider(this);}
    }

}
