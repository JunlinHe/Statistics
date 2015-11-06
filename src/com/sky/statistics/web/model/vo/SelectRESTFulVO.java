package com.sky.statistics.web.model.vo;

/**
 * 封装bootstrap表格查询参数(必须包含构造方法)
 * User: hejunlin
 * Date: 2015/11/6
 * Time: 9:41
 */
public class SelectRESTFulVO {
    //Object {search: Object, sort: "id", order: "asc", limit: 5, offset: 0}
    private String search;
    private String sort;
    private String order;
    private int limit;
    private int offset;

    private String filter;//封装查询参数集，手动转bean

    public SelectRESTFulVO() {
    }

    public SelectRESTFulVO(String search, String sort, String order, int limit, int offset, String filter) {
        this.search = search;
        this.sort = sort;
        this.order = order;
        this.limit = limit;
        this.offset = offset;
        this.filter = filter;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
}
