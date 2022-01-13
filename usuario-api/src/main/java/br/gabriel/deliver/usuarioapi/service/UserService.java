package br.gabriel.deliver.usuarioapi.service;

import br.gabriel.deliver.usuarioapi.dto.UserDTO;
import br.gabriel.deliver.usuarioapi.model.User;
import br.gabriel.deliver.usuarioapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll (){
        List <User> usuarios = userRepository.findAll(); //chama a lista de usuários
        return usuarios
                .stream()
                .map(UserDTO::convert) // chama o método map para transformar a lista de entidades em uma lista de DTOs.
                .collect(Collectors.toList()); // retorna uma lista de DTOS
    }

    public UserDTO findById (Long userId) {
        Optional <User> usuario = userRepository.findById(userId); // busca a lista com o Id passado
        if (usuario.isPresent()) { // se estiver na lista faz uma ação
            return UserDTO.convert(usuario.get());
        } return null;
    }

    public UserDTO save (UserDTO userDTO) {
        User user = userRepository.save(User.convert(userDTO));
        return UserDTO.convert(user);
    }

    /*public UserDTO delete (Long userId) {
        Optional <User> user = userRepository.findById(userId);
        if (user.isPresent()){
            userRepository.delete(user.get());
        } return null;
    }*/

    // Acha pelo CPF
    public UserDTO findByCpf (String cpf){
        User user = userRepository.findByCpf(cpf);
        if (user != null) {
            return UserDTO.convert(user);
        } return null;
    }
    // PROCURA PELO NOME
    public List <UserDTO> queryByName (String name) {
        List <User> usuarios = userRepository.queryByNomeLike(name);
        return usuarios
                .stream()
                .map(UserDTO :: convert)
                .collect(Collectors.toList());
    }

}
