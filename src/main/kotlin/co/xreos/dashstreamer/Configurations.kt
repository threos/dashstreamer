package co.xreos.dashstreamer

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter


@Configuration
@EnableScheduling
@ComponentScan
class Configurations {

    @Bean
    fun simpleCorsFilter(): FilterRegistrationBean<CorsFilter> {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = true
        config.allowedOriginPatterns = listOf("*")
        config.allowedMethods = listOf("*")
        config.allowedHeaders = listOf("*")
        source.registerCorsConfiguration("/**", config)
        val bean: FilterRegistrationBean<CorsFilter> = FilterRegistrationBean<CorsFilter>(CorsFilter(source))
        bean.order = Ordered.HIGHEST_PRECEDENCE
        return bean
    }
}