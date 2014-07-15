package com.osp.npo.core.announcement;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.jdbc.Statement;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.AbstractManager;


/**
 * Generate by script
 * Generate date: 01/27/2011 2:53:52 PM
 * @version $Revision: 29724 $ 
 */
public class AnnouncementManager extends AbstractManager {

	private Long idFilter;
	private String titleFilter;
	private Long idCurentFilter;
	private Byte kindFilter;
	
    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public AnnouncementManager(Connection connection) {
        super(connection);
    }
    
    /**
     * Set the idFilter
     *
     * @param idFilter the idFilter to set
     */
    public void setIdFilter(Long idFilter) {
        this.idFilter = idFilter;
    }

    /**
     * Set the title filter
     * 
     * @param titleFilter
     * @param kind
     */
	public void setTitleFilter(String titleFilter, FilterKind kind) {
		this.titleFilter = this.buildFilterString(titleFilter, kind.getValue());
	}
	
	/**
     * Set the idCurentFilter
     *
     * @param idCurentFilter the idCurentFilter to set
     */
    public void setIdCurentFilter(Long idCurentFilter) {
        this.idCurentFilter = idCurentFilter;
    }
    

    /**
	 * Set kindFilter
	 * @param kindFilter the kindFilter to set
	 */
	public void setKindFilter(Byte kindFilter) {
		this.kindFilter = kindFilter;
	}

	/**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(AnnouncementInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_announcement");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("kind,");
        sqlBuffer.append("confirm_request,");
        sqlBuffer.append("importance_type,");
        sqlBuffer.append("popup_display_flg,");
        sqlBuffer.append("popup_display_day,");
        sqlBuffer.append("title,");
        sqlBuffer.append("content,");
        sqlBuffer.append("sender_info,");
        sqlBuffer.append("send_date_time,");
        sqlBuffer.append("attach_file_name,");
        sqlBuffer.append("attach_file_path,");
        sqlBuffer.append("entry_user_id,");
        sqlBuffer.append("entry_user_name,");
        sqlBuffer.append("entry_date_time,");
        sqlBuffer.append("update_user_id,");
        sqlBuffer.append("update_user_name,");
        sqlBuffer.append("update_date_time");
        sqlBuffer.append(" ) ");
        sqlBuffer.append(" VALUES ");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?");
        sqlBuffer.append(" ) ");
        setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result = -1;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(getSql(), Statement.RETURN_GENERATED_KEYS);

            int i = 1;
            psSetByte(ps, i++, info.getKind());
            psSetByte(ps, i++, info.getConfirmRequest());
            psSetByte(ps, i++, info.getImportanceType());
            psSetBoolean(ps, i++, info.getPopupDisplayFlg());
            psSetLong(ps, i++, info.getPopupDisplayDay());
            psSetString(ps, i++, info.getTitle());
            psSetString(ps, i++, info.getContent());
            psSetString(ps, i++, info.getSenderInfo());
            psSetTimestamp(ps, i++, info.getSendDateTime());
            psSetString(ps, i++, info.getAttachFileName());
            psSetString(ps, i++, info.getAttachFilePath());
            psSetLong(ps, i++, info.getEntryUserId());
            psSetString(ps, i++, info.getEntryUserName());
            psSetTimestamp(ps, i++, info.getEntryDateTime());
            psSetLong(ps, i++, info.getUpdateUserId());
            psSetString(ps, i++, info.getUpdateUserName());
            psSetTimestamp(ps, i++, info.getUpdateDateTime());

            result = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            Integer generatedId = new Integer(rs.getInt(1));
            info.setAid(new Long(generatedId));
        } finally {
            close(ps);
        }

        return result;
    }


    /**
     * <P>Delete a record</P>
     * 
     * @param  id
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int delete(Long id) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" DELETE FROM ");
        sqlBuffer.append(" npo_announcement ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" aid = ? ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try{
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetLong(ps, 1, id);

            result = ps.executeUpdate();

        } finally{
            close(ps);
        }

        return result;
    }


    /**
     * <P>Update infomation</P>
     * 
     * @param  info  Infomation that need update
     * @return  PreparedStatement#executeUpdate return's value
     * @throws SQLException
     * @throws IOException
     */
    public int update(AnnouncementInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_announcement");
        sqlBuffer.append(" SET ");
        sqlBuffer.append("aid=?");

        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append("aid=?");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            psSetLong(ps, i++, info.getAid());
            
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            psSetLong(ps, i++, info.getAid());

            result = ps.executeUpdate();
        } finally {
            close(ps);
        }

