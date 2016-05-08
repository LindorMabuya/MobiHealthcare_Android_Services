package com.mabuya.lindor.mobilehealthacre_android_services.restapi.resources;


import java.io.Serializable;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class ProviderResource implements Serializable{
    private String providerName;
    private double chargePerMonth;

    private ProviderResource(){

    }
    public ProviderResource(Builder builder) {
        providerName = builder.providerName;
        chargePerMonth = builder.chargePerMonth;
    }

    public String getProviderName() {
        return providerName;
    }

    public double getChargePerMonth() {
        return chargePerMonth;
    }

    public class Builder{
        private String providerName;
        private double chargePerMonth;

        public Builder providerName(String value){
            this.providerName = value;
            return this;
        }
        public Builder chargePerMonth(double value){
            this.chargePerMonth = value;
            return this;
        }
        public Builder copy(ProviderResource value){
            this.providerName = value.getProviderName();
            this.chargePerMonth = value.getChargePerMonth();
            return this;
        }
        public ProviderResource build(){return new ProviderResource(this);}
    }

}
