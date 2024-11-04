package br.com.filmes.servlet;

import br.com.filmes.dao.FilmeDao;
import br.com.filmes.model.Filme;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/filme/*")
public class FilmeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Filme> filmes = FilmeDao.getFilmes();
//        System.out.println("Filmes recuperados: " + filmes);
        request.setAttribute("filmes", filmes);
//        System.out.println("Filmes passados para a JSP: " + filmes);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        response.setContentType("text/html");
    }

    protected void excluirFilme(HttpServletRequest request) {
        int id = Integer.parseInt((request.getParameter("id")));
        FilmeDao.delete(id);
    }

    protected void editarFilme(HttpServletRequest request) {
        Filme filme = new Filme();

        if (filme != null) {
            filme.setId(Integer.parseInt(request.getParameter("id")));
            filme.setNomeFilme(request.getParameter("nomeFilme"));
            filme.setGenero(request.getParameter("genero"));
            filme.setDuracao(Integer.parseInt(request.getParameter("duracao")));
            filme.setDataCadastro(new Date());
            filme.setId(Integer.parseInt(request.getParameter("id")));

            FilmeDao.update(filme);
        }

    }

    protected void cadastrarFilme(HttpServletRequest request) {
        Filme filme = new Filme();

        filme.setNomeFilme(request.getParameter("nomeFilme"));
        filme.setGenero(request.getParameter("genero"));
        filme.setDuracao(Integer.parseInt(request.getParameter("duracao")));
        filme.setDataCadastro(new Date());

        FilmeDao.save(filme);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action"); // nome no form

        if (action == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        switch (action) {
            case "cadastrar":
                cadastrarFilme(request);
                break;
            case "editar":
                editarFilme(request);
                break;
            case "excluir":
                excluirFilme(request);
                break;
            default:
                response.sendRedirect("index.jsp");
                break;
        }

        response.sendRedirect("filme");
    }

}
