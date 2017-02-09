package com.adscoop.mailservice.services;

import com.adscoop.mailservice.entites.UserNode;

import java.util.Optional;

/**
 * Created by thokle on 09/02/2017.
 */
public interface UserService {

    Optional<UserNode> findUserByEmailAndToken(String email,String token);

    void saveAndUpdate(UserNode userNode);
}
