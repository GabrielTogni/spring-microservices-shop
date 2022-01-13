package br.gabriel.deliver.productapi.repository;

import br.gabriel.deliver.productapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long> {

}
