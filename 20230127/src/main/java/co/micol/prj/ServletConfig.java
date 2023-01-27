package co.micol.prj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//뷰 리졸브(view resolve)
@EnableWebMvc
@ComponentScan(basePackages = {"co.micol.prj"})		//컴포넌트를 스캔하는 패키지 경로. 여기서 읽어서 컨테이너에 태워달라 이말이야
public class ServletConfig implements WebMvcConfigurer {	
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}
}
