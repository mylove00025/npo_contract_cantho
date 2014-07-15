package com.osp.npo.app.context;

/**
 * 
 * @author KienLT
 * @version $Revision: 19103 $
 */
public class ContractTemplateEditContext extends BaseSelectionDeleteContext {
    /** session key */
    public static final String SESSION_KEY = "contractTemplateEditContext";   
    
    private Long id;
    
    
        
    /**
     * Get the id
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }



    /**
     * Set the id
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }



    /**
     * 
     */
    public void clear() {
        
    }
}
