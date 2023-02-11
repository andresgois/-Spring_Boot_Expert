package io.gtihub.andresgois.config;

import io.gtihub.andresgois.security.jwt.JwtAuthFilter;
import io.gtihub.andresgois.security.jwt.JwtService;
import io.gtihub.andresgois.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private JwtService jwtService;

    @Bean   //implementando o método para interceptar as requisições
    public OncePerRequestFilter jwtFilter(){
        return new JwtAuthFilter(jwtService, usuarioService);
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*@Override // Método para autenticação
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);

        // configuração em memória
        //auth
                //.inMemoryAuthentication()
                //.passwordEncoder(passwordEncoder())
                //.withUser("fulano")
                //.password(passwordEncoder().encode("123"))
                //.roles("USER");
        auth
                .userDetailsService(usuarioService)
                .passwordEncoder(passwordEncoder());
    }*/

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
        /*http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/api/clientes/**")
                        .hasAnyRole("ADMIN","USER")
                    .antMatchers("/api/pedidos/**")
                        .hasAnyRole("ADMIN","USER")
                    .antMatchers("/api/produtos/**")
                        .hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST,"/api/usuarios/**")
                        .permitAll()
                    .anyRequest().authenticated()
                .and()
                    .sessionManagement()// cada sessão terá todos os elementos necessários para ela acontecer
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // toda autenticação deve ter o token
                //.httpBasic();
                .and()
                    .addFilterBefore( jwtFilter(), UsernamePasswordAuthenticationFilter.class); // chama nosso filtro
        */

        // Versão 5
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/clientes/**")
                    .hasAnyRole("ADMIN","USER")
                .antMatchers("/api/pedidos/**")
                    .hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.POST,"/api/usuarios/**")
                    .permitAll()
                .antMatchers(HttpMethod.POST,"/api/usuarios/auth/**")
                .permitAll()
                .antMatchers("/api/produtos/**")
                    .hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //.httpBasic();
                .and()
                .addFilterBefore( jwtFilter(), UsernamePasswordAuthenticationFilter.class);

        // o has role fala que tem que estar autenticado você também pode adicionar: .hasRole("USER")
        // nisso só seriam permitido pessoas que tivessem a role "USER" podendo
        // ser usado também .hasAuthority("MANTER USUARIO")
        // também existe o permitAll() que não precisa estar autenticado

        //cria um formulário de login do spring security ou você pode criar
        // o seu proprio formulário de login e colocar uma caminho para ele
        // passando o path dentro do parâmetro em uma pasta que esteja dentro
        // de resources > static ou templates ficaria algo como ("/meu-login.html")
        // esse formulário deve ser submetido apenas com o método POST tendo dois
        // campos de inputs por ex "user e password" com atributo names

                        /*
                            <form method="post">
                                <input type="text" name="username">
                                <input type="secret" name="password">
                                <button type="submit"....
                            </form>
                        */
        // .formLogin();
        //Para utilizar via insominia
    }
}
