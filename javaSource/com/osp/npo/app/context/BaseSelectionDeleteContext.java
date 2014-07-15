package com.osp.npo.app.context;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

public class BaseSelectionDeleteContext
    extends BaseListContext {
    private List<String> selectedKeys = new ArrayList<String>();

    /**
     * Get the selectedKeys
     *
     * @return the selectedKeys
     */
    public List<String> getSelectedKeys() {
        return selectedKeys;
    }

    /**
     * Set the selectedKeys
     *
     * @param selectedKeys the selectedKeys to set
     */
    public void setSelectedKeys(List<String> selectedKeys) {
        this.selectedKeys = selectedKeys;
    }
    
    /**
     * 
     * 
     */
    public void clearKeys() {
        this.selectedKeys.clear();
    }

    /**
     * 
     * @param includeKeyList
     * @param propertyName
     * @return
     * @throws Exception
     */
    public String[] getCurrentPageKeys(List includeKeyList, String propertyName) throws Exception {
        List<String> returnKeys = new ArrayList<String>();

        for (Object o : includeKeyList) {
//          Class c = o.getClass();
//          Field f = c.getDeclaredField(propertyName);
//          f.setAccessible(true);
//
//          String key = String.valueOf(f.get(o));
            String key = BeanUtils.getProperty(o, propertyName);
            
            if (this.selectedKeys.remove(key)) {
                returnKeys.add(key);
            }
        }

        return returnKeys.toArray(new String[0]);
    }

    /**
     * 
     * @param keys
     */
    public void addKeys(String[] keys) {
        if (keys == null) return;
        
        for (String key : keys) {
            this.selectedKeys.add(key);
        }
    }
}
