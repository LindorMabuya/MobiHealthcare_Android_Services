package com.mabuya.lindor.mobilehealthacre_android_services.factories;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.DemographicInfo;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl.DemographicInfoFactoryImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by LILO on 2016/04/07.
 */
public class DemographicInfoFactoryTest
{
    private DemographicInfoFactory demographicInfoFactory;

    @Before
    public void setUpDemographicInfo() throws Exception {
        demographicInfoFactory = DemographicInfoFactoryImpl.getInstance();
    }

    @Test
    public void testDemographicInfo() throws Exception {
        DemographicInfo demo = demographicInfoFactory.createDemographicInfo(123456789L,21,"Female","Single","Doctor",10000.00);
        Assert.assertEquals(demo.getAge(),21);
    }

    @Test
    public void testUpdateDemographicInfo() throws Exception {
        DemographicInfo demo = demographicInfoFactory.createDemographicInfo(123456789L,21,"Female","Single","Doctor",10000.00);
        DemographicInfo updateDemo = new DemographicInfo.Builder().copy(demo).age(22).build();
        Assert.assertEquals(updateDemo.getAge(),22);

    }
}
