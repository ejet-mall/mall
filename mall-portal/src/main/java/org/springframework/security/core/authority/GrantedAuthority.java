package org.springframework.security.core.authority;

import java.io.Serializable;

public interface GrantedAuthority extends Serializable {
    String getAuthority();
}
