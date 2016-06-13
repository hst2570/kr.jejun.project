package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;
import java.nio.charset.Charset;

/**
 * Created by User on 2016-06-05.
 */
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/static/**")) {
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        }
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        //결과 출력시 강제로 utf-8로 설정
        return new StringHttpMessageConverter(Charset.forName("utf8"));
    }

    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("utf8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
}

/*
    * 기능
    1. 회원가입
     - 프로필은 수정 가능해야 한다.
    2. 글
     - 메인은 모든 글을 보여준다.
     - 개인 저장기능
     - 자신의 글은 삭제 가능
    3. 추천, 반대
     - 한 사람은 하나의 추천이나 반대 액션을 할 수 있다.

    * 데이터베이스
     - user, comment, action(?)
     1. user
     - ID, password, name, des, image
     2. comment
     - id, user, date, content
     3. action
     - id, comment, type, user
 */