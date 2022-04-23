package ua.com.owu.springboot_demos.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.com.owu.springboot_demos.dao.CustomerDAO;
import ua.com.owu.springboot_demos.dao.services.CustomerService;
import ua.com.owu.springboot_demos.models.entity.Customer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private CustomerDAO customerDAO;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            Customer customer = customerDAO.findCustomerByLogin(username);
            List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
            authorityList.add(new SimpleGrantedAuthority(customer.getRole()));
            return new User(customer.getLogin(), customer.getPassword(), authorityList);
        });
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http = http.csrf().disable();

        http = http.cors().disable();

        http = http.authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, "/", "/open").permitAll()
                .antMatchers(HttpMethod.POST, "/save").permitAll()
                .antMatchers(HttpMethod.GET, "/secure").hasAnyRole("ADMIN", "USER")
                .and();

        http = http.httpBasic().and();

        http = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();


    }


}
