package br.edu.ifsp.books.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.edu.ifsp.books.dao.LivroDAO;
import br.edu.ifsp.books.model.Livro;

@WebServlet("/criar-livro")
public class CreateLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		String titulo = req.getParameter("titulo"); 
		String autor = req.getParameter("autor"); 
		String[] generos = req.getParameterValues("genero"); 
		int anoPublicacao = Integer.parseInt(req.getParameter("anoPublicacao")); 
		
		ArrayList<String> listaGeneros = new ArrayList<>();
		if (generos != null) {
			listaGeneros.addAll(Arrays.asList(generos));
		}

		Livro livro = new Livro(titulo, autor, listaGeneros, anoPublicacao);

		LivroDAO.getInstance().adicionarLivro(livro);

		req.getSession().setAttribute("mensagem", "Livro cadastrado com sucesso!");
		resp.sendRedirect("listar-livros");
	}
}
