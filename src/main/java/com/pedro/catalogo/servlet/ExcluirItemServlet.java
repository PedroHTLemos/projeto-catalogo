package com.pedro.catalogo.servlet;

import com.pedro.catalogo.dao.ItemMidiaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/excluir")
public class ExcluirItemServlet extends HttpServlet {
    private ItemMidiaDAO itemDAO = new ItemMidiaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        itemDAO.excluir(id);
        response.sendRedirect(request.getContextPath() + "/itensMidia");
    }
}
