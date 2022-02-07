/* © Copyright JFancy 2022 www.jfancy.de */
package de.jfancy.swaggertest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * TODO Marcus Beschreibung der Klasse
 *
 * @author Marcus
 * @author JFancy
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Require login to access internal pages and configure login form.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Not using Spring CSRF here to be able to use plain HTML for the login page
        http.csrf().disable()
                // vaadin interal requests
                .authorizeRequests().requestMatchers(VaadinSecurityUtils::isFrameworkInternalRequest).permitAll()
                // allow swagger
                .antMatchers("/swagger-ui/**", "/swagger-ui.html", "/swagger-resources/**").permitAll();
    }
}