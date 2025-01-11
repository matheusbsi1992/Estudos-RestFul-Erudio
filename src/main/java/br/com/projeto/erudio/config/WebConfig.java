package br.com.projeto.erudio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static br.com.projeto.erudio.util.MediaType.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //private static final MediaType MEDIA_TYPE_YAML = MediaType.valueOf("application/x-yaml");

    @Value("${cors.originPattners:default}")
    private String corOriginPattners = "";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        var allowOrigins = corOriginPattners.split(",");

        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedOrigins(allowOrigins)
                .allowedMethods("*")
                .maxAge(3600)
                .allowCredentials(true);

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        //via QUERY PARAM. http://localhost:8080/api/pessoa/v1/?mediaType=xml
        /*configurer.favorParameter(true)
                .parameterName("mediaType")
                .ignoreAcceptHeader(true)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json",MediaType.APPLICATION_JSON)
                .mediaType("xml",MediaType.APPLICATION_XML);
        */


        configurer.favorParameter(false)
                //.parameterName("mediaType")
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.valueOf(//APPLICATION_JSON
                        MEDIA_TYPE_JSON))
                .mediaType("json", MediaType.valueOf(//APPLICATION_JSON
                        MEDIA_TYPE_JSON))
                .mediaType("xml", MediaType.valueOf(//APPLICATION_XML//
                        MEDIA_TYPE_XML))
                .mediaType("x-yaml", MediaType.valueOf(MEDIA_TYPE_YAML));
    }

}