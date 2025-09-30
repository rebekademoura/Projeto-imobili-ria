package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.BairroModel;
import com.example.demo.Repositories.BairroRepository;

@Service
public class BairroService {
    
    @Autowired // Injeção de dependência do repositório de usuários 
    BairroRepository repositorio; // Interface para operações de banco de dados 

    //Http -> controller -> service -> repositorio -> banco de dados
    public List<BairroModel> getAll(){
        List<BairroModel> lista = repositorio.findAll(); // Busca todos os usuários no banco de dados
        return lista; // Retorna a lista de usuários
    }

    public BairroModel find(Integer id){ //método busca por um id
        Optional<BairroModel> model = repositorio.findById(id); //busca o usuário pelo id
        return model.orElse(null); //retorna o usuário ou nulo se não encontrado
    }

    public BairroModel insert(BairroModel objeto){
        BairroModel model = new BairroModel();
        model.setName(objeto.getName());
        model.setEstado(objeto.getestado());
        model.setCepInicial(objeto.getCepInicial());
        model.setCepFinal(objeto.getCepFinal());
        return repositorio.save(model);
    }

    public BairroModel update(BairroModel bairro){
        try{
            if(find(bairro.getId()) != null){
                return repositorio.save(bairro); //atualiza o usuário no banco de dados
            }
                return null;
        }
        catch(Exception e){
            return null;
        }
    }

    public BairroModel delete(Integer id){
        repositorio.deleteById(id); //deleta o usuário pelo id
        return find(id); //retorna o usuário deletado ou nulo se não encontrado
    }

}
