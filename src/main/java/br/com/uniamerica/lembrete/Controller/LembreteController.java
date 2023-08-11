package br.com.uniamerica.lembrete.Controller;

import br.com.uniamerica.lembrete.Dto.LembreteDTO;
import br.com.uniamerica.lembrete.Entidade.Lembrete;
import br.com.uniamerica.lembrete.Service.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/lembrete")
public class LembreteController {

    @Autowired
    private LembreteService lembreteService;

    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody LembreteDTO lembreteDTO){
        try{
            this.lembreteService.criar(lembreteDTO);
            return ResponseEntity.ok("Lembrete cadastrado com sucesso");
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }


}
