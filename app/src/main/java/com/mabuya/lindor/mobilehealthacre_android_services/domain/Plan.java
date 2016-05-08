package com.mabuya.lindor.mobilehealthacre_android_services.domain;


import java.io.Serializable;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class Plan implements Serializable{

    private Long id;
    private String riskCover;
    private double fixedIncomeReturn;
    private double tax;

    private Plan(){}

    public Plan(Builder builder) {
        id = builder.id;
        riskCover = builder.riskCover;
        fixedIncomeReturn = builder.fixedIncomeReturn;
        tax = builder.tax;
    }

    public Long getId() {
        return id;
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

    public void checkDeduction(Deductible deductible){
        if(deductible.isDeductible()){
            System.out.print("PlanResource: Valid claim. Currently processing claim for approval...");
        }
    }
    public static class Builder{
        private Long id;
        private String riskCover;
        private double fixedIncomeReturn;
        private double tax;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
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
        public Builder copy(Plan value){
            this.id = value.getId();
            this.riskCover = value.getRiskCover();
            this.fixedIncomeReturn = value.getFixedIncomeReturn();
            this.tax = value.getTax();
            return this;
        }
        public Plan build(){return new Plan(this);}
    }
}
