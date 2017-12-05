package Lotterys;

import java.io.Serializable;

public class AuthResult implements Serializable {
    private boolean authentication;

    public AuthResult(boolean authentication) {
        this.authentication = authentication;
    }

    public boolean isAuthentication() {
        return authentication;
    }
}
