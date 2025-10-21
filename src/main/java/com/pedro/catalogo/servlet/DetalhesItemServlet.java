package com.pedro.catalogo.servlet;

import com.pedro.catalogo.dao.ItemMidiaDAO;
import com.pedro.catalogo.model.ItemMidia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/detalhes")
public class DetalhesItemServlet extends HttpServlet {
    private ItemMidiaDAO itemDAO = new ItemMidiaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            ItemMidia item = itemDAO.buscarPorId(id);
            request.setAttribute("item", item);
            request.getRequestDispatcher("/WEB-INF/detalhes.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/itensMidia");
        }
    }
}
