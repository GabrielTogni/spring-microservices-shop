package br.gabriel.deliver.usuarioapi.model;

import br.gabriel.deliver.usuarioapi.dto.UserDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;
    private LocalDate dataCadastro;


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    //CONVERTER O DTO PARA MODEL
    public static User convert (UserDTO userDto) {
        User user = new User();
        user.setNome(userDto.getNome());
        user.setEndereco(userDto.getEndereco());
        user.setCpf(userDto.getCpf());
        user.setEmail(userDto.getEmail());
        user.setTelefone(userDto.getTelefone());
        user.setDataCadastro(userDto.getDataCadastro());
        return user;
    }

}
