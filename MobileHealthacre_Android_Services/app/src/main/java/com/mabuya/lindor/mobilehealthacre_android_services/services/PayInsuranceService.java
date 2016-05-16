package com.mabuya.lindor.mobilehealthacre_android_services.services;

/**
 * Created by LILO on 2016/05/14.
 */
public interface PayInsuranceService {

    String logIn(Long id, String accNum, String accType, String bankName);

    boolean insurancePaid();
    boolean insuranceNotPaid();
}
