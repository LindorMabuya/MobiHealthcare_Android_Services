package com.mabuya.lindor.mobilehealthacre_android_services.restapi.resources;


import java.io.Serializable;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class PayerResource implements Serializable{

    private String accNum;
    private String accType;
    private String bankName;

    public PayerResource(){
    }

    public PayerResource(Builder builder){
        accNum = builder.accNum;
        accType = builder.accType;
        bankName = builder.bankName;
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
        private String accNum;
        private String accType;
        private String bankName;

        public Builder id(Long value){
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
        public Builder copy(PayerResource value){
            this.accNum = value.getAccNum();
            this.accType = value.getAccType();
            this.bankName = value.getBankName();
            return this;
        }
        public PayerResource build() {return new PayerResource(this);}
    }
}
