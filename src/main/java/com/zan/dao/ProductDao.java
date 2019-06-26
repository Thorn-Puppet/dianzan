package com.zan.dao;

import com.zan.po.Tb_Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {
    List<Tb_Product> queryProductList ();
}
