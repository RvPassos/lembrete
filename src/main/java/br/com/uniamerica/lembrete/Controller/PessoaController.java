package br.com.uniamerica.lembrete.Controller;

import br.com.uniamerica.lembrete.Dto.PessoaDTO;
import br.com.uniamerica.lembrete.Entidade.Pessoa;
import br.com.uniamerica.lembrete.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.rmi.server.ExportException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/all")
    public ResponseEntity<List<PessoaDTO>> getAll(){
        return ResponseEntity.ok(this.pessoaService.listAll());
    }

    @GetMapping("/findByNome/{nome}")
    public ResponseEntity<List<PessoaDTO>> findByNome(@PathVariable("nome") String nome){
        return ResponseEntity.ok(this.pessoaService.findByNome(nome));
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody PessoaDTO pessoaDTO){
        try{
            this.pessoaService.criar(pessoaDTO);
            return ResponseEntity.ok("Pessoa cadastrada com sucesso");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@RequestBody PessoaDTO pessoaDTO, @PathVariable("id") Long id){
        try{
            this.pessoaService.editar(pessoaDTO, id);
            return ResponseEntity.ok("Pessoa editada com sucesso");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        try{
            this.pessoaService.deletar(id);
            return ResponseEntity.ok("Pessoa deletada com sucesso");
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

}
