package com.osp.npo.app.viewhelper;

import java.util.List;

/**
 * AbstractPageListViewHelper class
 * 
 * @author haint
 * @version $Revision: 17052 $
 */
abstract public class AbstractPageListViewHelper {


    private List list = null;


    private int page = 1;


    private int totalPage = 1;


    private int totalCount = 0;



    public List getList() {
        return list;
    }


    
    public void setList(List list) {
        this.list = list;
    }



    public int getPage() {
        return page;
    }



    public void setPage(int page) {
        this.page = page;
    }


    public int getTotalPage() {
        return totalPage;
    }



    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }



    public int getTotalCount() {
        return totalCount;
    }



    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
