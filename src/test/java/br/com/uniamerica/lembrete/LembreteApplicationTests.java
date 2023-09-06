package br.com.uniamerica.lembrete;

import br.com.uniamerica.lembrete.Controller.LembreteController;
import br.com.uniamerica.lembrete.Controller.PessoaController;
import br.com.uniamerica.lembrete.Dto.LembreteDTO;
import br.com.uniamerica.lembrete.Dto.PessoaDTO;
import br.com.uniamerica.lembrete.Entidade.Lembrete;
import br.com.uniamerica.lembrete.Entidade.Pessoa;
import br.com.uniamerica.lembrete.Repositorio.LembreteRepositorio;
import br.com.uniamerica.lembrete.Repositorio.PessoaRepositorio;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class LembreteApplicationTests {

	@MockBean
	PessoaRepositorio pessoaRepositorio;
	@MockBean
	LembreteRepositorio lembreteRepositorio;
	@Autowired
	PessoaController pessoaController;
	@Autowired
	LembreteController lembreteController;

	@BeforeEach
	void injectData(){
		List<Pessoa> pessoa = new ArrayList<>();
		pessoa.add(new Pessoa(1L,"Roberto"));
		Pessoa pessoa1 = new Pessoa(1L, "Roberto");

		Lembrete lembrete = new Lembrete(1L, "anotacoes", pessoa1);
		Mockito.when(lembreteRepositorio.save(lembrete)).thenReturn(lembrete);
		Mockito.when(pessoaRepositorio.findByNome("Roberto")).thenReturn(pessoa);
		Mockito.when(pessoaRepositorio.save(pessoa1)).thenReturn(pessoa1);
	}

	@Test
	void testControllerLembreteCriar(){
		Pessoa pessoa1 = new Pessoa(1L,"Roberto");
		var lembretecontroller = lembreteController.criar(new LembreteDTO(1L, "anotacoes", pessoa1));

		Assert.assertEquals("Lembrete cadastrado com sucesso", lembretecontroller.getBody());
	}

	@Test
	void testControllerPessoaBuscarPeloNome(){
		var pessoacontroller = pessoaController.findByNome("Roberto");
		String nome = pessoacontroller.getBody().get(0).getNome();
		Assert.assertEquals("Roberto", nome);
	}

	@Test
	void testControllerPessoaCriar(){
		var pessoacontroller = pessoaController.criar(new PessoaDTO(1L, "Roberto"));
		Assert.assertEquals("Pessoa cadastrada com sucesso", pessoacontroller.getBody());
	}

	@Test
	void testControllerPessoaEditar(){
		var pessoacontroller = pessoaController.editar(new PessoaDTO(1L, "João"), 1L);
		Assert.assertEquals("Pessoa editada com sucesso", pessoacontroller.getBody());
	}

	@Test
	void testControllerPessoaDeletar(){
		var pessoacontroller = pessoaController.delete(1L);
		Assert.assertEquals("Pessoa deletada com sucesso", pessoacontroller.getBody());
	}


	@Test
	void contextLoads() {
	}



}
