package com.zxl.util;
import com.github.pagehelper.PageInfo;

public class PageUtils {

    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest 
     * @param
     * @return
     */
    public static PageResultT getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResultT pageResultT = new PageResultT();
        pageResultT.setPageNum(pageInfo.getPageNum());
        pageResultT.setPageSize(pageInfo.getPageSize());
        pageResultT.setTotalSize(pageInfo.getTotal());
        pageResultT.setTotalPages(pageInfo.getPages());
        pageResultT.setContent(pageInfo.getList());
        return pageResultT;
    }
}