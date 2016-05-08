package com.mabuya.lindor.mobilehealthacre_android_services.restapi.resources;


import java.util.List;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class ServiceResource {
    private List<String> policy;

    public ServiceResource() {
    }
    public ServiceResource(Builder builder){
        policy = builder.policy;
    }


    public List<String> getPolicy() {
        return policy;
    }

    public void checkCoverage(com.mabuya.lindor.mobilehealthacre_android_services.domain.Coverage coverage){
        if(coverage.isCovered()){
            System.out.print("ServiceFactory: Valid claim. Currently processing claim for approval...");
        }
    }
    public static class Builder{
        private List<String> policy;

        public Builder policy(List<String> value){
            this.policy = value;
            return this;
        }
        public Builder copy(ServiceResource value){
            this.policy = value.getPolicy();
            return this;
        }
        public ServiceResource build(){return new ServiceResource(this);}
    }
}
