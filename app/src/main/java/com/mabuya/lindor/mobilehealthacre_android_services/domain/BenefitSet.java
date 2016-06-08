package com.mabuya.lindor.mobilehealthacre_android_services.domain;

import java.io.Serializable;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class BenefitSet implements Serializable{
    private Long id;
    private String insuranceCoverage;
    private String benefit;
    private double benefitCost;

    public BenefitSet() {
    }
    public BenefitSet(Builder builder){
        id = builder.id;
        insuranceCoverage = builder.insuranceCoverage;
        benefit = builder.benefit;
        benefitCost = builder.benefitCost;
    }

    public Long getId() {
        return id;
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
        private Long id;
        private String insuranceCoverage;
        private String benefit;
        private double benefitCost;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
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
        public Builder copy(BenefitSet value){
            this.id = value.getId();
            this.insuranceCoverage = value.getInsuranceCoverage();
            this.benefit = value.getBenefit();
            this.benefitCost = value.getBenefitCost();
            return this;
        }
        public BenefitSet build(){return new BenefitSet(this);}

    }

}
