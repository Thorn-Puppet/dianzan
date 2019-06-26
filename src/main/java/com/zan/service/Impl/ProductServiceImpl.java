package com.zan.service.Impl;

import com.zan.cache.RedisHandler;
import com.zan.dao.ProductDao;
import com.zan.po.Tb_Product;
import com.zan.service.IProductService;
import com.zan.vo.ProductVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements IProductService {

    @Resource
    private ProductDao productDao;

    @Resource
    private RedisHandler redisHandler;

    @Override
    public List<ProductVO> queryProductList(Integer userId) {
        List<Tb_Product> tbproducts = productDao.queryProductList();

        //获取缓存中点赞的商品信息
        Set<String> stringSet = redisHandler.queryKeyByExpression("pjname-zan-" + userId + "-*");

        ArrayList<ProductVO> ProductList = new ArrayList<>();
        //遍历数据库中的所有商品信息
        for (Tb_Product product:tbproducts) {
            ProductVO productVO = new ProductVO();
            //stringSet是Redis中所有点赞的key
            //判断缓存中是否有当前商品对应的key
            //如果有key则表示点过赞
            if(stringSet.contains("pjname-zan-" + userId + "-"+product.getProduct_Id())){
                productVO.setZan(true);

            }
            ProductList.add(productVO);
        }
        return ProductList;
    }
}
