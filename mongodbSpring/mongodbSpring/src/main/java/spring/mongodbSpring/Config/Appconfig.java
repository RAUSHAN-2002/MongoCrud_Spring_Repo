package spring.mongodbSpring.Config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class Appconfig{

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}