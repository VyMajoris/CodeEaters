package com.fiap.loja.bo;

import com.fiap.loja.exception.ProdutoNaoEncontradoException;
import com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {

	public ProdutoTO consultarProduto(int codigo) 
								throws ProdutoNaoEncontradoException{
		ProdutoTO produto = new ProdutoTO();
		switch (codigo) {
		case 401:
			produto.setCodigo(401);
			produto.setDescricao("Camiseta Masculina Manga Curta Branca");
			produto.setEstoque(10);
			produto.setPreco(40.0);
			break;
		case 402:
			produto.setCodigo(402);
			produto.setDescricao("Camiseta Feminina Manga Longa Rosa");
			produto.setEstoque(2);
			produto.setPreco(100.0);
			break;
		default:
			throw new ProdutoNaoEncontradoException();
		}
		return produto;
	}
}
