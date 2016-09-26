package com.ipartek.formacion.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Libro;
import com.ipartek.formacion.dao.persistencia.Usuario;
import com.ipartek.formacion.service.EjemplarServiceImp;

@Controller
@RequestMapping(value = "/ejemplares")
public class EjemplaresController {
	private static final Logger logger = LoggerFactory.getLogger(EjemplaresController.class);
	@Autowired
	private EjemplarServiceImp es = null;
	private ModelAndView mav = null;
	/*
	 * @Autowired
	 * 
	 * @Qualifier("ejemplarValidator") // extension del autowired para que
	 * busque // el id del bean private Validator validator;
	 * 
	 * @InitBinder private void initBinder(WebDataBinder binder) {
	 * binder.setValidator(validator); }
	 */

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("/ejemplares/listado");
		List<Libro> ejemplares = es.getAll();
		mav.addObject("listado_ejemplares", ejemplares);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("ejemplares/ejemplar");
		Ejemplar ejemplar = es.getEjemplar(id);
		mav.addObject("ejemplar", ejemplar);
		return mav;
	}

	@RequestMapping(value = "/addEjemplar", method = RequestMethod.GET) // el
																		// methodrequest
																		// no
																		// hace
																		// falta
																		// ponerlo,
																		// en
																		// este
																		// caso
	// con el nombre del value es suficiente
	public String addEjemplar(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("ejemplar", new Ejemplar(usuario));
		return "ejemplares/ejemplar";
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.POST, RequestMethod.DELETE })
	public ModelAndView delete(@PathVariable("id") int id) {
		mav = new ModelAndView("ejemplares/listado");
		es.eliminar(id);
		return mav;
	}

	// @Valid
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEjemplar(@ModelAttribute("ejemplar") @Validated(Ejemplar.class) Ejemplar ejemplar,
			BindingResult bindingResult) {// en el modelAtt, el mismo nombre que
		// en el commandname del form
		String destino = "";
		if (bindingResult.hasErrors()) {
			logger.info("El ejemplar tiene errores");
			destino = "ejemplares/ejemplar";
		} else {
			logger.info("ejemplar correcto");
			destino = "redirect:/ejemplares";

			if (ejemplar.getIdEjemplar() > 0) {
				es.update(ejemplar);
			} else {
				// es.create(ejemplar);
			}
		}

		return destino;
	}

	/*
	 * private Usuario parseUsuario(HttpServletRequest req){ Usuario usuario=new
	 * Usuario(); int idUsuario=Integer.parseInt(req.getParameter("codigo"));
	 * String nombre=req.getParameter("nombre"); String
	 * apellidos=req.getParameter("apellidos"); //Date
	 * fechaNaci=req.getParameter("fechaNaci"); String
	 * email=req.getParameter("email"); String
	 * contrasena=req.getParameter("contrasena"); int
	 * idEjemplar=Integer.parseInt(req.getParameter("idEjemplar"));
	 * 
	 * usuario.setIdUsuario(idUsuario); usuario.setNombre(nombre);
	 * usuario.setApellidos(apellidos); usuario.setEmail(email);
	 * usuario.setContrasena(contrasena);
	 * usuario.getEjemplar().setIdEjemplar(idEjemplar); return usuario; }
	 */

	@RequestMapping(value = "/restclients", method = RequestMethod.GET)
	public String sendToRestGetAll() {
		return "/ejemplares/listado_rest";
	}
}
