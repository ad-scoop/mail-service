package com.adscoop.mailservice.services;

import com.adscoop.mailservice.entites.UserNode;
import com.google.inject.Inject;

import org.neo4j.ogm.session.Session;

import java.util.Collections;
import java.util.Optional;

/**
 * Created by thokle on 09/02/2017.
 */
public class UserServiceImpl  implements  UserService{

    Session session;

    @Inject
    public UserServiceImpl(Session session) {
        this.session = session;
    }

    @Override
    public Optional<UserNode> findUserByEmailAndToken(String email, String token) {
        return Optional.ofNullable(session.queryForObject(UserNode.class,"match (u) where u.email='"+email+"' and u.token='"+token+"' return u", Collections.EMPTY_MAP));
    }

    @Override
    public void saveAndUpdate(UserNode userNode) {
            session.save(userNode);
    }
}
