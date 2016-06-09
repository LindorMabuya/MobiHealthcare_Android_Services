package com.mabuya.lindor.mobilehealthacre_android_services.factories;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Dependent;
import com.mabuya.lindor.mobilehealthacre_android_services.domain.Subscriber;

/**
 * Created by 213036223 on 4/17/2016.
 */
public interface SubcriberFactory {
    Subscriber createSubscriber(Dependent dependent);
}
