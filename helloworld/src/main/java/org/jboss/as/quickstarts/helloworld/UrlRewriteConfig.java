package org.jboss.as.quickstarts.helloworld;

import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

@RewriteConfiguration
public class UrlRewriteConfig extends HttpConfigurationProvider {

    @Override
    public Configuration getConfiguration(final ServletContext context) {
        // NB: inbound rules are processed in order, outbound rules in reverse order (as of Rewrite 3.0.0.Alpha1)
        return ConfigurationBuilder.begin()
                .addRule(Join.path("/hello/{path}").to("/HelloWorld"))
                ;
    }

    @Override
    public int priority() {
        return 0;
    }
}
