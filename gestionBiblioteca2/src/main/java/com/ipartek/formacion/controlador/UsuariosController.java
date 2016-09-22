package com.ipartek.formacion.controlador;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistencia.Usuario;
import com.ipartek.formacion.service.UsuarioServiceImp;


@Controller
@RequestMapping(value="/usuarios")
public class UsuariosController {
	private static final Logger logger = LoggerFactory.getLogger(UsuariosController.class);
	@Autowired
	private UsuarioServiceImp us=null;
	private ModelAndView mav=null;
	@Autowired
	@Qualifier("usuarioValidator")//extension del autowired para que busque el id del bean
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAll(){
		mav=new ModelAndView("/usuarios/listado_rest");
		List<Usuario>usuarios=us.getAll();
		mav.addObject("listado_usuarios",usuarios);
		return mav;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id){
		mav=new ModelAndView("usuarios/usuario");
		Usuario usuario=us.getById(id);
		mav.addObject("usuario",usuario);
		return mav;
	}
	
	@RequestMapping(value="/addUsuario", method=RequestMethod.GET)//el methodrequest no hace falta ponerlo, en este caso
	//con el nombre del value es suficiente
	public String addUsuario(Model model){
		model.addAttribute("usuario",new Usuario());
		return "usuarios/usuario";
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.POST, RequestMethod.DELETE})
	public ModelAndView delete(@PathVariable("id") int id){
		mav=new ModelAndView("usuarios/listado_rest");
		us.delete(id);
		return mav;
	}
	
	//@Valid
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUsuario(@ModelAttribute("usuario") @Validated(Usuario.class) Usuario usuario, BindingResult bindingResult){//en el modelAtt, el mismo nombre que 
		//en el commandname del form
		String destino="";
		if(bindingResult.hasErrors()){
			logger.info("El usuario tiene errores");
			destino="usuarios/usuario";
		}else{
			logger.info("usuario correcto");
			destino="redirect:/usuarios";
			
			if(usuario.getIdUsuario()>0){
				us.update(usuario);
			}else{
				us.create(usuario);
			}
		}
		
		return destino;
	}
	
	private Usuario parseUsuario(HttpServletRequest req){
		Usuario usuario=new Usuario();
		int idUsuario=Integer.parseInt(req.getParameter("codigo"));
		String nombre=req.getParameter("nombre");
		String apellidos=req.getParameter("apellidos");
		//Date fechaNaci=req.getParameter("fechaNaci");
		String email=req.getParameter("email");
		String contrasena=req.getParameter("contrasena");
		int idEjemplar=Integer.parseInt(req.getParameter("idEjemplar"));
		
		usuario.setIdUsuario(idUsuario);
		usuario.setNombre(nombre);
		usuario.setApellidos(apellidos);
		usuario.setEmail(email);
		usuario.setContrasena(contrasena);
		usuario.getEjemplar().setIdEjemplar(idEjemplar);
		return usuario;
	}
	
	@RequestMapping(value="/restclients", method=RequestMethod.GET)
	public String sendToRestGetAll(){
		return "/usuarios/listado_rest";
	}
}
