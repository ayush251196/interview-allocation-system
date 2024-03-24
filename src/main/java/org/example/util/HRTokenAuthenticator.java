package org.example.util;

public class HRTokenAuthenticator implements Authenticator {
    @Override
    public boolean isValidToken(String token) {
        return "HR".equals(token);
    }
}
