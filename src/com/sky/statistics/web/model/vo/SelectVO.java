package com.sky.statistics.web.model.vo;

/**
 * 封装bootstrap表格查询参数(必须包含构造方法)
 * User: hejunlin
 * Date: 2015/11/6
 * Time: 9:41
 */
public class SelectVO {
    //Object {pageSize: 5, pageNumber: 1, searchText: undefined, sortName: undefined, sortOrder: "asc"…}
    private String searchText;
    private String sortName;
    private String sortOrder;
    private int pageSize;
    private int pageNumber;

    private String filter;//封装查询参数集，手动转bean

    public SelectVO() {
    }

    public SelectVO(String searchText, String sortName, String sortOrder, int pageSize, int pageNumber, String filter) {
        this.searchText = searchText;
        this.sortName = sortName;
        this.sortOrder = sortOrder;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.filter = filter;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
}
