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

import com.ipartek.formacion.dao.persistencia.Libro;
import com.ipartek.formacion.service.LibroServiceImp;

@Controller
@RequestMapping(value = "/libros")
public class LibrosController {
	private static final Logger logger = LoggerFactory.getLogger(LibrosController.class);
	@Autowired
	private LibroServiceImp us = null;
	private ModelAndView mav = null;
	/*
	 * @Autowired
	 * 
	 * @Qualifier("libroValidator") // extension del autowired para que busque
	 * el // id del bean private Validator validator;
	 * 
	 * @InitBinder private void initBinder(WebDataBinder binder) {
	 * binder.setValidator(validator); }
	 */

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("/libros/listado");
		List<Libro> libros = us.getAll();
		mav.addObject("listado_libros", libros);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("libros/libro");
		Libro libro = us.getById(id);
		mav.addObject("libro", libro);
		return mav;
	}

	@RequestMapping(value = "/addLibro", method = RequestMethod.GET) // el
																		// methodrequest
																		// no
																		// hace
																		// falta
																		// ponerlo,
																		// en
																		// este
																		// caso
	// con el nombre del value es suficiente
	public String addLibro(Model model) {
		model.addAttribute("libro", new Libro());
		return "libros/libro";
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.POST, RequestMethod.DELETE })
	public ModelAndView delete(@PathVariable("id") int id) {
		mav = new ModelAndView("libros/listado");
		us.delete(id);
		return mav;
	}

	// @Valid
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveLibro(@ModelAttribute("libro") @Validated(Libro.class) Libro libro, BindingResult bindingResult) {// en
																														// el
																														// modelAtt,
																														// el
																														// mismo
																														// nombre
																														// que
		// en el commandname del form
		String destino = "";
		if (bindingResult.hasErrors()) {
			logger.info("El libro tiene errores");
			destino = "libros/libro";
		} else {
			logger.info("libro correcto");
			destino = "redirect:/libros";

			if (libro.getIdLibro() > 0) {
				us.update(libro);
			} else {
				us.create(libro);
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
		return "/libros/listado_rest";
	}
}
