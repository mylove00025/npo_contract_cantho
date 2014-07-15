package com.osp.npo.core.diagnostic;

/**
 * Diagnostic command code
 * 
 * @author HaiNT
 *
 */
public class DiagnosticCommand {

	//So luong ban ghi van con chua dong bo
	public static final String SYNC_REMAIN_COUNT = "SYNRM";
	
	//So luong ban ghi dong bo loi
	public static final String SYNC_ERR_COUNT = "SYNER";
	
	//So luong ban ghi DLNC cua van phong
	public static final String OFFICE_DATA_PREVENT_COUNT = "PRVOF";
	
	//Tong so luong ban ghi DLNC 
	public static final String TOTAL_DATA_PREVENT_COUNT = "PRVTT";
	
	//So luong ban ghi HD, GD cua van phong
	public static final String OFFICE_TRANSACTION_COUNT = "TRSOF";
	
	//Tong so luong ban ghi HD, GD
	public static final String TOTAL_TRANSACTION_COUNT = "TRSTT";
	
	//Tong so luong ban ghi hop dong noi bo
	public static final String OFFICE_CONTRACT_COUNT = "CNTOF";
	
	//So luong ban ghi trung contract_id
	public static final String DUPLIATE_CONTRACT_ID_COUNT = "DUPCNTID";
	
	//So luong ban ghi trung synchronize_id
	public static final String DUPLIATE_SYNC_ID_COUNT = "DUPSYNID";
}
