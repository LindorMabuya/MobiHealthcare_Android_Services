
package com.mabuya.lindor.mobilehealthacre_android_services.restapi.resources;



import java.io.Serializable;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class InsuredResource implements Serializable{
    private String coveredByInsurance;
    private String organization;

    private InsuredResource(){}

    public InsuredResource(Builder builder) {
        coveredByInsurance = builder.coveredByInsurance;
        organization = builder.organization;
    }

    public String getCoveredByInsurance() {
        return coveredByInsurance;
    }

    public String getOrganization() {
        return organization;
    }

    public static class Builder{
        private String coveredByInsurance;
        private String organization;

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
        public Builder copy(InsuredResource value)
        {
            this.coveredByInsurance = value.getCoveredByInsurance();
            this.organization = value.getOrganization();
            return this;
        }
        public InsuredResource build(){return new InsuredResource(this);}

    }

}
