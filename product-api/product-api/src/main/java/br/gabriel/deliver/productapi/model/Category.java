package br.gabriel.deliver.productapi.model;

import br.gabriel.deliver.productapi.dto.CategoryDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;

    public static Category convert (CategoryDTO categoryDTO) {
        Category category = new Category();

        category.setId(categoryDTO.getId());
        category.setNome(categoryDTO.getNome());

        return category;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
