package com.ipartek.formacion.controlador;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Usuario;
import com.ipartek.formacion.service.UsuarioService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UsuarioService us=null;
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home(Locale locale) {
		ModelAndView mav=null;
		mav=new ModelAndView("home");
		logger.info("Carga la página web");
		List<Usuario>usuarios = us.getAll();
		mav.addObject("listado_usuarios",usuarios);
		return mav;
}
	
}
