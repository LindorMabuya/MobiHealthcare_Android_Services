package com.mabuya.lindor.mobilehealthacre_android_services.factories;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.BenefitSet;

/**
 * Created by LILO on 2016/05/07.
 */
public interface BenefitSetFactory {
    BenefitSet createBenefitSet(Long id, String insuranceCoverage, String benefit, double benefitCost);
}
