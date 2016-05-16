package com.mabuya.lindor.mobilehealthacre_android_services.factories;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Service;

import java.util.List;

/**
 * Created by LILO on 2016/05/07.
 */
public interface ServiceFactory {
    Service createService(Long id, List<String> policy);
}
