package com.mabuya.lindor.mobilehealthacre_android_services.restapi.resources;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Insured;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class DependentResource extends Insured {
    private String relationToSubscriber;

    public DependentResource(Builder builder) {
        super(builder);
    }

    public DependentResource(Builder builder, String relationToSubscriber) {
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
