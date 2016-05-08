package com.mabuya.lindor.mobilehealthacre_android_services.restapi.resources;


import java.io.Serializable;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class PlanResource implements Serializable{

    private String riskCover;
    private double fixedIncomeReturn;
    private double tax;

    private PlanResource(){}

    public PlanResource(Builder builder) {
        riskCover = builder.riskCover;
        fixedIncomeReturn = builder.fixedIncomeReturn;
        tax = builder.tax;
    }

    public String getRiskCover() {
        return riskCover;
    }

    public double getFixedIncomeReturn() {
        return fixedIncomeReturn;
    }

    public double getTax() {
        return tax;
    }

    public void checkDeduction(com.mabuya.lindor.mobilehealthacre_android_services.domain.Deductible deductible){
        if(deductible.isDeductible()){
            System.out.print("PlanResource: Valid claim. Currently processing claim for approval...");
        }
    }
    public static class Builder{
        private String riskCover;
        private double fixedIncomeReturn;
        private double tax;

        public Builder riskCover(String value){
            this.riskCover = value;
            return this;
        }
        public Builder fixedIncomeReturn(double value){
            this.fixedIncomeReturn = value;
            return this;
        }
        public Builder tax(double value){
            this.tax = value;
            return this;
        }
        public Builder copy(PlanResource value){
            this.riskCover = value.getRiskCover();
            this.fixedIncomeReturn = value.getFixedIncomeReturn();
            this.tax = value.getTax();
            return this;
        }
        public PlanResource build(){return new PlanResource(this);}
    }
}
