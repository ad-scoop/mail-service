package com.adscoop.mailservice.handlers;

import com.adscoop.mailservice.entites.UserNode;
import com.adscoop.mailservice.services.UserService;
import com.google.inject.Inject;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.Optional;

/**
 * Created by thokle on 08/02/2017.
 */
public class ActivateUserHandler  implements Handler{
    UserService userService;


    @Inject
    public ActivateUserHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        String token = ctx.getPathTokens().get("token");
        String email = ctx.getPathTokens().get("email");

        if(!email.isEmpty()&&!token.isEmpty()) {
            Optional<UserNode> userNode = userService.findUserByEmailAndToken(email, token);

        if(userNode.isPresent()){
          UserNode  node =   userNode.get();
           node.setActivated(true);
           userService.saveAndUpdate(node);

        }
        }

    }
}
