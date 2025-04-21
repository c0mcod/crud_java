package br.com.produtos.produto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import br.com.produtos.factory.ConnectionFactory;
import br.com.produtos.model.Produto;

public class ProdutoDAO {
	// Todas as operações do CRUD ficam aqui

	// criação do metodo de cadastro de produtos no banco de dados(CREATE)
	public void cadastrarProduto(Produto produto) {
		String sql = "INSERT INTO produtos VALUES (?, ?, ?)";

		// estabelecer uma conexão com o banco de dados
		Connection conn = null;
		// interface do JDBC usada para executar comandos SQL com parâmetros de forma
		// segura e eficiente.
		PreparedStatement pstm = null;

		try {
			// inicia a conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			// preparação para ler a query
			pstm = conn.prepareStatement(sql);

			// definição dos valores
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getPreco());
			pstm.setInt(3, produto.getQuantidade());

			// execução
			pstm.execute();
			System.out.println("Produto cadastrado com sucesso!\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// criação do metodo de exibir os produtos cadastrados no banco de dados(READ)
	public List<Produto> getProdutos() {
		String sql = "SELECT * FROM produtos";
		// criando um array de lista para armazenar as informações de produtos
		List<Produto> produtos = new ArrayList<Produto>();
		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// executa um while para percorer o ResultSet, enquanto tiver informações, ele
			// pegará o id, nome, preco e quantidade e adicionará a lista produtos, que será
			// retornada no fim.
			while (rset.next()) {
				Produto produto = new Produto();
				produto.setId(rset.getInt("id"));
				produto.setNome(rset.getString("nome"));
				produto.setPreco(rset.getString("preco"));
				produto.setQuantidade(rset.getInt("quantidade"));

				produtos.add(produto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return produtos;
	}

	public void updateProdutos(Produto produto) {
		String sql = "UPDATE produtos SET nome = ?; preco = ?, quantidade = ? " + "WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getPreco());
			pstm.setInt(3, produto.getQuantidade());

			pstm.setInt(4, produto.getId());

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}

				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void deleteProdutos(int id) {
		String sql = "DELETE FROM produtos WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
