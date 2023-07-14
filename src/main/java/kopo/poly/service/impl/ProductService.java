package kopo.poly.service.impl;

import kopo.poly.dto.PriceDTO;
import kopo.poly.service.IProductService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {

    @Override
    public List<PriceDTO> performCrawling(String searchKeyword) throws Exception {
        List<PriceDTO> rDTOList = new ArrayList<>();
        Document document = Jsoup.connect(searchKeyword).get();

        Elements contents = document.select("ul#prd_normal_list li");

        for(Element content : contents){
            String imageUrl = content.select("ul#prd_normal_list li div.box div.img img").attr("src");
            String name = content.select("ul#prd_normal_list li div.box div.info p.name").text();
            String price = content.select("ul#prd_normal_list li div.box div.info p.price strong").text();
            PriceDTO rDTO = PriceDTO.builder()
                    .image(imageUrl)
                    .product(name)
                    .price(price)
                    .build();
        }

        return rDTOList;
    }
}
