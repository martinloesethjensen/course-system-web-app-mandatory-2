package dk.kea.mandatory2;

import dk.kea.mandatory2.model.Session;
import dk.kea.mandatory2.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    SessionRepository sessionRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/student/").access("hasAnyAuthority('ROLE_STUDENT')")
                .antMatchers("/admin/").access("hasAnyAuthority('ROLE_ADMIN')")
                .antMatchers("/teacher/").access("hasAnyAuthority('ROLE_TEACHER')")
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

                        for(GrantedAuthority grantedAuthority: authorities) {
                            if (grantedAuthority.getAuthority().equals("ROLE_STUDENT")) {
                                httpServletResponse.sendRedirect("/student/");
                            } else if (grantedAuthority.getAuthority().equals("ROLE_TEACHER")) {
                                httpServletResponse.sendRedirect("/teacher/");
                            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                                httpServletResponse.sendRedirect("/admin/");
                            }
                        }
                    }
                })
                .permitAll()
                .and()
                .logout()
                .permitAll();

                //Redirect til /login?logout
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        List<Session> _tempUsers = sessionRepository.findAll();

        UserDetails[] users = new UserDetails[_tempUsers.size()];

        int i = 0;

        for(Session session: _tempUsers) {
            users[i] = User.withDefaultPasswordEncoder()
                    .username(session.getUsername())
                    .password(session.getPassword())
                    .authorities(session.getRole())
                    .roles(session.getRole())
                    .build();
            i++;
        }

        return new InMemoryUserDetailsManager(users);
    }
}
