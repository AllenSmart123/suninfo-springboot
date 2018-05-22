package com.suninfo.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.suninfo.model.CmdbAttribute;
 import com.suninfo.service.CmdbAttributeService;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 【描述】：
 */ 
@Controller
@RequestMapping("/cmdbAttribute") 
public class CmdbAttributeController {
	
	private static Logger log = LoggerFactory.getLogger(CmdbAttributeController.class);
	@Autowired(required=false) 
	private CmdbAttributeService cmdbAttributeService; 
	
	
	
	/**
	 * 
	 * @param page
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<CmdbAttribute>  list(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return cmdbAttributeService.getAll();
	}
	
	

}
