package com.zxl.service;

import com.zxl.entity.myCart.Sku;

/****
 * @Author:zxl
 *****/
public interface SkuService {

    /***
     * Sku多条件分页查询
     * @param sku
     * @param page
     * @param size
     * @return
     */
//    PageInfo<Sku> findPage(Sku sku, int page, int size);
//
//    /***
//     * Sku分页查询
//     * @param page
//     * @param size
//     * @return
//     */
//    PageInfo<Sku> findPage(int page, int size);
//
//    /***
//     * Sku多条件搜索方法
//     * @param sku
//     * @return
//     */
//    List<Sku> findList(Sku sku);
//
//    /***
//     * 删除Sku
//     * @param id
//     */
//    void delete(Long id);
//
//    /***
//     * 修改Sku数据
//     * @param sku
//     */
//    void update(Sku sku);
//
//    /***
//     * 新增Sku
//     * @param sku
//     */
//    void add(Sku sku);

    /**
     * 根据ID查询Sku
     * @param id
     * @return
     */
     Sku findById(Long id);

    /***
     * 查询所有Sku
     * @return
     */
//    List<Sku> findAll();
//
//    /**
//     * 查询符合条件的eSKU的列表数据
//     * @param status
//     * @return
//     */
//    List<Sku> findByStatus(String status);
}
