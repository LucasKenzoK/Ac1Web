package com.example.ac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.Categoria;
import com.example.ac1.models.Produto;
import com.example.ac1.repositories.CategoriaProdutoRepository;
import com.example.ac1.repositories.ProductRespository;

@SpringBootApplication
public class Ac1Application {

	@Bean
	public CommandLineRunner init(@Autowired ProductRespository productRepository,
			@Autowired CategoriaProdutoRepository categoriaProductRepository) {
		return args -> {
			categoriaProductRepository.inserir(new Categoria(0, "Tecnólogo", "lorem"));
			categoriaProductRepository.inserir(new Categoria(0, "Bacharelado", "lorem"));

			System.out.println("*** Listar todas as categorias ***");
			List<Categoria> listaCategorias = categoriaProductRepository.selecionarTodos();

			productRepository.inserir(new Produto(1, "Análise e Desenvolvimento de sistemas", 1, 1));
			productRepository.inserir(new Produto(2, "Análise e Desenvolvimento de sistemas", 1, 2));

			System.out.println(listaCategorias);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}
