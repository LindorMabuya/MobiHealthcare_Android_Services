package com.mabuya.lindor.mobilehealthacre_android_services.factories;


import com.mabuya.lindor.mobilehealthacre_android_services.domain.DemographicInfo;

/**
 * Created by LILO on 2016/04/07.
 */
public interface DemographicInfoFactory
{
     DemographicInfo createDemographicInfo(Long id, int age, String sex, String maritalStatus,
                                           String occupation, double salary);
}
