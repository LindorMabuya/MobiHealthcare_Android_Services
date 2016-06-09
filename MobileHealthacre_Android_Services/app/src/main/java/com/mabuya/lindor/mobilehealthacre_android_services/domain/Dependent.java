package com.mabuya.lindor.mobilehealthacre_android_services.domain;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class Dependent extends Insured{
    private String relationToSubscriber;

    public Dependent(Builder builder) {
        super(builder);
    }

    public Dependent(Builder builder, String relationToSubscriber) {
        super(builder);
        this.relationToSubscriber = relationToSubscriber;
    }

    public String getRelationToSubscriber() {
        return relationToSubscriber;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getCoveredByInsurance() {
        return super.getCoveredByInsurance();
    }

    @Override
    public String getOrganization() {
        return super.getOrganization();
    }
}
