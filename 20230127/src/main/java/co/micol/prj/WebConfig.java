package co.micol.prj;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	// 기존의 root-context.xml역할
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};		//우리가 만든 RootConfig클래스를 읽어라. 
	}

	// 기존의 servlet-context.xml역할
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

	// 기존에 Controller 안에 있던 매핑 주소
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};					//매퍼가 새로운 문자열로 들어오면(?)
	}

}
