package com.works.services;

import com.works.entities.Role;
import com.works.entities.User;
import com.works.repositories.UserRepository;
import com.works.utils.JwtUtil;
import com.works.utils.REnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import com.works.props.JWTLogin;

@Service
@Transactional
public class UserDetailService implements UserDetailsService {

    final UserRepository userRepository;
    final JwtUtil jwtUtil;
    final AuthenticationManager authenticationManager;
    final PasswordEncoder encoder;
    public UserDetailService(UserRepository userRepository, JwtUtil jwtUtil, @Lazy AuthenticationManager authenticationManager, @Lazy PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalJWTUser = userRepository.findByEmailEqualsIgnoreCase(username);
        if (optionalJWTUser.isPresent()) {
            User u = optionalJWTUser.get();
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                    u.getEmail(),
                    u.getPassword(),
                    u.isEnabled(),
                    u.isTokenExpired(),
                    true,
                    true,
                    roles(u.getRoles())
            );
            return userDetails;
        }else {
            throw new UsernameNotFoundException("Böyle bir kullanıcı yok");
        }
    }

    public Collection roles(List<Role> rolex ) {
        List<GrantedAuthority> ls = new ArrayList<>();
        for ( Role role : rolex ) {
            ls.add( new SimpleGrantedAuthority( role.getName() ));
        }
        return ls;
    }

    public ResponseEntity register(User user) {
        Optional<User> optionalJWTUser = userRepository.findByEmailEqualsIgnoreCase(user.getEmail());
        Map<REnum, Object> hm = new LinkedHashMap();
        if ( !optionalJWTUser.isPresent() ) {
            user.setPassword(  encoder.encode( user.getPassword() )  );
            User userx = userRepository.save(user);
            hm.put(REnum.status, true);
            hm.put(REnum.result, userx);
            return new ResponseEntity( hm , HttpStatus.OK);
        }else {
            hm.put(REnum.status, false);
            hm.put(REnum.message, "Bu mail daha kayıt edilmiş");
            hm.put(REnum.result, user);
            return new ResponseEntity( hm, HttpStatus.NOT_ACCEPTABLE );
        }
    }

    // aut
    // jwt almak için login işlemi yaparak bu fonksiyon tetiklenmeldir.
    public ResponseEntity auth(JWTLogin jwtLogin) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        try {
            authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
                    jwtLogin.getUsername(), jwtLogin.getPassword()
            ) );
            UserDetails userDetails = loadUserByUsername(jwtLogin.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);
            hm.put(REnum.status, true);
            hm.put( REnum.jwt, jwt );
            return new ResponseEntity(hm, HttpStatus.OK);
        }catch (Exception ex) {
            hm.put(REnum.status, false);
            hm.put( REnum.error, ex.getMessage() );
            return new ResponseEntity(hm, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}