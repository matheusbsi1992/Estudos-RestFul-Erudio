package br.com.projeto.erudio.services;

import br.com.projeto.erudio.repository.UserRepository;
import br.com.projeto.erudio.seguranca.jwt.JwtTokenProvider;
import br.com.projeto.erudio.vo.seguranca.ContasCredencialVO;
import br.com.projeto.erudio.vo.seguranca.TokenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    private JwtTokenProvider jwtTokenProvider;

    private AuthenticationManager authenticationManager;

    private UserRepository userRepository;

    @Autowired
    public AuthService(JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> signin(ContasCredencialVO accountCredentialsVO) {
        try {
            var userName = accountCredentialsVO.getUserName();
            var passwordUser = accountCredentialsVO.getSenha();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, passwordUser));

            var user = userRepository.findByUserName(userName);

            var tokenResponse = new TokenVO();

            if (user != null) {
                tokenResponse = jwtTokenProvider.createAcessToken(userName, user.getRoles());
            } else {
                throw new UsernameNotFoundException("UserName" + userName + " not found!!");
            }

            return ResponseEntity.ok(tokenResponse);

        } catch (Exception exception) {
            throw new BadCredentialsException("Invalid Username/Password Supplied");
        }

    }

    public ResponseEntity<?> refreshToken(String userName, String refreshToken) {

        var user = userRepository.findByUserName(userName);

        var tokenResponse = new TokenVO();

        if (user != null) {
            tokenResponse = jwtTokenProvider.refreshToken(refreshToken);
        } else {
            throw new UsernameNotFoundException("UserName" + userName + " not found!!");
        }

        return ResponseEntity.ok(tokenResponse);

    }

}