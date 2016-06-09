package com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl;


import com.mabuya.lindor.mobilehealthacre_android_services.domain.Coverage;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.CoverageFactory;

/**
 * Created by LILO on 2016/04/08.
 */
public class CoverageFactoryImpl implements CoverageFactory {
    private static CoverageFactoryImpl coverageFactory = null;

    public CoverageFactoryImpl() {
    }

    public static  CoverageFactoryImpl getInstance()
    {
        if(coverageFactory == null)
            coverageFactory = new CoverageFactoryImpl();
        return coverageFactory;
    }

    @Override
    public Coverage createCoverage(long id) {
        Coverage coverage = new Coverage.Builder().id(id).build();
        return coverage;
    }
}
