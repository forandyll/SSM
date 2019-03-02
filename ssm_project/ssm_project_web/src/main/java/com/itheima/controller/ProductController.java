package com.itheima.controller;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public String findAll(Model model)throws Exception{
        List<Product> list =  productService.findAll();
        model.addAttribute("productList",list);
        return "product-list";
    }

    //É¾³ý
    @RequestMapping("/deleteAll")
    public String deleteAll(String[] ids)throws Exception{
       /* for (int i = 0; i < ids.length; i++) {
            System.out.println(ids[i]);
        }*/
        productService.deleteAll(ids);
        return "redirect:/product/findAll";
    }



    @RequestMapping("/searchMsg")
    public String searchMsg(String searchvalue,Model model)throws Exception{
        List<Product> list=productService.searchMsg("searchvalue");
        model.addAttribute("productList",list);
        return "redirect:/product/findAll";
    }
    @RequestMapping("/save")
    public String save(Product product) throws Exception {
        System.out.println(product.getProductName());
        productService.save(product);
        return "redirect:/product/findAll";
    }

    /*@RequestMapping("/save")
    public String save(Model model, @RequestParam String productNum,@RequestParam String productName,@RequestParam  String cityName,
    @RequestParam String departureTime,@RequestParam  String productPrice,@RequestParam String productDesc,@RequestParam String productStatus)throws Exception{
        System.out.println(productNum+productName+cityName+departureTime+productPrice+productDesc+productStatus);
        return "redirect:/product/findAll";
    }*/
}
