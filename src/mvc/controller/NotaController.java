package mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mvc.model.Nota;
import mvc.model.NotaDAO;

@Controller
public class NotaController {
	@RequestMapping("/cnotas")
	public String registro() {
		return "formulario-nota";
	}

	@RequestMapping(value = "efetuaCriacaoNota", method = RequestMethod.POST)
	public String upload(Nota nota) throws IOException {
		NotaDAO dao = new NotaDAO();
		dao.adiciona(nota);
		return "menu";
		
	}
}
