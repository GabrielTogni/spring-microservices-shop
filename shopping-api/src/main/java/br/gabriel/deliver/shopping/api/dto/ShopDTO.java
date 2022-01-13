package br.gabriel.deliver.shopping.api.dto;

import br.gabriel.deliver.shopping.api.model.Shop;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ShopDTO {

    @NotBlank
    private String userIdentifier;
    @NotNull
    private Float total;
    @NotNull
    private Date date;
    @NotNull
    private List<ItemDTO> items;


    public static ShopDTO convert(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shop.getTotal());
        return shopDTO;
    }



}
