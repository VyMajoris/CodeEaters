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
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static DecimalFormat df = new DecimalFormat("R$#,###.00");
	public static void main(String[] args) {
		
	}
	
	private static void setup() {
		Scanner sc = new Scanner(System.in);
		
				String nomeLoja = PropertySingleton.getInstance().getProperty("nome_loja");
				
				System.out.println(nomeLoja + "              Data "+ sdf.format(Calendar.getInstance().getTime()) );
				System.out.println("*******************************************");
				
				System.out.println("Código do produto: ");
				int codigo = sc.nextInt();
				print(codigo);
				sc.close();
	}
	public static void say(){System.out.println("teste2");}
	public static void print(int codigo){
		
			EstoqueBO estoqueBO = new EstoqueBO();
		try {
			
			ProdutoTO produto = estoqueBO.consultarProduto(codigo);
			System.out.println("Código: " + produto.getCodigo());
			say();
			System.out.println("Descrição: " + produto.getDescricao());
			System.out.println("Preço: " + df.format(produto.getPreco()));
			System.out.println("Estoque: " + produto.getEstoque());
			
		} catch (ProdutoNaoEncontradoException e) {
			System.out.println("Produto Não Encontrado");
		}
		
	}
}








