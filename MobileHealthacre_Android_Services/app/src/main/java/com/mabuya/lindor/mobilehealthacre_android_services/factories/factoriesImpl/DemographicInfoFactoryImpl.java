package com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl;


import com.mabuya.lindor.mobilehealthacre_android_services.domain.DemographicInfo;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.DemographicInfoFactory;

/**
 * Created by LILO on 2016/04/07.
 */
public class DemographicInfoFactoryImpl implements DemographicInfoFactory
{
    private static DemographicInfoFactoryImpl demographicInfoFactory = null;

    private DemographicInfoFactoryImpl(){}

    public static  DemographicInfoFactoryImpl getInstance()
    {
        if(demographicInfoFactory == null)
            demographicInfoFactory = new DemographicInfoFactoryImpl();
        return demographicInfoFactory;
    }

    @Override
    public DemographicInfo createDemographicInfo(Long id, int age, String sex, String maritalStatus, String occupation, double salary) {
            DemographicInfo demographicInfo = new DemographicInfo.Builder().id(id).age(age).sex(sex)
                    .maritalStatus(maritalStatus).occupation(occupation)
                    .salary(salary).build();
            return demographicInfo;
        }
}
