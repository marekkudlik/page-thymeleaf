package marek.poznan.pagethymeleaf.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Autowired
		@Qualifier("securityDataSource")
		private DataSource securityDataSource;
			
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {

			auth.jdbcAuthentication().dataSource(securityDataSource);
			
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.authorizeRequests()
				.antMatchers("/show/page").permitAll()
				.antMatchers("/show/opinions").permitAll()
				.antMatchers("/show/signUp").permitAll()
				.antMatchers("/show/saveStudent").permitAll()
				.antMatchers("/show/infoStudents").hasAnyRole("STUDENT", "ADMIN")		
				.antMatchers("/show/delete").hasRole("ADMIN")
				.antMatchers("/show/forUpdate").hasRole("ADMIN")
				.antMatchers("/show/update").hasRole("ADMIN")
				.and()
				.formLogin()
					.loginPage("/showLogin")
					.loginProcessingUrl("/authenticateTheUser")
					.permitAll()
				.and()
				.logout().permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/accessDenied");
			
		}
			
	}
