package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.UserModel;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.dtos.UserDTO;

@Service
public class UserService {
    
    @Autowired // Injeção de dependência do repositório de usuários 
    UserRepository repositorio; // Interface para operações de banco de dados 

    //Http -> controller -> service -> repositorio -> banco de dados
    public List<UserModel> getAll(){
        List<UserModel> lista = repositorio.findAll(); // Busca todos os usuários no banco de dados
        return lista; // Retorna a lista de usuários
    }

    public UserModel find(Integer id){ //método busca por um id
        Optional<UserModel> model = repositorio.findById(id); //busca o usuário pelo id
        return model.orElse(null); //retorna o usuário ou nulo se não encontrado
    }

    public UserModel insert(UserDTO dto){
        UserModel model = new UserModel();
        model.setName(dto.getName());
        model.setEmail(dto.getEmail());
        model.setRole(dto.getRole());
        return repositorio.save(model);
    }

    public UserModel update(UserModel user){
        try{
            if(find(user.getId()) != null){
                return repositorio.save(user); //atualiza o usuário no banco de dados
            }
                return null;
        }
        catch(Exception e){
            return null;
        }
    }

    public UserModel delete(Integer id){
        repositorio.deleteById(id); //deleta o usuário pelo id
        return find(id); //retorna o usuário deletado ou nulo se não encontrado
    }

}
