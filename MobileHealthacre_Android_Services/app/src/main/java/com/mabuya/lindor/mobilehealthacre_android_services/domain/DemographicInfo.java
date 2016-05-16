package com.mabuya.lindor.mobilehealthacre_android_services.domain;


import java.io.Serializable;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class DemographicInfo implements Serializable{
    private Long id;
    private int age;
    private String sex;
    private String maritalStatus;
    private String occupation;
    private double salary;


    private DemographicInfo() {
    }
    public DemographicInfo(Builder builder)
    {
        id = builder.id;
        age = builder.age;
        sex = builder.sex;
        maritalStatus = builder.maritalStatus;
        occupation = builder.occupation;
        salary = builder.salary;

    }

    public Long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public double getSalary() {
        return salary;
    }


    public static class Builder
    {
        private Long id;
        private int age;
        private String sex;
        private String maritalStatus;
        private String occupation;
        private double salary;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder age(int value)
        {
            this.age = value;
            return this;
        }

        public Builder sex(String value)
        {
            this.sex = value;
            return this;
        }

        public Builder maritalStatus(String value)
        {
            this.maritalStatus = value;
            return this;
        }

        public Builder occupation(String value)
        {
            this.occupation = value;
            return this;
        }

        public Builder salary(double value)
        {
            this.salary = value;
            return this;
        }


        public Builder copy(DemographicInfo value)
        {
            this.id = value.getId();
            this.age = value.getAge();
            this.sex = value.getSex();
            this.maritalStatus = value.getMaritalStatus();
            this.occupation = value.getOccupation();
            this.salary = value.getSalary();
            return this;
        }

        public DemographicInfo build(){return new DemographicInfo(this);}
    }

}
