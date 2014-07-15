package com.osp.npo.app.context;

import java.util.List;



abstract public class AbstractPageSelDelContext {


    private List<Long> selDelList = null;



    public void clearSelDelList() {
        this.selDelList = null;
    }



    public boolean removeSelDelList(Long id) {

        boolean flg = false;

        if (getSelDelList().contains(id)) {

            getSelDelList().remove(id);

            flg = true;
        } else {
            flg = false;
        }

        return flg;
    }



    public void addSelDelList(List<Long> ids) {
        this.selDelList.addAll(ids);
    }



    public void setSelDelList(List<Long> selDelList) {
        this.selDelList = selDelList;
    }



    public List<Long> getSelDelList() {
        return this.selDelList;
    }
}
