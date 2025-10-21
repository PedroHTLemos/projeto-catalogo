package com.pedro.catalogo.servlet;

import com.pedro.catalogo.dao.ItemMidiaDAO;
import com.pedro.catalogo.model.ItemMidia;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastrar")
public class CadastrarItemServlet extends HttpServlet {

    private final ItemMidiaDAO dao = new ItemMidiaDAO();

    // Exibe o formulário de cadastro
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/cadastrar.jsp").forward(request, response);
    }

    // Recebe dados do formulário e salva no banco
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String autorDiretor = request.getParameter("autorDiretor");
        int anoLancamento = Integer.parseInt(request.getParameter("anoLancamento"));
        String genero = request.getParameter("genero");
        String tipoMidia = request.getParameter("tipoMidia");
        String sinopse = request.getParameter("sinopse");
        int avaliacao = Integer.parseInt(request.getParameter("avaliacao"));

        ItemMidia item = new ItemMidia(titulo, autorDiretor, anoLancamento, genero, tipoMidia, sinopse, avaliacao);
        dao.salvar(item);

        response.sendRedirect(request.getContextPath() + "/itensMidia");
    }
}
