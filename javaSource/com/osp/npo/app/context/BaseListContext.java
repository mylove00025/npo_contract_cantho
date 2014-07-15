package com.osp.npo.app.context;

public class BaseListContext {
    private int page = 1;
    private boolean blnMovePage = false;
    /**
     * Get the page
     *
     * @return the page
     */
    public int getPage() {
        return page;
    }
    /**
     * Set the page
     *
     * @param page the page to set
     */
    public void setPage(int page) {
        this.page = page;
    }
    
    /**
     * Move page
     * 
     * @param direction
     */
    public void movePage(String direction) {
        if(direction==null)
            return;
        if (direction.equalsIgnoreCase("first")) {
            page = 1;
        } else if (direction.equalsIgnoreCase("prev")) {
            if ((page - 1) < 1) {
                page = -1;
            } else {
                page--;
            }
        } else if (direction.equalsIgnoreCase("next")) {
            page++;
        } else if (direction.equalsIgnoreCase("last")) {
            page = -1;
        } else {
            throw new IllegalArgumentException("direction");
        }
        

        blnMovePage = true;
    }
    
    /**
     * 
     * @param direction
     * @param recordNum
     */
    public void movePage(String direction, int pageTotal) {
        int pageNum=pageTotal;
        
        if(direction==null)
            return;
        if (direction.equalsIgnoreCase("first")) {
            page = 1;
        } else if (direction.equalsIgnoreCase("prev")) {
            if(page >1 )
                page--;
        } else if (direction.equalsIgnoreCase("next")) {
            if(page<pageNum)
                page++;
        } else if (direction.equalsIgnoreCase("last")) {
            page = pageNum;
        } else {
            throw new IllegalArgumentException("direction");
        }
        

        blnMovePage = true;
    }
    
    /**
     * 
     * @param direction
     * @param recordNum
     */
    public void movePages(String direction) {        
        if(direction==null)
            return;
        if (direction.equalsIgnoreCase("first")) {
            page = 1;
        } else if (direction.equalsIgnoreCase("prev")) {            
            page--;
        } else if (direction.equalsIgnoreCase("next")) {
            page++;
        } else if (direction.equalsIgnoreCase("last")) {
            page = -1;
        } else {
            throw new IllegalArgumentException("direction");
        }        

        blnMovePage = true;
    }
    
    /**
     * 
     * 
     * @param totolPage
     */
    public void adjustPage(int totolPage) {
        if (page > totolPage) {
            if (blnMovePage) {
                page = 1;
            } else {
                page = totolPage;
            }
        } else if (page == -1) {
            page = totolPage;
        }

        if (page == 0) {
            page = 1;
        }
        
        blnMovePage = false;
    }

    /**
     * 
     * 
     */
    public void clearPage() {
        this.page = 1;
    }   
    
}
