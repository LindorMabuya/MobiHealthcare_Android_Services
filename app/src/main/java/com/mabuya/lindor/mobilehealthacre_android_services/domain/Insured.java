
package com.mabuya.lindor.mobilehealthacre_android_services.domain;



import java.io.Serializable;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class Insured implements Serializable{
    private Long id;
    private String coveredByInsurance;
    private String organization;

    private Insured(){}

    public Insured(Builder builder) {
        id = builder.id;
        coveredByInsurance = builder.coveredByInsurance;
        organization = builder.organization;
    }

    public Long getId() {
        return id;
    }

    public String getCoveredByInsurance() {
        return coveredByInsurance;
    }

    public String getOrganization() {
        return organization;
    }

    public static class Builder{
        private Long id;
        private String coveredByInsurance;
        private String organization;

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }
        public Builder coveredByInsurance(String value)
        {
            this.coveredByInsurance = value;
            return this;
        }
        public Builder organization(String value)
        {
            this.organization = value;
            return this;
        }
        public Builder copy(Insured value)
        {
            this.id = value.getId();
            this.coveredByInsurance = value.getCoveredByInsurance();
            this.organization = value.getOrganization();
            return this;
        }
        public Insured build(){return new Insured(this);}

    }

}
