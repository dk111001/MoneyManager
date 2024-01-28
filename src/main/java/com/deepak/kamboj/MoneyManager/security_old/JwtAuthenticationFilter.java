package com.deepak.kamboj.MoneyManager.security_old;

import com.deepak.kamboj.MoneyManager.exception.CustomException;
import com.deepak.kamboj.MoneyManager.model.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter  {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException, ExpiredJwtException, MalformedJwtException {
        final String authHeader =request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        if (authHeader==null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        try {
            jwt = authHeader.substring(7);
            userEmail = jwtService.extractUsername(jwt);  //extract user Email from JWT token
            if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
                if (jwtService.isTokenValid(jwt, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );

                    authToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                    );
                    SecurityContextHolder.getContext().setAuthentication(authToken);

                }
            }
        }
        catch (CustomException ex) {;
            SecurityContextHolder.clearContext();
            ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(), ex.getMessage());
            response.setContentType("application/json");
            response.setStatus(ex.getHttpStatus().value());

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(errorResponse);
            // Jackson ObjectMapper
            PrintWriter out = response.getWriter();
            out.print(jsonString);
            out.flush();
            return;
        }

        filterChain.doFilter(request,response);
    }

    private static void handleTokenExpiredException(MalformedJwtException e) {
        // Handle the case when the token has expired
        System.out.println("Token has expired: " + e.getMessage());
    }
}