        return result;
    }


    /**
     * <P>Get all infomation</P>
     * 
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public AnnouncementList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append( "npo_announcement na" );
        sqlBuffer.append(getBaseSQL(prmList));
        appendOrderField(sqlBuffer);
        if ((offset >= 0) && (limit >= 0)){
            sqlBuffer.append(" LIMIT ? ");
            sqlBuffer.append("OFFSET ? ");
        }
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        AnnouncementList list = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i ++, prmList.get(j));
            }
            if ((offset >= 0) && (limit >= 0)){
                psSetObject(ps, i ++, limit);
                psSetObject(ps, i ++, offset);
            }
            rs = ps.executeQuery();

            AnnouncementInfo info = null;
            list = new AnnouncementList();
            while(rs.next()) {
                info = new AnnouncementInfo();
                rsSetInfo(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }
    
    /**
     * <P>Get latest announcement</P>
     * 
     * @param  count Number of announcement
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public AnnouncementList selectLatestAnnouncement(int count) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_announcement na " );
        sqlBuffer.append(getBaseSQL(prmList));
        
        sqlBuffer.append(" ORDER BY send_date_time DESC " );
        
        int offset = 0;
        int limit = count;
        
        if ((offset >= 0) && (limit >= 0)){
            sqlBuffer.append("LIMIT ? ");
            sqlBuffer.append("OFFSET ? ");
        }

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        AnnouncementList list = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i ++, prmList.get(j));
            }
            if ((offset >= 0) && (limit >= 0)){
                psSetObject(ps, i ++, limit);
                psSetObject(ps, i ++, offset);
            }
            rs = ps.executeQuery();

            AnnouncementInfo info = null;
            list = new AnnouncementList();
            while(rs.next()) {
                info = new AnnouncementInfo();
                rsSetInfo(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }
    
    /**
     * <P>Get last announcement</P>
     * 
     * @param  count Number of announcement
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public AnnouncementList selectLateAnnouncement(int count) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_announcement na " );
        sqlBuffer.append(getBaseSQL(prmList));
        
        sqlBuffer.append(" ORDER BY send_date_time DESC " );
        
        int offset = 0;
        int limit = count;
        
        if ((offset >= 0) && (limit >= 0)){
            sqlBuffer.append("LIMIT ? ");
            sqlBuffer.append("OFFSET ? ");
        }

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        AnnouncementList list = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i ++, prmList.get(j));
            }
            if ((offset >= 0) && (limit >= 0)){
                psSetObject(ps, i ++, limit);
                psSetObject(ps, i ++, offset);
            }
            rs = ps.executeQuery();

            AnnouncementInfo info = null;
            list = new AnnouncementList();
            while(rs.next()) {
                info = new AnnouncementInfo();
                rsSetInfo(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }
    
    /**
     * <P>Get announcement by ID</P>
     * 
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @param  aid ID
     * @return  info that geted
     * @throws SQLException
     * @throws IOException
     */
    public AnnouncementInfo selectById(boolean forUpdate, Long aid) throws SQLException, IOException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_announcement na " );
        sqlBuffer.append(" WHERE aid = ? " );
        
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        AnnouncementInfo info = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetLong(ps, 1, aid);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                info = new AnnouncementInfo();
                rsSetInfo(rs, info);
            }
        } finally {
            close(ps, rs);
        }

        return info;
    }
    
    /**
     * <P>Get popup announcement for homepage</P>
     * 
     * @return  info that geted
     * @throws SQLException
     * @throws IOException
     */
    public AnnouncementInfo selectPopupAnnouncement() throws SQLException, IOException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_announcement na " );
        sqlBuffer.append(" WHERE popup_display_flg = true " );
        sqlBuffer.append(" AND popup_display_day is NOT NULL ");
        sqlBuffer.append(" AND  popup_display_day > 0 ");
        sqlBuffer.append(" AND DATE_SUB(CURDATE(), INTERVAL popup_display_day DAY) <= send_date_time " );        
        sqlBuffer.append(" ORDER BY send_date_time DESC ");
        sqlBuffer.append(" LIMIT 1 OFFSET 0 ");
        
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        AnnouncementInfo info = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            rs = ps.executeQuery();
            
            while(rs.next()) {
                info = new AnnouncementInfo();
                rsSetInfo(rs, info);
            }
        } finally {
            close(ps, rs);
        }

        return info;
    }
    
    /**
     * <P>Get count record result. </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     * @throws IOException 
     */
    public int countTotal() throws SQLException, IOException {

    	ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append("npo_announcement na ");
        
        sqlBuffer.append(getBaseSQL(prmList));

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        int result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            
            rs = ps.executeQuery();
            rs.next();
            result = rs.getInt(1);

        } finally {
            close(ps, rs);
        }

        return result;
    }


    /**
     * <P>Set ResultSet to Info instance </P>
     * 
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfo(ResultSet rs,AnnouncementInfo info) throws SQLException {

        info.setAid(rsGetLong(rs, "aid"));
        info.setKind(rsGetByte(rs, "kind"));
        info.setConfirmRequest(rsGetByte(rs, "confirm_request"));
        info.setImportanceType(rsGetByte(rs, "importance_type"));
        info.setPopupDisplayFlg(rsGetBoolean(rs, "popup_display_flg"));
        info.setPopupDisplayDay(rsGetLong(rs, "popup_display_day"));
        info.setTitle(rsGetString(rs, "title"));
        info.setContent(rsGetString(rs, "content"));
        info.setSenderInfo(rsGetString(rs, "sender_info"));
        info.setSendDateTime(rsGetTimestamp(rs, "send_date_time"));
        info.setAttachFileName(rsGetString(rs, "attach_file_name"));
        info.setAttachFilePath(rsGetString(rs, "attach_file_path"));
        info.setEntryUserId(rsGetLong(rs, "entry_user_id"));
        info.setEntryUserName(rsGetString(rs, "entry_user_name"));
        info.setEntryDateTime(rsGetTimestamp(rs, "entry_date_time"));
        info.setUpdateUserId(rsGetLong(rs, "update_user_id"));
        info.setUpdateUserName(rsGetString(rs, "update_user_name"));
        info.setUpdateDateTime(rsGetTimestamp(rs, "update_date_time"));
    }


    /**
     * <P>Create parameter</P>
     * 
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(AnnouncementInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getKind(), ",kind=?", sqlList, prmList);
        addUpdateList(info.getConfirmRequest(), ",confirm_request=?", sqlList, prmList);
        addUpdateList(info.getImportanceType(), ",importance_type=?", sqlList, prmList);
        addUpdateList(info.getPopupDisplayFlg(), ",popup_display_flg=?", sqlList, prmList);
        addUpdateList(info.getPopupDisplayDay(), ",popup_display_day=?", sqlList, prmList);
        addUpdateList(info.getTitle(), ",title=?", sqlList, prmList);
        addUpdateList(info.getContent(), ",content=?", sqlList, prmList);
        addUpdateList(info.getSenderInfo(), ",sender_info=?", sqlList, prmList);
        addUpdateList(info.getSendDateTime(), ",send_date_time=?", sqlList, prmList);
        addUpdateList(info.getAttachFileName(), ",attach_file_name=?", sqlList, prmList);
        addUpdateList(info.getAttachFilePath(), ",attach_file_path=?", sqlList, prmList);
        addUpdateList(info.getEntryUserId(), ",entry_user_id=?", sqlList, prmList);
        addUpdateList(info.getEntryUserName(), ",entry_user_name=?", sqlList, prmList);
        addUpdateList(info.getEntryDateTime(), ",entry_date_time=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserId(), ",update_user_id=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserName(), ",update_user_name=?", sqlList, prmList);
        addUpdateList(info.getUpdateDateTime(), ",update_date_time=?", sqlList, prmList);
    }


    /**
     * <P>Base SQL</P>
     * 
     * @param  prmList  ArrayList
     * @throws SQLException
     */
    private StringBuffer getBaseSQL(ArrayList<Object> prmList) throws SQLException {
        StringBuffer sqlBuffer = new StringBuffer();
        String whereString = getWhereFilter(prmList);
        if(whereString.length() > 0) {
            sqlBuffer.append(" WHERE true ");
            sqlBuffer.append(whereString);
        }
        return sqlBuffer;
    }

    /**
     * <P>>Get where sql statement part.</P>
     * 
     * @param  prmList  ArrayList
     * @return where sql statement
     * @throws SQLException
     */
    private String getWhereFilter(ArrayList<Object> prmList) {
        StringBuffer filterBuffer = new StringBuffer();
        
        if (this.idFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("na.id = ?");
            prmList.add(this.idFilter);
        }
        
        if(this.titleFilter !=null && this.titleFilter.length()>0){
        	appendAnd(filterBuffer);
        	filterBuffer.append("na.title LIKE ?");
        	prmList.add(this.titleFilter);
        }
        
        if (this.idCurentFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("na.aid < ?");
            prmList.add(this.idCurentFilter);
        }  
        
        if (this.kindFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("na.kind = ?");
            prmList.add(this.kindFilter);
        }
        
        return filterBuffer.toString();
    }
}
