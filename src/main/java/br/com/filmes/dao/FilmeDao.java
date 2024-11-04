package br.com.filmes.dao;

import br.com.filmes.factory.ConnectionFactory;
import br.com.filmes.model.Filme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeDao {

    // CRUD

    public static void save(Filme filme) {
        String sql = "INSERT INTO filmes (nomeFilme, genero, duracao, dataCadastro) values (?, ?, ?, ?)";

        try(Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setString(1, filme.getNomeFilme());
            ps.setString(2, filme.getGenero());
            ps.setInt(3, filme.getDuracao());
            ps.setDate(4, new Date(filme.getDataCadastro().getTime()));

            ps.execute();
            System.out.println("salvo com sucesso");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("erro ao cadastrar");
            throw new RuntimeException(e);
        }
    }

    public static List<Filme> getFilmes() {
        List<Filme> filmes = new ArrayList<>();

        String sql = "SELECT * FROM filmes";

        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet resultSet = ps.executeQuery()) {

            while (resultSet.next()) {
                Filme filme = new Filme();
                filme.setId(resultSet.getInt("id"));
                filme.setNomeFilme(resultSet.getString("nomeFilme"));
                filme.setGenero(resultSet.getString("genero"));
                filme.setDuracao(resultSet.getInt("duracao"));
                filme.setDataCadastro(resultSet.getDate("dataCadastro"));

                filmes.add(filme);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("erro na listagem");
            throw new RuntimeException(e);
        }
        

        return filmes;
    }

    public static void update (Filme filme) {

        String sql = "UPDATE filmes SET nomeFilme = ?, genero = ?, duracao = ?, dataCadastro = ? WHERE id = ?";

        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, filme.getNomeFilme());
            ps.setString(2, filme.getGenero());
            ps.setInt(3, filme.getDuracao());
            ps.setDate(4, new Date(filme.getDataCadastro().getTime()));
            ps.setInt(5, filme.getId());

            ps.executeUpdate();
            System.out.println("atualizado com sucesso");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("erro ao atualizar");
            throw new RuntimeException(e);
        }

    }

    public static void delete (int id) {
        String sql = "DELETE FROM filmes WHERE id = ?";

        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.execute();
            System.out.println("deletado com sucesso");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("erro ao deletar");
            throw new RuntimeException(e);
        }


    }


}
