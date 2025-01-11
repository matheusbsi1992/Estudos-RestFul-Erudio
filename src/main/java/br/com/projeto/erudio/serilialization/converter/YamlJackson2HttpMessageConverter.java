package br.com.projeto.erudio.serilialization.converter;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import static br.com.projeto.erudio.util.MediaType.MEDIA_TYPE_YAML;

@Component
public class YamlJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {

    protected YamlJackson2HttpMessageConverter() {
        super(new YAMLMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)
                , MediaType.parseMediaType(MEDIA_TYPE_YAML));
    }
}
