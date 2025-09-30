package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.Models.BairroModel;
import com.example.demo.Services.BairroService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




//import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/bairros") // Base path for all endpoints in this controller
public class BairroController {
    
    @Autowired // Injeção de dependência do repositório de usuários 
    private BairroService service; // Interface para operações de banco de dados


     @GetMapping()
    public ResponseEntity<List<BairroModel>> getAllbairros() {
        List<BairroModel> listaNormal = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(listaNormal);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BairroModel> getbairroById(@PathVariable int id) {
        BairroModel bairro = service.find(id);
        if (bairro != null) {
            return ResponseEntity.status(HttpStatus.OK).body(bairro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BairroModel> update(@RequestBody BairroModel model, @PathVariable int id){
        model.setId(id); // Garante que o ID do modelo seja o mesmo do caminho
        model = service.update(model);
        
        return ResponseEntity.status(HttpStatus.OK).build(); 
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
     @PostMapping
    public ResponseEntity<Void> insert(@RequestBody BairroModel objeto) {
        BairroModel model = service.insert(objeto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(model.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    
    
}
