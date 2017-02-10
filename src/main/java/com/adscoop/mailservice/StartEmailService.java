package com.adscoop.mailservice;

import com.adscoop.mailservice.config.BinderConfig;
import com.adscoop.mailservice.modules.MailConfig;
import com.adscoop.mailservice.handlers.SendEmailHandler;
import com.adscoop.mailservice.modules.Config;
import com.adscoop.mailservice.modules.EmailModule;
import com.adscoop.mailservice.modules.ServiceCommonConfigModule;
import ratpack.guice.Guice;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;

/**
 * Created by thokle on 08/02/2017.
 */
public class StartEmailService {


    public static void main(String...args) throws Exception{
        RatpackServer.start(ratpackServerSpec -> ratpackServerSpec.serverConfig(serverConfigBuilder ->
                serverConfigBuilder.baseDir(BaseDir.find()).yaml("datasource.yaml").yaml("mail.yaml").require("/mail", MailConfig.class).require("/db", Config.class).props("server.properties").env().sysProps().build())
                .registry(Guice.registry( bindingsSpec -> bindingsSpec.module(BinderConfig.class).module(ServiceCommonConfigModule.class).module(EmailModule.class)))
                .handlers(chain -> chain.post("mail",SendEmailHandler.class)));
    }

}
