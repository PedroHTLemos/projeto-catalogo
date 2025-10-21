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

@WebServlet("/itensMidia")
public class ItemServlet extends HttpServlet {
    private ItemMidiaDAO itemDAO = new ItemMidiaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String busca = request.getParameter("busca");
        String genero = request.getParameter("genero");

        if (busca == null) busca = "";
        if (genero == null) genero = "";

        List<ItemMidia> itens = itemDAO.buscarPorTituloOuAutorEGenero(busca, genero);

        request.setAttribute("itens", itens);
        request.getRequestDispatcher("/WEB-INF/listar.jsp").forward(request, response);
    }
}
