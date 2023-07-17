package kopo.poly.service.impl;

import kopo.poly.dto.ProductDTO;
import kopo.poly.service.IProductService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {

    @Override
    public List<ProductDTO> getProductData(String searchKeyword) throws Exception {
        List<ProductDTO> rDTOList = new ArrayList<>();
        Document document = Jsoup.connect("https://m.acemall.asia/shop/search.php?search=&keyword="+searchKeyword+"&x=0&y=0").get();

        Elements contents = document.select("ul#prd_normal_list li");

        for(Element content : contents){
            String imageUrl = content.select("ul#prd_normal_list li div.box div.img img").attr("src");
            String name = content.select("ul#prd_normal_list li div.box div.info p.name").text();
            String price = content.select("ul#prd_normal_list li div.box div.info p.price strong").text();
            rDTOList.add(ProductDTO.builder()
                    .image(imageUrl)
                    .product(name)
                    .price(price)
                    .url(content.select("div").attr("search_result"))
                    .build());
        }

        return rDTOList;
    }
}
