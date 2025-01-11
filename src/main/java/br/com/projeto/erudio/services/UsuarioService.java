package br.com.projeto.erudio.services;

import br.com.projeto.erudio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

//@Component
@Service
public class UsuarioService implements UserDetailsService {

    private Logger logger = Logger.getLogger(UsuarioService.class.getName());

    //@Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;


    public UsuarioService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        logger.info("Finding by Username..." + userName);
        var usuarioName = this.userRepository.findByUserName(userName);
        if (usuarioName != null) {
            return usuarioName;
        } else {
            throw new UsernameNotFoundException("USUARIO NAO IDENTIFICADO: " + userName);
        }
    }
}