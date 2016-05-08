package com.mabuya.lindor.mobilehealthacre_android_services.domain;


import java.util.List;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class Service {
    private Long id;
    private List<String> policy;

    public Service() {
    }
    public Service(Builder builder){
        id = builder.id;
        policy = builder.policy;
    }

    public Long getId() {
        return id;
    }

    public List<String> getPolicy() {
        return policy;
    }

    public void checkCoverage(Coverage coverage){
        if(coverage.isCovered()){
            System.out.print("ServiceFactory: Valid claim. Currently processing claim for approval...");
        }
    }
    public static class Builder{
        private Long id;
        private List<String> policy;

        public Builder id(long value){
            this.id = value;
            return this;
        }
        public Builder policy(List<String> value){
            this.policy = value;
            return this;
        }
        public Builder copy(Service value){
            this.id = value.getId();
            this.policy = value.getPolicy();
            return this;
        }
        public Service build(){return new Service(this);}
    }
}
