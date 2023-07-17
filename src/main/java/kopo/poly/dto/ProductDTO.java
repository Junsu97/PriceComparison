package kopo.poly.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ProductDTO {
    private String image;
    private String product;
    private String price;
    private String url;
}
