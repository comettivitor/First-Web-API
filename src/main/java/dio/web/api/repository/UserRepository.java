package dio.web.api.repository;

import dio.web.api.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public void save(Usuario usuario){
        if(usuario.getId()==null){
            System.out.println("SAVE - Recebendo usuário na camada repositorio!");
        }else{
            System.out.println("UPDATE - Recebendo usuario na camada repositorio");
        }
        System.out.println(usuario);
    }

    public void deleteById(Integer id){
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuario"));
        System.out.println(id);
    }

    public List<Usuario> findAll(){
        System.out.println("LIST - Listando os usuarios do sistema");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Vitor", "password"));
        usuarios.add(new Usuario("Priscyane", "masterpassword"));
        return usuarios;
    }

    public Usuario findById(Integer id){
        System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar usuario"));
        return new Usuario("Vitor", "password");
    }

    public Usuario findUserName(String username){
        System.out.println(String.format("FIND/id - Recebendo o username: %s para localizar usuario"));
        return new Usuario("Vitor", "password");
    }
}
