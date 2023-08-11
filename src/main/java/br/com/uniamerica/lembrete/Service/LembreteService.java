package br.com.uniamerica.lembrete.Service;

import br.com.uniamerica.lembrete.Dto.LembreteDTO;
import br.com.uniamerica.lembrete.Entidade.Lembrete;
import br.com.uniamerica.lembrete.Repositorio.LembreteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LembreteService {

    @Autowired
    private LembreteRepositorio lembreteRepositorio;
    private Lembrete lembrete;
    private LembreteDTO lembreteDTO;

    public void criar(LembreteDTO lembreteDTO){
        lembrete = toLembrete(lembreteDTO);

        this.lembreteRepositorio.save(lembrete);
    }

    public LembreteDTO toLembreteDTO(Lembrete lembrete){
        lembreteDTO = new LembreteDTO();

        lembreteDTO.setAnotacoes(lembrete.getAnotacoes());
        lembreteDTO.setPessoa(lembrete.getPessoa());
        return lembreteDTO;
    }

    public Lembrete toLembrete(LembreteDTO lembreteDTO){
        lembrete = new Lembrete();

        lembrete.setAnotacoes(lembreteDTO.getAnotacoes());
        lembrete.setPessoa(lembreteDTO.getPessoa());
        return lembrete;
    }
}
