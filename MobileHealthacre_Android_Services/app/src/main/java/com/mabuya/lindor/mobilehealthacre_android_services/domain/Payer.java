package com.mabuya.lindor.mobilehealthacre_android_services.domain;


import java.io.Serializable;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class Payer implements Serializable{

    private Long id;
    private String accNum;
    private String accType;
    private String bankName;

    public Payer(){
    }

    public Payer(Builder builder){
        id = builder.id;
        accNum = builder.accNum;
        accType = builder.accType;
        bankName = builder.bankName;
    }

    public Long getId() {
        return id;
    }

    public String getAccNum() {
        return accNum;
    }

    public String getAccType() {
        return accType;
    }

    public String getBankName() {
        return bankName;
    }
    public static class Builder{
        private Long id;
        private String accNum;
        private String accType;
        private String bankName;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder accNum(String value) {
            this.accNum = value;
            return this;
        }
        public Builder accType(String value){
            this.accType = value;
            return this;
        }
        public Builder bankname(String value){
            this.bankName = value;
            return this;
        }
        public Builder copy(Payer value){
            this.id = value.getId();
            this.accNum = value.getAccNum();
            this.accType = value.getAccType();
            this.bankName = value.getBankName();
            return this;
        }
        public Payer build() {return new Payer(this);}
    }
}
