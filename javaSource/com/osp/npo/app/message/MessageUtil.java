package com.osp.npo.app.message;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.util.MessageResources;


/**
 * MessageUtil class
 * 
 * @author haint
 * @version $Revision: 17055 $
 */
public class MessageUtil extends Action {


    private ActionMessage message = null;


    private ActionMessages messages = null;


    /**
     * <P>
     * ActionMessages
     * </P>
     * 
     * @param key
     * @return ActionMessages
     */
    public ActionMessages createActionMessages(String key) {

        if ((key != null || !key.equals(""))) {
            messages = new ActionMessages();
            message = new ActionMessage(key);
            messages.add(ActionMessages.GLOBAL_MESSAGE, message);
            return messages;
        }
        return null;
    }


    /**
     * <P>
     * ActionMessages
     * </P>
     * 
     * @param request
     * @param key
     * @param number
     * @return
     */
    public ActionMessages createActionMessages(HttpServletRequest request,
            String key, long number) {

        if ((key != null && !key.equals("")) && number >= 0) {
            messages = new ActionMessages();
            message = new ActionMessage(key, number);
            messages.add(ActionErrors.GLOBAL_MESSAGE, message);

            return messages;
        }
        return null;
    }


    /**
     * <P>
     * ActionMessages
     * </P>
     * 
     * @param request
     * @param key
     * @param key0
     * @return ActionMessages
     */
    public ActionMessages createActionMessages(HttpServletRequest request,
            String key, String key0) {

        if ((key != null && !key.equals(""))
                && (key0 != null && !key0.equals(""))) {
            messages = new ActionMessages();
            MessageResources mr = getResources(request);
            message = new ActionMessage(key0);
            String str = mr.getMessage(message.getKey());
            if (str == null) {
                str = key0;
            }
            message = new ActionMessage(key, str);
            messages.add(ActionMessages.GLOBAL_MESSAGE, message);

            return messages;
        }
        return null;
    }


    /**
     * <P>
     * ActionMessages
     * </P>
     * 
     * @param request
     * @param key
     * @param key0
     * @return ActionMessages
     */
    public ActionMessages addActionMessages(HttpServletRequest request,
            String key, String key0) {

        if ((key != null && !key.equals(""))
                && (key0 != null && !key0.equals(""))) {
            MessageResources mr = getResources(request);
            message = new ActionMessage(key0);
            String str = mr.getMessage(message.getKey());
            if (str == null) {
                str = key0;
            }
            message = new ActionMessage(key, str);
            messages.add(ActionMessages.GLOBAL_MESSAGE, message);

            return messages;
        }
        return null;
    }


    /**
     * <P>
     * ActionMessages
     * </P>
     * 
     * @param request
     * @param key
     * @param key0
     * @param key1
     * @return ActionMessages
     */
    public ActionMessages createActionMessages(HttpServletRequest request,
            String key, String key0, String key1) {

        if ((key != null && !key.equals(""))
                && (key0 != null && !key0.equals(""))
                && (key1 != null && !key1.equals(""))) {
            messages = new ActionMessages();
            MessageResources mr = getResources(request);
            message = new ActionMessage(key0);
            String str1 = mr.getMessage(message.getKey());
            message = new ActionMessage(key1);
            String str2 = mr.getMessage(message.getKey());
            if (str1 == null) {
                str1 = key0;
            }
            if (str2 == null) {
                str2 = key1;
            }
            message = new ActionMessage(key, str1, str2);
            messages.add(ActionMessages.GLOBAL_MESSAGE, message);

            return messages;
        }
        return null;
    }


    /**
     * <P>
     * ActionMessages
     * </P>
     * 
     * @param request
     * @param key
     * @param key0
     * @param key1
     * @param key2
     * @return ActionMessages
     */
    public ActionMessages createActionMessages(HttpServletRequest request,
            String key, String key0, String key1, String key2) {

        if ((key != null && !key.equals(""))
                && (key0 != null && !key0.equals(""))
                && (key1 != null && !key1.equals(""))
                && (key2 != null && !key2.equals(""))) {
            messages = new ActionMessages();
            MessageResources mr = getResources(request);
            message = new ActionMessage(key0);
            String str1 = mr.getMessage(message.getKey());
            message = new ActionMessage(key1);
            String str2 = mr.getMessage(message.getKey());
            message = new ActionMessage(key2);
            String str3 = mr.getMessage(message.getKey());
            if (str1 == null) {
                str1 = key0;
            }
            if (str2 == null) {
                str2 = key1;
            }
            if (str3 == null) {
                str3 = key2;
            }
            message = new ActionMessage(key, str1, str2, str3);
            messages.add(ActionMessages.GLOBAL_MESSAGE, message);

            return messages;
        }
        return null;
    }


