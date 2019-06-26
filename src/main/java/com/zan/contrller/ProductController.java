package com.zan.contrller;

import com.zan.service.IProductService;
import com.zan.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Resource
    private IProductService iProductService;

    @RequestMapping("list")
    public String queryProductList(Model model) throws Exception {
        List<ProductVO> productList = iProductService.queryProductList(1);
        model.addAttribute("list",productList);
        return "product";
    }
}
