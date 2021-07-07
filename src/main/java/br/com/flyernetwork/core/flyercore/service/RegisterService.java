package br.com.flyernetwork.core.flyercore.service;

import java.util.Map;

import br.com.flyernetwork.core.flyercore.domain.User;

public interface RegisterService {
    public User registerNewUser(Map<String, String> userData);
}
