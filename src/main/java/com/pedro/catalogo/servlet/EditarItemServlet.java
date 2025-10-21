package com.pedro.catalogo.servlet;

import com.pedro.catalogo.dao.ItemMidiaDAO;
import com.pedro.catalogo.model.ItemMidia;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editar")
public class EditarItemServlet extends HttpServlet {

    private final ItemMidiaDAO dao = new ItemMidiaDAO();

    // Exibe o formulário de edição
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ItemMidia item = dao.buscarPorId(id);
        request.setAttribute("item", item);
        request.getRequestDispatcher("/WEB-INF/editar.jsp").forward(request, response);
    }

    // Atualiza o item no banco
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autorDiretor = request.getParameter("autorDiretor");
        int anoLancamento = Integer.parseInt(request.getParameter("anoLancamento"));
        String genero = request.getParameter("genero");
        String tipoMidia = request.getParameter("tipoMidia");
        String sinopse = request.getParameter("sinopse");
        int avaliacao = Integer.parseInt(request.getParameter("avaliacao"));

        ItemMidia item = new ItemMidia(titulo, autorDiretor, anoLancamento, genero, tipoMidia, sinopse, avaliacao);
        item.setId(id);
        dao.atualizar(item);

        response.sendRedirect(request.getContextPath() + "/itensMidia");
    }
}
