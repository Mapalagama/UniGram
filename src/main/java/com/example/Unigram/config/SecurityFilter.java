package com.example.Unigram.config;


import com.example.Unigram.Models.User;
import com.example.Unigram.Services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class SecurityFilter extends BasicAuthenticationFilter {

    UserService userService;
    public SecurityFilter(AuthenticationManager authenticationManager, UserService userService) {
        super(authenticationManager);
        this.userService = userService;

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("security filter");
        String auth = request.getHeader("auth");
        System.out.println(auth);
        if (auth!=null) {
            Optional<User> userByEmail = userService.getUserByEmail(auth);


        if (userByEmail.isPresent()){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ANOTHER");
            List<SimpleGrantedAuthority> updatedAuthorities = new ArrayList<SimpleGrantedAuthority>();
            updatedAuthorities.add(authority);

            Authentication authentication = new UsernamePasswordAuthenticationToken(userByEmail.get(), null,updatedAuthorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }}


        chain.doFilter(request,response);
    }

}
