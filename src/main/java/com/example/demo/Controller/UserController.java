package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

//import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.Models.UserModel;
//import org.springframework.web.bind.annotation.GetMapping;
//import java.util.List;
//import java.util.ArrayList;
//import com.example.demo.Models.UserModel;
import com.example.demo.Repositories.UserRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/users") // Base path for all endpoints in this controller
public class UserController {
    /* Forma 1
        @GetMapping
        public String getAllUsers() { 
        // Method to return a list of users
            return "Lista de usuários. . .";
        }
    

    @GetMapping
    public List<UserModel> getAllUsers(){
        List<UserModel> lista = new ArrayList<>();

        // Instanciando objetos da classe UserModel - simulação de banco
        UserModel usuario1 = new UserModel(1, "Alice");
        UserModel usuario2 = new UserModel(2, "Pedro");

        lista.add(usuario1);
        lista.add(usuario2);

        return lista;
    }
        */
   
    @Autowired // Injeção de dependência do repositório de usuários 
    UserRepository repositorio; // Interface para operações de banco de dados 

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){ // Método para retornar uma lista de usuários
        List<UserModel> lista = repositorio.findAll(); // Busca todos os usuários no banco de dados

        return ResponseEntity.status(200).body(lista); // Retorna a lista de usuários com status 200 (OK)
    }

    @GetMapping("/{id}") // Endpoint para buscar usuário por ID
    public ResponseEntity<UserModel> getUser(@PathVariable int id){ // Método para retornar um usuário por ID
        Optional<UserModel> usuario = repositorio.findById(id); // Busca o usuário pelo ID no banco de dados
        if(usuario.isPresent()){ // Se o usuário for encontrado
            return ResponseEntity.status(200).body(usuario.get()); // Retorna o usuário com status 200 (OK)
        } else {
            return ResponseEntity.status(404).body(null); // Retorna status 404 (Não encontrado) se o usuário não existir
        }
    }  

    @PostMapping
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel user){ // Método para criar um novo usuário
        UserModel usuarioSalvo = repositorio.save(user); // Salva o novo usuário no banco de dados
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo); // Retorna o usuário salvo com status 201 (Criado)
        
    }

    @PutMapping("/{id}") // Endpoint para atualizar um usuário por ID
    public ResponseEntity<UserModel> updateUser(@PathVariable int id, @RequestBody UserModel user){ // Método para atualizar um usuário existente
        UserModel usuarioExistente = repositorio.findById(id).orElse(null); // Busca o usuário pelo ID no banco de dados
        if(usuarioExistente == null){ // Se o usuário não for encontrado
            return ResponseEntity.status(404).build(); // Retorna status 404 (Não encontrado)
        } else {
            user.setId(id); // Garante que o ID do usuário a ser atualizado seja o mesmo
            UserModel usuarioAtualizado = repositorio.save(user); // Salva as alterações no banco de dados
            return ResponseEntity.status(200).body(usuarioAtualizado); // Retorna o usuário atualizado com status 200 (OK)
        }
    }

    @DeleteMapping("/{id}") // Endpoint para deletar um usuário por ID
    public ResponseEntity<Void> deleteUser(@PathVariable int id){ // Método para deletar
        Optional<UserModel> usuario = repositorio.findById(id); // Busca o usuário pelo ID no banco de dados
        if(usuario.isPresent()){ // Se o usuário for encontrado
            repositorio.deleteById(id); // Deleta o usuário do banco de dados
            return ResponseEntity.status(204).build(); // Retorna status 204 (Sem conteúdo) indicando sucesso na deleção
        } else {
            return ResponseEntity.status(404).build(); // Retorna status 404 (Não encontrado) se o usuário não existir
        }   
    }
    
    
}
