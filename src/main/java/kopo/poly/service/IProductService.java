package kopo.poly.service;

import kopo.poly.dto.ProductDTO;

import java.util.List;

public interface IProductService{

    List<ProductDTO> getProductData(String searchKeyword) throws Exception;
}
