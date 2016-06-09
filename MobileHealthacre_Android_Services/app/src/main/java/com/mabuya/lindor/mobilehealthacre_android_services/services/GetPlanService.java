package com.mabuya.lindor.mobilehealthacre_android_services.services;

import android.content.Context;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Plan;

/**
 * Created by LILO on 2016/05/12.
 */
public interface GetPlanService {
    void getPlan(Context context, Plan plan);
}
