package com.mabuya.lindor.mobilehealthacre_android_services.factories;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Coverage;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl.CoverageFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by LILO on 2016/05/07.
 */
public class CoverageFactoryTest {
    private CoverageFactory coverageFactory;
    private Coverage coverage;

    @Before
    public void setUp() throws Exception {
        coverageFactory = CoverageFactoryImpl.getInstance();
    }

    @Test
    public void testCoverage() throws Exception {
        coverage = coverageFactory.createCoverage(12345678L);
        coverage.isCovered();
        Assert.assertEquals(coverage.isCovered(),coverage.isCovered());
    }

    @Test
    public void testCoverageUpdate() throws Exception {
        coverage = coverageFactory.createCoverage(12345678L);
        Coverage updateCoverage = new Coverage.Builder().copy(coverage).id(987654321L).build();
        Assert.assertEquals(updateCoverage.isCovered(), updateCoverage.isCovered());
    }
}
