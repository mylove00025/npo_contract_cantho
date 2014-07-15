package com.osp.npo.app.message;

/**
 * <P>
 * MessageBean
 * </P>
 * 
 * @author Nguyen Trong Hoan
 * @version $Revision: 17055 $
 */
public class MessageBean {


    /** holds key of main message */
    private String key;


    /** Array of replacement keys */
    private String[] keys;


    /** holds array of replacement values */
    private Object[] values;


    /**
     * Constructor
     */
    public MessageBean(String key) {
        this.key = key;
    }


    /**
     * Constructor
     */
    public MessageBean(String key, String[] keys) {
        this.key = key;
        this.keys = keys;
    }


    /**
     * Constructor
     */
    public MessageBean(String key, Object[] values) {
        this.key = key;
        this.values = values;
    }


    /**
     * Constructor
     */
    public MessageBean(String key, String[] keys, Object[] values) {
        this.key = key;
        this.keys = keys;
        this.values = values;
    }


    /**
     * Constructor
     */
    public MessageBean(String key, String key0) {
        this.key = key;
        this.keys = new String[] {key0};
    }


    /**
     * Constructor
     */
    public MessageBean(String key, String key0, String key1) {
        this.key = key;
        this.keys = new String[] {key0, key1};
    }


    /**
     * Constructor
     */
    public MessageBean(String key, String key0, Object value0) {
        this.key = key;
        this.keys = new String[] {key0};
        this.values = new Object[] {value0};
    }


    /**
     * Constructor
     */
    public MessageBean(String key, Object value) {
        this(key, new Object[] {value});
    }


    /**
     * Constructor
     */
    public MessageBean(String key, Object value0, Object value1) {
        this(key, new Object[] {value0, value1});
    }


    /**
     * Constructor
     */
    public MessageBean(String key, Object value0, Object value1, Object value2) {
        this(key, new Object[] {value0, value1, value2});
    }


    /**
     * Constructor
     */
    public MessageBean(String key, Object value0, Object value1, Object value2,
            Object value3) {
        this(key, new Object[] {value0, value1, value2, value3});
    }



    public String getKey() {
        return key;
    }



    public void setKey(String key) {
        this.key = key;
    }



    public String[] getKeys() {
        return keys;
    }



    public void setKeys(String[] keys) {
        this.keys = keys;
    }



    public Object[] getValues() {
        return values;
    }



    public void setValues(Object[] values) {
        this.values = values;
    }
}
