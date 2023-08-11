package br.com.uniamerica.lembrete.Service;

import br.com.uniamerica.lembrete.Entidade.Pessoa;
import br.com.uniamerica.lembrete.Dto.PessoaDTO;
import br.com.uniamerica.lembrete.Repositorio.PessoaRepositorio;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepositorio pessoaRepositorio;
    private Pessoa pessoa;
    private PessoaDTO pessoaDTO;

    public List<PessoaDTO> listAll(){
        List<Pessoa> listBanco = this.pessoaRepositorio.findAll();
        List<PessoaDTO> listDTO = new ArrayList<>();

        for(int i=0;i<listBanco.size();i++){
            listDTO.add(toPessoaDTO(listBanco.get(i)));
        }

        return listDTO;
    }

    public List<PessoaDTO> findByNome(String nome){
        List<Pessoa> listBanco = this.pessoaRepositorio.findByNome(nome);
        List<PessoaDTO> listDTO = new ArrayList<>();

        for(int i=0;i<listBanco.size(); i++){
            listDTO.add(toPessoaDTO(listBanco.get(i)));
        }

        return listDTO;
    }

    public void criar(PessoaDTO pessoaDTO){
        pessoa = toPessoa(pessoaDTO);

        this.pessoaRepositorio.save(pessoa);
    }

    public void editar(PessoaDTO pessoaDTO, Long id){
        pessoa = toPessoa(pessoaDTO);

        pessoa = this.pessoaRepositorio.findById(id).orElse(null);

        this.pessoaRepositorio.save(pessoa);
    }

    public void deletar(Long id){
        pessoa = this.pessoaRepositorio.findById(id).orElse(null);

        this.pessoaRepositorio.delete(pessoa);
    }

    public PessoaDTO toPessoaDTO(Pessoa pessoa){
        pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setLembretes(pessoa.getLembretes());
        return pessoaDTO;
    }

    public Pessoa toPessoa(PessoaDTO pessoaDTO){
        pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setLembretes(pessoaDTO.getLembretes());
        return pessoa;
    }

}
