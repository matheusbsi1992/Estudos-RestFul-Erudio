package br.com.projeto.erudio.execucao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@Configuration
//@ComponentScan(basePackages = {"br.com.projeto.erudio.services"})
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@SpringBootApplication(scanBasePackages = {"br.*"})
@SpringBootApplication
@ComponentScan(basePackages = {"br.*"})
@EntityScan(basePackages = {"br.*"})
@EnableJpaRepositories(basePackages = {"br.*"})
public class ErudioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErudioApplication.class, args);

      /*  SecurityConfig securityConfig = new SecurityConfig();

        var passwordCrypt = securityConfig.passwordEncryptEncoder("admin1234").split("\\{pbkdf2}");
        System.out.println("Senha encriptada:" + passwordCrypt[1]);*/

    }

}
