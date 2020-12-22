package com.study.security.auth;

import com.study.security.auth.service.CustomOAuth2UserService;
import com.study.security.auth.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor //초기화 되지 않은 Final,@Notnull필드에 생성자 생성 -> autowired없이 사용가능
@EnableWebSecurity //active webSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()//login url을 가진
                .antMatchers("/").hasRole(Role.USER.name()) //권한 관리대상을 지정
                .anyRequest().authenticated() //나머지 url들은 모두 인증된 사용 ? -> 로그인된 사용자
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}
