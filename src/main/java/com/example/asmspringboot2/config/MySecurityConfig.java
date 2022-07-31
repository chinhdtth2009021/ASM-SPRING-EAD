package com.example.asmspringboot2.config;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class MySecurityConfig {
    final UserDetailsService accountService;
    final PasswordEncoder passwordEncoder;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
        MyAuthenticationFilter authenticationFilter = new MyAuthenticationFilter(authenticationManagerBean());
        authenticationFilter.setFilterProcessesUrl("/api/v1/users/login");
        http.authorizeHttpRequests().antMatchers("/api/v1/users/register").permitAll();
        http
                .addFilterBefore(new MyAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests().antMatchers("/api/v1/admin/*")
//                .permitAll()
                .hasAnyAuthority("ADMIN");
        http.addFilter(authenticationFilter);
//        http.addFilterBefore(new MyAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
