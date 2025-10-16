package com.pedro.catalogo.servlet;

import com.pedro.catalogo.model.Item;
import com.pedro.catalogo.dao.ItemDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/items")
public class ItemServlet extends HttpServlet {

    private ItemDAO itemDAO;

    @Override
    public void init() throws ServletException {
        itemDAO = new ItemDAO(); // Inicializa o DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new":
                request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
                break;
            case "list":
            default:
                List<Item> itens = itemDAO.listar();
                request.setAttribute("itens", itens);
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");

        Item item = new Item();
        item.setNome(nome);
        item.setDescricao(descricao);

        itemDAO.salvar(item);

        response.sendRedirect("items?action=list");
    }
}
