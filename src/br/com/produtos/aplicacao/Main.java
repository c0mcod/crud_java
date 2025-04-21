package br.com.produtos.aplicacao;

import java.util.Scanner;

import br.com.produtos.model.Produto;
import br.com.produtos.produto.dao.ProdutoDAO;

public class Main {

	public static void main(String[] args) {
		Produto produtos = new Produto();
		Produto p1 = new Produto();
		ProdutoDAO produtoDao = new ProdutoDAO();
		Scanner input = new Scanner(System.in);

		while (true) {
			int escolha;
			System.out.println(
					"[1] Cadastrar produto\n[2] Exibir todos os produtos existentes no banco de dados \n[3] Atualizar dados de produtos\n[4] Deletar um produto\n[0] Sair");
			escolha = input.nextInt();
			input.nextLine();

			switch (escolha) {
			case 1:
				try {
					System.out.println("Digite o nome do produto: ");
					String newProduto = input.nextLine();
					produtos.setNome(newProduto);

					System.out.println("Digite o preço do produto: ");
					String newPreco = input.nextLine();
					produtos.setPreco(newPreco);

					System.out.println("Digite a quantidade em estoque: ");
					int newQuantidade = input.nextInt();
					produtos.setQuantidade(newQuantidade);
					produtoDao.cadastrarProduto(produtos);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					System.out.println("-------------produtos--------------");
					for (Produto p : produtoDao.getProdutos()) {
						System.out.println("ID: " + p.getId() + "\nnome: " + p.getNome() + "\nPreço: " + p.getPreco()
								+ "\nQuantidade em estoque: " + p.getQuantidade() + "\n");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					System.out.println("Digite o novo nome do produto: ");
					String updateNome = input.nextLine();

					System.out.println("Digite o novo preço: ");
					String updatePreco = input.nextLine();

					System.out.println("Digite a nova quantidade em estoque");
					int updateQuantidade = input.nextInt();
					
					System.out.println("Digite o id do produto que deseja atualizar: ");
					int updateId = input.nextInt();
					
					p1.setNome(updateNome);
					p1.setPreco(updatePreco);
					p1.setQuantidade(updateQuantidade);
					p1.setId(updateId);
					
					produtoDao.updateProdutos(p1);
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;

			case 4:
				try {
					System.out.println("Digite o id do produto que deseja excluir: ");
					int deleteId = input.nextInt();

					produtoDao.deleteProdutos(deleteId);
					System.out.println("Produto deletado da base de dados com sucesso!");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 0:
				System.out.println("Saindo...");
				input.close();
				return;

			default:
				System.out.println("Opção invalida.");
			}

		}

	}

}
