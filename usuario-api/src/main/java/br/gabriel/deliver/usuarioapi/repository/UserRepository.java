package br.gabriel.deliver.usuarioapi.repository;

import br.gabriel.deliver.usuarioapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

        public User findByCpf (String cpf);

        List<User> queryByNomeLike (String nome);

}