    /**
     * <P>
     * ActionMessages
     * </P>
     * 
     * @param request
     * @param key
     * @param key0
     * @param key1
     * @param key2
     * @param key3
     * @return ActionMessages
     */
    public ActionMessages createActionMessages(HttpServletRequest request,
            String key, String key0, String key1, String key2, String key3) {

        if ((key != null && !key.equals(""))
                && (key0 != null && !key0.equals(""))
                && (key1 != null && !key1.equals(""))
                && (key2 != null && !key2.equals(""))
                && (key3 != null && !key3.equals(""))) {
            messages = new ActionMessages();
            MessageResources mr = getResources(request);
            message = new ActionMessage(key0);
            String str1 = mr.getMessage(message.getKey());
            message = new ActionMessage(key1);
            String str2 = mr.getMessage(message.getKey());
            message = new ActionMessage(key2);
            String str3 = mr.getMessage(message.getKey());
            message = new ActionMessage(key3);
            String str4 = mr.getMessage(message.getKey());
            if (str1 == null) {
                str1 = key0;
            }
            if (str2 == null) {
                str2 = key1;
            }
            if (str3 == null) {
                str3 = key2;
            }
            if (str4 == null) {
                str4 = key3;
            }
            message = new ActionMessage(key, str1, str2, str3, str4);
            messages.add(ActionMessages.GLOBAL_MESSAGE, message);

            return messages;
        }
        return null;
    }


    /**
     * <P>
     * ActionMessages
     * </P>
     * 
     * @param fieldName
     * @param key
     * @return ActionMessages
     */
    public ActionMessages createActionMessages(String fieldName, String key) {

        if ((key != null || !key.equals(""))) {
            messages = new ActionMessages();
            message = new ActionMessage(key);
            messages.add(fieldName, message);
            return messages;
        }
        return null;
    }


    /**
     * <P>
     * ActionMessages
     * </P>
     * 
     * @param fieldName
     * @param request
     * @param key
     * @param key0
     * @return ActionMessages
     */
    public ActionMessages createActionMessages(String fieldName,
            HttpServletRequest request, String key, String key0) {

        if ((key != null && !key.equals(""))
                && (key0 != null && !key0.equals(""))) {
            messages = new ActionMessages();
            MessageResources mr = getResources(request);
            message = new ActionMessage(key0);
            String str = mr.getMessage(message.getKey());
            if (str == null) {
                str = key0;
            }
            message = new ActionMessage(key, str);
            messages.add(fieldName, message);

            return messages;
        }
        return null;
    }


    /**
     * <P>
     * ActionMessages
     * </P>
     * 
     * @param fieldName
     * @param request
     * @param key
     * @param key0
     * @param key1
     * @return ActionMessages
     */
    public ActionMessages createActionMessages(String fieldName,
            HttpServletRequest request, String key, String key0, String key1) {

        if ((key != null && !key.equals(""))
                && (key0 != null && !key0.equals(""))
                && (key1 != null && !key1.equals(""))) {
            messages = new ActionMessages();
            MessageResources mr = getResources(request);
            message = new ActionMessage(key0);
            String str1 = mr.getMessage(message.getKey());
            message = new ActionMessage(key1);
            String str2 = mr.getMessage(message.getKey());
            if (str1 == null) {
                str1 = key0;
            }
            if (str2 == null) {
                str2 = key1;
            }
            message = new ActionMessage(key, str1, str2);
            messages.add(fieldName, message);

            return messages;
        }
        return null;
    }


    /**
     * <P>
     * ActionMessages
     * </P>
     * 
     * @param fieldName
     * @param request
     * @param key
     * @param key0
     * @param key1
     * @param key2
     * @return ActionMessages
     */
    public ActionMessages createActionMessages(String fieldName,
            HttpServletRequest request, String key, String key0, String key1,
            String key2) {

        if ((key != null && !key.equals(""))
                && (key0 != null && !key0.equals(""))
                && (key1 != null && !key1.equals(""))
                && (key2 != null && !key2.equals(""))) {
            messages = new ActionMessages();
            MessageResources mr = getResources(request);
            message = new ActionMessage(key0);
            String str1 = mr.getMessage(message.getKey());
            message = new ActionMessage(key1);
            String str2 = mr.getMessage(message.getKey());
            message = new ActionMessage(key2);
            String str3 = mr.getMessage(message.getKey());
            if (str1 == null) {
                str1 = key0;
            }
            if (str2 == null) {
                str2 = key1;
            }
            if (str3 == null) {
                str3 = key2;
            }
            message = new ActionMessage(key, str1, str2, str3);
            messages.add(fieldName, message);

            return messages;
        }
        return null;
    }


    /**
     * <P>
     * ActionMessages
     * </P>
     * 
     * @param fieldName
     * @param request
     * @param key
     * @param key0
     * @param key1
     * @param key2
     * @param key3
     * @return ActionMessages
     */
    public ActionMessages createActionMessages(String fieldName,
            HttpServletRequest request, String key, String key0, String key1,
            String key2, String key3) {

        if ((key != null && !key.equals(""))
                && (key0 != null && !key0.equals(""))
                && (key1 != null && !key1.equals(""))
                && (key2 != null && !key2.equals(""))
                && (key3 != null && !key3.equals(""))) {
            messages = new ActionMessages();
            MessageResources mr = getResources(request);
            message = new ActionMessage(key0);
            String str1 = mr.getMessage(message.getKey());
            message = new ActionMessage(key1);
            String str2 = mr.getMessage(message.getKey());
            message = new ActionMessage(key2);
            String str3 = mr.getMessage(message.getKey());
            message = new ActionMessage(key3);
            String str4 = mr.getMessage(message.getKey());
            if (str1 == null) {
                str1 = key0;
            }
            if (str2 == null) {
                str2 = key1;
            }
            if (str3 == null) {
                str3 = key2;
            }
            if (str4 == null) {
                str4 = key3;
            }
            message = new ActionMessage(key, str1, str2, str3, str4);
            messages.add(fieldName, message);

            return messages;
        }
        return null;
    }
}