package com.mabuya.lindor.mobilehealthacre_android_services.restapi.resources;

import java.io.Serializable;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class BenefitSetResource implements Serializable{
    private String insuranceCoverage;
    private String benefit;
    private double benefitCost;

    public BenefitSetResource() {
    }
    public BenefitSetResource(Builder builder){
        insuranceCoverage = builder.insuranceCoverage;
        benefit = builder.benefit;
        benefitCost = builder.benefitCost;
    }


    public String getInsuranceCoverage() {
        return insuranceCoverage;
    }

    public String getBenefit() {
        return benefit;
    }

    public double getBenefitCost() {
        return benefitCost;
    }
    public static class Builder{
        private String insuranceCoverage;
        private String benefit;
        private double benefitCost;

        public Builder insuranceCoverage(String value){
            this.insuranceCoverage = value;
            return this;
        }
        public Builder benefit(String value){
            this.benefit = value;
            return this;
        }
        public Builder benefitCost(double value){
            this.benefitCost = value;
            return this;
        }
        public Builder copy(BenefitSetResource value){
            this.insuranceCoverage = value.getInsuranceCoverage();
            this.benefit = value.getBenefit();
            this.benefitCost = value.getBenefitCost();
            return this;
        }
        public BenefitSetResource build(){return new BenefitSetResource(this);}

    }

}
