package br.gabriel.deliver.shopping.api.repository;

import br.gabriel.deliver.shopping.api.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ShopRepository extends JpaRepository <Shop, Long> {

    public List<Shop> findAllByUserIdentifier(String userIdentifier);

    public List<Shop> findAllByTotalGreaterThan(Float total);

    /*public List<Shop> findAllByDateGreaterThanEquals(Date date);*/

}
