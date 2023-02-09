package io.gtihub.andresgois.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override // Método para autenticação
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);

        // configuração em memória
        auth
                .inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("fulano")
                .password(passwordEncoder().encode("123"))
                .roles("USER");
    }

    @Override  // Método para autorização
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        // versão 2
        /*http.csrf().disable()// para aplicação web
                .authorizeRequests()
                    .antMatchers("/api/clientes/**")// quem pode acessar o quê
                        .authenticated() //.roles("USER") //.hasAuthority("MANTER_USUARIO")
                //.permitAll()
                .and()
                .formLogin();*/

        // Versão 3 - via página de login
        /*http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/api/clientes/**").hasAnyRole("ADMIN","USER")
                    .antMatchers("/api/pedidos/**").hasAnyRole("ADMIN","USER")
                    .antMatchers("/api/produtos/**").hasRole("ADMIN")
                .and().formLogin();*/

        // Versão 4 - Basic
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/clientes/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/api/pedidos/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/api/produtos/**").hasRole("ADMIN")
                .and().httpBasic();
    }
}
