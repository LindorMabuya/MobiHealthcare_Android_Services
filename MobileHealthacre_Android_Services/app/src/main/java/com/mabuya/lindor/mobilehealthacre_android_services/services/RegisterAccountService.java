package com.mabuya.lindor.mobilehealthacre_android_services.services;

/**
 * Created by LILO on 2016/05/11.
 */
public interface RegisterAccountService {

    String activateAccount(String email, String password);

    boolean isAccountActivated();

    boolean deactivateAccount();
}
