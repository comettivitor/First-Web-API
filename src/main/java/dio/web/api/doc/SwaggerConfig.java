package dio.web.api.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Contact contato(){
        return new Contact(
                "Vitor",
                "http://www.seusite.com.br",
                "email@email.com"
        );
    }

    private ApiInfoBuilder infoApi(){
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Titulo - REST API");
        apiInfoBuilder.description("Exemplo de uso de Springboot RESTAPI");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        apiInfoBuilder.license("Licensa - Empresa X");
        apiInfoBuilder.licenseUrl("http//:www.site.com.br");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;
    }

    @Bean
    public Docket detalheApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("Pacote.comseus.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.infoApi().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }
}
