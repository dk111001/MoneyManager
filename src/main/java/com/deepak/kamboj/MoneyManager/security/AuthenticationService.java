package com.deepak.kamboj.MoneyManager.security;

import com.deepak.kamboj.MoneyManager.model.MyUserDetails;
import com.deepak.kamboj.MoneyManager.model.User;
import com.deepak.kamboj.MoneyManager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
    public AuthResponse authenticate(AuthRequest request) throws Exception{
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );
        Optional<User> user = userRepository.findByUserName(request.getUserName());
        user.orElseThrow(() -> new UsernameNotFoundException("Not Found : " + request.getUserName()));
        var jwtToken = jwtService.generateToken(user.map(MyUserDetails::new).get());
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
