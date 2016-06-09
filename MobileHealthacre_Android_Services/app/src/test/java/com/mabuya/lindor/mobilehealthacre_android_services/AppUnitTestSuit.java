package com.mabuya.lindor.mobilehealthacre_android_services;

/**
 * Created by 213036223 on 4/17/2016.
 */

import com.mabuya.lindor.mobilehealthacre_android_services.factories.AddressFactoryTest;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.BenefitSetFactoryTest;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.CoverageFactoryTest;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.DeductibleFactoryTest;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.DemographicInfoFactoryTest;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.InsuredFactoryTest;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.PayerFactoryTest;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.PlanFactoryTest;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.ServiceFactoryTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//Runs all unit tests.
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddressFactoryTest.class,
        BenefitSetFactoryTest.class,
        CoverageFactoryTest.class,
        DeductibleFactoryTest.class,
        DemographicInfoFactoryTest.class,
        InsuredFactoryTest.class,
        PayerFactoryTest.class,
        PlanFactoryTest.class,
        ServiceFactoryTest.class})

public class AppUnitTestSuit {}
