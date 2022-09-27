package ua.com.owu.springboot_demos.security;

import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import ua.com.owu.springboot_demos.dao.ClientDAO;
import ua.com.owu.springboot_demos.models.Client;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@AllArgsConstructor
public class OncePerRequestCustomFilter extends OncePerRequestFilter {
    private ClientDAO clientDAO;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeaderBearerPayload = request.getHeader("Authorization");
        if (authorizationHeaderBearerPayload.startsWith("Bearer ")) {
            String token = authorizationHeaderBearerPayload.replace("Bearer ", "");

            String decodedTokenPayload = Jwts.parser()
                    .setSigningKey("okten".getBytes())
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

            Client client = clientDAO.findByUsername(decodedTokenPayload);
            if (client != null) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        client.getUsername(),
                        client.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
                );
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }


        }


        filterChain.doFilter(request, response);
    }


}
