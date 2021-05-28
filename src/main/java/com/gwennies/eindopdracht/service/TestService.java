package com.gwennies.eindopdracht.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String generatePublicContent() {
        return "login: Successful 'user' login";
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String generateUserContent() {
        return "login: Successful 'user' login";
    }    

    @PreAuthorize("hasRole('MODERATOR')")
    public String generateModContent() {
        return "login: Successful 'moderator' login";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String generateAdminContent() {
        return "login: Successful 'admin' login";
    }
}
