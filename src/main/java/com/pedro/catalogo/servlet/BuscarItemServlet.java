package com.pedro.catalogo.servlet;

import com.pedro.catalogo.dao.ItemMidiaDAO;
import com.pedro.catalogo.model.ItemMidia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/buscarItens")
public class BuscarItemServlet extends HttpServlet {
    private ItemMidiaDAO dao = new ItemMidiaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String busca = request.getParameter("busca");
        String genero = request.getParameter("genero");

        if (busca == null) busca = "";
        if (genero == null) genero = "";

        // Chama o método atualizado do DAO
        List<ItemMidia> itens = dao.buscarPorTituloOuAutorEGenero(busca, genero);

        request.setAttribute("itens", itens);
        request.getRequestDispatcher("/WEB-INF/listar.jsp").forward(request, response);
    }
}
