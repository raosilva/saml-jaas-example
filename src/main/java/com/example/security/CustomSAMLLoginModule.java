package com.example.security;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.util.Map;

/**
 * Example of a custom LoginModule for processing after SAML authentication.
 * This is optional and can be used for auditing or additional attribute validation.
 */
public class CustomSAMLLoginModule implements LoginModule {

    private Subject subject;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Map<String, ?> sharedState, Map<String, ?> options) {
        this.subject = subject;
        System.out.println("CustomSAMLLoginModule: Initialized");
    }

    @Override
    public boolean login() throws LoginException {
        System.out.println("CustomSAMLLoginModule: Login successful");
        return true;
    }

    @Override
    public boolean commit() throws LoginException {
        System.out.println("CustomSAMLLoginModule: Commit");
        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        System.out.println("CustomSAMLLoginModule: Abort");
        return true;
    }

    @Override
    public boolean logout() throws LoginException {
        System.out.println("CustomSAMLLoginModule: Logout");
        return true;
    }
}