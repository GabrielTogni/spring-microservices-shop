package br.gabriel.deliver.usuarioapi.controller;

import br.gabriel.deliver.usuarioapi.dto.UserDTO;
import br.gabriel.deliver.usuarioapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping ("/")
    public String hello (){
        return "Tá funcionando caralho!";
    }

    @GetMapping ("/user")
    public List <UserDTO> getUsers (){
        List <UserDTO> usuarios = userService.getAll();
        return usuarios;
    }

    @GetMapping ("/users/{id}")
    public UserDTO findById (@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping ("/user")
    public UserDTO newUser (@RequestBody UserDTO userDto) {
        userDto.setDataCadastro(LocalDate.now());
        return userService.save(userDto);
    }

    @GetMapping ("/user/cpf/{cpf}")
    public UserDTO findByCpf ( @PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @DeleteMapping ("/user/{id}")
    public UserDTO delete (@PathVariable Long id) {
        return userService.delete(id);
    }

    @GetMapping("/user/search")
    public List <UserDTO> queryByName (@RequestParam (name = "nome", required = true) String nome) {
        return userService.queryByName(nome);
    }

}
