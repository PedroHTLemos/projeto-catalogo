package com.pedro.catalogo.dao;

import com.pedro.catalogo.model.ItemMidia;
import com.pedro.catalogo.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemMidiaDAO {

    public List<ItemMidia> listarTodos() {
        List<ItemMidia> itens = new ArrayList<>();
        String sql = "SELECT * FROM itens_midia";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ItemMidia item = new ItemMidia(
                        rs.getString("titulo"),
                        rs.getString("autor_diretor"),
                        rs.getInt("ano_lancamento"),
                        rs.getString("genero"),
                        rs.getString("tipo_midia"),
                        rs.getString("sinopse"),
                        rs.getInt("avaliacao")
                );
                item.setId(rs.getInt("id"));
                itens.add(item);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar itens do banco", e);
        }

        return itens;
    }

    public List<ItemMidia> buscarPorTituloOuAutorEGenero(String busca, String genero) {
        List<ItemMidia> itens = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM itens_midia WHERE 1=1");

        if (busca != null && !busca.trim().isEmpty()) {
            sql.append(" AND (titulo LIKE ? OR autor_diretor LIKE ?)");
        }

        if (genero != null && !genero.trim().isEmpty()) {
            sql.append(" AND genero = ?");
        }

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql.toString())) {

            int index = 1;

            if (busca != null && !busca.trim().isEmpty()) {
                stmt.setString(index++, "%" + busca + "%");
                stmt.setString(index++, "%" + busca + "%");
            }

            if (genero != null && !genero.trim().isEmpty()) {
                stmt.setString(index++, genero);
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ItemMidia item = new ItemMidia(
                        rs.getString("titulo"),
                        rs.getString("autor_diretor"),
                        rs.getInt("ano_lancamento"),
                        rs.getString("genero"),
                        rs.getString("tipo_midia"),
                        rs.getString("sinopse"),
                        rs.getInt("avaliacao")
                );
                item.setId(rs.getInt("id"));
                itens.add(item);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar itens no banco", e);
        }

        return itens;
    }

    public ItemMidia buscarPorId(int id) {
        String sql = "SELECT * FROM itens_midia WHERE id = ?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ItemMidia item = new ItemMidia(
                        rs.getString("titulo"),
                        rs.getString("autor_diretor"),
                        rs.getInt("ano_lancamento"),
                        rs.getString("genero"),
                        rs.getString("tipo_midia"),
                        rs.getString("sinopse"),
                        rs.getInt("avaliacao")
                );
                item.setId(rs.getInt("id"));
                return item;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar item pelo ID", e);
        }
    }

    public void salvar(ItemMidia item) {
        String sql = "INSERT INTO itens_midia (titulo, autor_diretor, ano_lancamento, genero, tipo_midia, sinopse, avaliacao) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, item.getTitulo());
            stmt.setString(2, item.getAutorDiretor());
            stmt.setInt(3, item.getAnoLancamento());
            stmt.setString(4, item.getGenero());
            stmt.setString(5, item.getTipoMidia());
            stmt.setString(6, item.getSinopse());
            stmt.setInt(7, item.getAvaliacao());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar item no banco", e);
        }
    }

    public void atualizar(ItemMidia item) {
        String sql = "UPDATE itens_midia SET titulo = ?, autor_diretor = ?, ano_lancamento = ?, genero = ?, tipo_midia = ?, sinopse = ?, avaliacao = ? WHERE id = ?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, item.getTitulo());
            stmt.setString(2, item.getAutorDiretor());
            stmt.setInt(3, item.getAnoLancamento());
            stmt.setString(4, item.getGenero());
            stmt.setString(5, item.getTipoMidia());
            stmt.setString(6, item.getSinopse());
            stmt.setInt(7, item.getAvaliacao());
            stmt.setInt(8, item.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar item", e);
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM itens_midia WHERE id = ?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir item", e);
        }
    }
}
