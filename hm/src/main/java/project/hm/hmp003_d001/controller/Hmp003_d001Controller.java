package project.hm.hmp003_d001.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

public interface Hmp003_d001Controller {
	public ModelAndView searchList(String p_prod_id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	//public ModelAndView searchMod(String p_prod_id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView searchInit(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//public ModelAndView searchInsert(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//public ResponseEntity updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//public ResponseEntity insertProduct(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
