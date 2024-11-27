package com.mcann.dumenflix.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@Slf4j
public class DumenFlixSecurityConfig {
	
	@Bean
	public JwtTokenFilter getJwtTokenFilter(){
		return new JwtTokenFilter();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		/**
		 * Spring filter chain ile tüm isteklerin üzerinden geçtiği noktaya kontrol sağlamakta
		 * biz de bu methodu kullanarak ilgili otomatik ayarları manipüle ededceğiz.
		 * Burada tüm istekler kontrol edilerek yetkilendirme, oturum açma gibi istekler yönetilir.
		 *
		 * 1-> public, herkese açık erişim kısıtlamasız alanlar yaratmak için, permitAll()
		 * NOT : genişletilmiş adresleme için /** ilgili path altında gidilebilecek tüm adresleri işaretler.
		 * 2-> authenticated, belli alanlara erişim için oturum açmış olmak yeterli.
		 * 3-> daha kısıtlı ve kullanıcıya özel alanlara erişim için hasAuthority("ADMIN")
		 */
		http.authorizeHttpRequests(req->
			req.requestMatchers(
							"/swagger-ui/**","/v3/api-docs/**",
							"/v1/dev/user/register","/v1/dev/user/do-login","/v1/dev/**"
					) // eşleşecek end-point'lerin tam path'i ya da genişletilmiş şekli yazılır.
					.permitAll() // public olarak erişime izin ver
					.requestMatchers("/admin/**").hasRole("ADMIN") // admin rolune sahip olmak
					.anyRequest() // diğer tüm istekler
					.authenticated() // oturum açma zorunluluğu
		);
		
		/**
		 * _csrf nedir ?
		 * sunucu, istemci ile arasında olan iletişimi doğrulamak ve güvenli şekilde iletişimde
		 * kalmak için ilk istek ile oturum açıldığında istemciye bir csrfId gönderir ve bununla
		 * istekleri karşılar. Böylece belli end-point'lere gelen isteklerin güvenli kalmasını sağlar.
		 * RestAPI sisteminde csrf'in kapalı kalması sağlanır, güvenli iletişim için JWT gibi token sistemleri
		 * ile iletişimin güvenliği sağlanır.
		 */
		http.csrf(AbstractHttpConfigurer::disable);
	//	http.formLogin(AbstractAuthenticationFilterConfigurer::permitAll);
		
		http.addFilterBefore(getJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
}