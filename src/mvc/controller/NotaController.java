package mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mvc.model.Nota;
import mvc.model.NotaDAO;

@Controller
public class NotaController {
	@RequestMapping("/cnotas")
	public String registro() {
		return "formulario-nota";
	}

	@RequestMapping(value = "efetuaCriacaoNota", method = RequestMethod.POST)
	public ModelAndView upload(Nota nota, HttpSession session) throws IOException, ParseException {
		NotaDAO dao = new NotaDAO();
		dao.adiciona(nota,(String)session.getAttribute("usuarioLogado"));
		return visualiza(session);
		
	}
	@RequestMapping(value = "vnotas", method = RequestMethod.GET)
	public ModelAndView visualiza(HttpSession session) throws IOException, ParseException {
		NotaDAO dao = new NotaDAO();
		List<Nota> notas = dao.getNotas((String)session.getAttribute("usuarioLogado"));
		ModelAndView modelAndView = new ModelAndView("visualiza-nota");
		modelAndView.addObject("notas", notas);

		return modelAndView;
	}
	@RequestMapping(value = "dnota", method = RequestMethod.GET)
	public ModelAndView notasAfterDelete(HttpSession session, Nota nota) throws IOException, ParseException, SQLException {
		NotaDAO dao = new NotaDAO();
		List<Nota> notas = dao.deleteNota(nota.getId(), (String)session.getAttribute("usuarioLogado"));
		
		ModelAndView modelAndView = new ModelAndView("visualiza-nota");
		modelAndView.addObject("notas", notas);

		return modelAndView;
	}
	@RequestMapping(value = "goEnota", method = RequestMethod.GET)
	public ModelAndView redirectEditaNota(HttpSession session, Nota nota) throws IOException, ParseException, SQLException {
		NotaDAO dao = new NotaDAO();
		Nota notaE = dao.getNota(nota.getId());
		
		ModelAndView modelAndView = new ModelAndView("formulario-edicao-nota");
		modelAndView.addObject("nota", notaE);

		return modelAndView;
	}
	
	@RequestMapping(value = "enota", method = RequestMethod.POST)
	public String editaNota(HttpSession session, Nota nota) throws IOException, ParseException, SQLException {
		NotaDAO dao = new NotaDAO();
		boolean ok = dao.editaNota(nota);
		
		if(ok) {
			return "menu";
		}else {
			return "loginForm";
		}
	}
	
	@RequestMapping(value = "snotas", method = RequestMethod.GET)
	public ModelAndView p(HttpSession session, Nota nota) throws IOException, ParseException {
		NotaDAO dao = new NotaDAO();
		List<Nota> notas = dao.getNotasFiltro((String)session.getAttribute("usuarioLogado"), nota);
		ModelAndView modelAndView = new ModelAndView("visualiza-nota");
		modelAndView.addObject("notas", notas);

		return modelAndView;
	}
}

