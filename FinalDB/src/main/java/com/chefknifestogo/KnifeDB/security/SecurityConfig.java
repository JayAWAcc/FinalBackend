package com.chefknifestogo.KnifeDB.security;

import com.chefknifestogo.KnifeDB.security.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsServiceImpl;
    @Autowired
    private AuthenticationEntryPointImpl authenticationEntryPointImpl;

    @Autowired
    private AccessDeniedHandlerImpl accessDeniedHandlerImpl;

    @Autowired
    private AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;

    @Autowired
    private AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;

    @Autowired
    private LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable();

        http.authorizeRequests((requests) -> requests

                .antMatchers(HttpMethod.POST, "/knives","/knives/*","/accessories","/knives/brand/*","/knives/knifetype/*",
                        "/knives/steel/*","/knives/supplier/*","/accessories/*").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/users","/orders").permitAll()
                        .antMatchers(HttpMethod.PUT,"/orders","/knives","/accessories").permitAll()
                        .antMatchers(HttpMethod.POST,"/knives/comment/*",
                                "/accessories/comment/*").hasAnyAuthority("ADMIN","USER")
                .antMatchers(HttpMethod.GET,"/orders/userId/*","/orders/*").hasAnyAuthority("ADMIN","USER")
               .antMatchers(HttpMethod.GET,"/knives","/knives/*","/accessories","/knives/brand/*","/knives/knifetype/*",
                        "/knives/steel/*","/knives/supplier/*","/accessories/*","/checklogin","/orders","/knives/comment/*",
                       "/accessories/comment/*","/knives/comment/average_rate/*","/accessories/comment/average_rate/*",
                       "/orders/hasPurchasedAccessory/*","/orders/hasPurchasedKnife/*"+
                       "/knives/comment/hasCommented/*","/accessories/comment/hasCommented/*",
                       "/users/getUsernameById/*","/users").permitAll()
/*                .antMatchers("/knives","/knives/*","/accessories","/knives/brand/*","/knives/knifetype/*",
                        "/knives/steel/*","/knives/supplier/*","/accessories/*","/checklogin","/orders").hasAuthority("USER")*/
                        .antMatchers("/user-details/*","/user-details").hasAnyAuthority("ADMIN","USER")
                .anyRequest().authenticated()




        );

        http.exceptionHandling()

               .accessDeniedHandler(accessDeniedHandlerImpl)

                .authenticationEntryPoint(authenticationEntryPointImpl);
        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
               .successHandler(authenticationSuccessHandlerImpl)
                .failureHandler(authenticationFailureHandlerImpl);
        http.logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutSuccessHandlerImpl);
        http.httpBasic();
    }
    @Bean // put the return object into spring container, as a bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder(11);
        }
    @Autowired // @Autowired on function will autowired the parameters
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder(11));
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOriginPattern("*");
/*        configuration.addAllowedOriginPattern("http://localhost:58442/");
        configuration.addAllowedOriginPattern("http://localhost:8080");
        configuration.addAllowedOriginPattern("http://localhost:4200");*/ // You should only set trusted site here. e.g. http://localhost:4200 means only this site can access.
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","HEAD","OPTIONS"));
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
