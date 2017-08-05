package com.yunpay.database.page;

import java.io.Serializable;

/**
 * 分页参数传递工具类 .
 * @company：深圳市前海汇商惠电子商务有限公司
 */
public class PageParam implements Serializable {

    /**
   * 
   */
    private static final long serialVersionUID = 6297178964005032338L;

    /**
     * 默认为第一页.
     */
    public static final int DEFAULT_PAGE_NUM = 1;

    /**
     * 默认每页记录数(15).
     */
    public static final int DEFAULT_NUM_PER_PAGE = 15;

    /**
     * 最大每页记录数(100).
     */
    public static final int MAX_PAGE_SIZE = 100;

    private int pageCurrent = DEFAULT_PAGE_NUM; // 当前页数

    private int pageSize; // 每页记录数
    
    /** 当前页数 */
    public int getPageCurrent() {
        return pageCurrent;
    }

    /** 当前页数 */
    public void setPageCurrent(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }
    
    /** 每页记录数 */
    public int getPageSize() {
        return pageSize > 0 ? pageSize : DEFAULT_NUM_PER_PAGE;
    }
    
    /** 每页记录数 */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 默认构造函数
     */
    public PageParam(){}

    /**
     * 带参数的构造函数
     * @param pageNum
     * @param numPerPage
     */
    public PageParam(int pageNum , int numPerPage){}

}
