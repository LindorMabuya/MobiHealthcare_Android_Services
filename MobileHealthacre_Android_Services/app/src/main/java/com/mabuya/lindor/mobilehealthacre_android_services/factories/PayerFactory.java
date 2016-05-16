package com.mabuya.lindor.mobilehealthacre_android_services.factories;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Payer;

/**
 * Created by LILO on 2016/05/07.
 */
public interface PayerFactory {
    Payer createPayer(Long id, String accNum, String accType, String bankName);
}
