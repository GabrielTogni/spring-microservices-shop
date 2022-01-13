package br.gabriel.deliver.shopping.api.model;

import br.gabriel.deliver.shopping.api.dto.ShopDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity(name="shop")
public class Shop {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String userIdentifier;
        private float total;
        private Date date;


        @ElementCollection(fetch = FetchType.EAGER)
        @CollectionTable(name = "item", joinColumns = @JoinColumn(name = "shop_id"))
        private List<Item> items;


    public static Shop convert(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setTotal(shopDTO.getTotal());
//        shop.setDate(shopDTO.getDate());
        shop.setItems(shopDTO
                .getItems()
                .stream()
                .map(Item::convert)
                .collect(Collectors.toList()));
        return shop;
    }
}
