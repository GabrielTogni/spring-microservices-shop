package br.gabriel.deliver.productapi.controller;

import br.gabriel.deliver.productapi.dto.ProductDTO;
import br.gabriel.deliver.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping ("/product")
    public List<ProductDTO> getProducts () {
        List <ProductDTO> produtos = productService.getAll();
        return produtos;
    }

    @PostMapping("/product")
    ProductDTO newProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }


}
