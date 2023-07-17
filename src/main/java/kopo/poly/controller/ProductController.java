package kopo.poly.controller;

import kopo.poly.dto.ProductDTO;
import kopo.poly.service.impl.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

//    @GetMapping("/search")
//    private String search(){
//        return "";
//    }

    @GetMapping("/product")
    private String product(Model model, HttpServletRequest request) throws Exception{
        //List<ProductDTO> productList = productService.getProductData(CmmUtil.nvl(request.getParameter("searchKeyword")));
        List<ProductDTO> productList = productService.getProductData("양파");
        model.addAttribute("product",productList);

        return "product";
    }
}
