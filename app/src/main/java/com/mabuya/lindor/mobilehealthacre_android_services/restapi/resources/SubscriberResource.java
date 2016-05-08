package com.mabuya.lindor.mobilehealthacre_android_services.restapi.resources;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Dependent;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class SubscriberResource extends com.mabuya.lindor.mobilehealthacre_android_services.domain.Insured {
    private com.mabuya.lindor.mobilehealthacre_android_services.domain.Dependent dependent;

    public SubscriberResource(Builder builder) {
        super(builder);
    }

    public SubscriberResource(Builder builder, Dependent dependent) {
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
