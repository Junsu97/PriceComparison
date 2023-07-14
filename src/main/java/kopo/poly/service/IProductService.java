package kopo.poly.service;

import kopo.poly.dto.PriceDTO;

import java.util.List;

public interface IProductService{

    List<PriceDTO> performCrawling(String searchKeyword) throws Exception;
}
