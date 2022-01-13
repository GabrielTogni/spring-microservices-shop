package br.gabriel.deliver.productapi.dto;

import br.gabriel.deliver.productapi.model.Category;
import lombok.Data;


public class CategoryDTO {

    private Long Id;
    private String nome;

    public static CategoryDTO convert(Category category) {

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId(category.getId());
        categoryDTO.setNome(category.getNome());

        return categoryDTO;
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
