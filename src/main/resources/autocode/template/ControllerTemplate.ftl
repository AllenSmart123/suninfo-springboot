package ${bussPackage}.controller#if($!controllerEntityPackage).${controllerEntityPackage}#end;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ${bussPackage}.model#if($!entityPackage).${entityPackage}#end.${className};
 import ${bussPackage}.service#if($!entityPackage).${entityPackage}#end.${className}Service;
/**
 * 【描述】：
 */ 
@Controller
@RequestMapping("/${lowerName}") 
public class ${className}Controller {
	
	private static Logger log = LoggerFactory.getLogger(${className}Controller.class);
	@Autowired(required=false) 
	private ${className}Service ${lowerName}Service; 
	
	
	
	/**
	 * 
	 * @param page
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") 
	public void  list(HttpServletRequest request, HttpServletResponse response) throws Exception{
	   
	}
	
	

}
