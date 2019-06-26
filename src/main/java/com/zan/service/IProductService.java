package com.zan.service;

import com.zan.po.Tb_Product;
import com.zan.vo.ProductVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {
    /**
     * 将异常抛到向上抛
     * @return
     * @throws Exception
     */
    List<ProductVO> queryProductList(Integer userId)throws Exception;
}
