package com.fiap.loja.view;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import com.fiap.loja.bo.EstoqueBO;
import com.fiap.loja.exception.ProdutoNaoEncontradoException;
import com.fiap.loja.singleton.PropertySingleton;
import com.fiap.loja.to.ProdutoTO;

public class TerminalConsulta {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("R$#,###.00");
		
		//Recuperar o nome da loja no arquivo de propriedades
		String nomeLoja = PropertySingleton.getInstance().getProperty("nome_loja");
		
		//Imprimir o cabeçalho com a data formatada
		System.out.println(nomeLoja + "              Data " 
						+ sdf.format(Calendar.getInstance().getTime()) );
		System.out.println("*******************************************");
		
		//Ler o código 
		System.out.println("Código do produto: ");
		int codigo = sc.nextInt();
		
		//Instancia a classe de negócio
		EstoqueBO estoqueBO = new EstoqueBO();
		
		try {
			//Tenta buscar o produto, se não encontrar lança exception
			ProdutoTO produto = estoqueBO.consultarProduto(codigo);
			System.out.println("Código: " + produto.getCodigo());
			System.out.println("Descrição: " + produto.getDescricao());
			System.out.println("Preço: " + df.format(produto.getPreco()));
			System.out.println("Estoque: " + produto.getEstoque());
		} catch (ProdutoNaoEncontradoException e) {
			System.out.println("Produto Não Encontrado");
		}
		
		sc.close();
	}
}








