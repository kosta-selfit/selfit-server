package com.oopsw.selfit.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();

		config.setAllowCredentials(true);

		// ❗ addAllowedOriginPattern("*") → 아래로 교체
		// '*' 와 credentials(true)는 함께 쓸 수 없음
		config.setAllowedOrigins(Arrays.asList("http://127.0.0.1:8880")); // 프론트 주소 명시

		config.addAllowedHeader("*");
		config.addAllowedMethod("*");

		// 클라이언트가 접근 가능한 응답 헤더 지정
		config.setExposedHeaders(Arrays.asList("Authorization", "selfitKosta"));

		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}
