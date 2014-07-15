package com.osp.npo.app.context;

/**
 * <P>Context for User Edit</P>
 *
 * @author KienLT
 * @version $Revision: 17785 $
 *
 */
public class UserEditContext {
    /** session key */
    public static final String SESSION_KEY = "userEditContext";

    private int id;

    /**
     * Get the id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
