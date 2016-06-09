package com.mabuya.lindor.mobilehealthacre_android_services.factories;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Insured;

/**
 * Created by 213036223 on 4/17/2016.
 */
public interface InsuredFactory {
    Insured createInsured(Long id, String coveredByInsurance, String organization);
}
