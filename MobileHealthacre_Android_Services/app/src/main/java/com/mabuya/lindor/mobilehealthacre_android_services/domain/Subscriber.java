package com.mabuya.lindor.mobilehealthacre_android_services.domain;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class Subscriber extends Insured{
    private Dependent dependent;

    public Subscriber(Builder builder) {
        super(builder);
    }

    public Subscriber(Builder builder, Dependent dependent) {
        super(builder);
        this.dependent = dependent;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getOrganization() {
        return super.getOrganization();
    }

    @Override
    public String getCoveredByInsurance() {
        return super.getCoveredByInsurance();
    }
}
