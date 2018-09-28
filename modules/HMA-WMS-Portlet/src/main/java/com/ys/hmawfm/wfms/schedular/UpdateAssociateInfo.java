package com.ys.hmawfm.wfms.schedular;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseSchedulerEntryMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.ys.hmawfm.wfms.services.model.WFMS_Associate_History;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_Associate_HistoryImpl;
import com.ys.hmawfm.wfms.services.service.WFMS_Associate_HistoryLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_Position_AuditLocalServiceUtil;
import com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService;
import com.ys.hmawfm.wfms.utils.HondaLogicUtil;
import com.ys.hmawfm.wfms.vo.AssociateInformation;

/**
 * @author ChandraMouli S
 *
 */
@Component(
immediate = true, 
service = UpdateAssociateInfo.class
)
public class UpdateAssociateInfo extends BaseSchedulerEntryMessageListener{	
	Boolean Logger = false;	
	@Override
	protected void doReceive(Message message) throws Exception {
		_log.info("corn job  run time--->>>>" + new Date());
	    try {
			PostionAssociateBackup();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}				
	}
	public String AddBackupData(String AssociateVariable,String BackupAssociateValue,String AssociatedValue,String NewValue){
		if(Logger){_log.info(BackupAssociateValue+AssociateVariable+" "+StringPool.OPEN_BRACKET+AssociatedValue.trim()+StringPool.CLOSE_BRACKET+" change to "+StringPool.OPEN_BRACKET+NewValue.trim()+StringPool.CLOSE_BRACKET+" on "+ HondaLogicUtil.getDateFormat(new Date())+" by Scheduler , ");}
		return BackupAssociateValue+AssociateVariable+" "+StringPool.OPEN_BRACKET+AssociatedValue.trim()+StringPool.CLOSE_BRACKET+" change to "+StringPool.OPEN_BRACKET+NewValue.trim()+StringPool.CLOSE_BRACKET+" on "+ HondaLogicUtil.getDateFormat(new Date())+" by Scheduler , ";		
	}
	public String AddBackupData(String AssociateVariable, String AssociatedValue,String NewValue) {
		if(Logger){_log.info(AssociateVariable+" "+StringPool.OPEN_BRACKET+AssociatedValue.trim()+StringPool.CLOSE_BRACKET+" change to "+StringPool.OPEN_BRACKET+NewValue.trim()+StringPool.CLOSE_BRACKET+" on "+ HondaLogicUtil.getDateFormat(new Date())+" by PeopleSoft");}
	    return AssociateVariable+" "+StringPool.OPEN_BRACKET+AssociatedValue.trim()+StringPool.CLOSE_BRACKET+" change to "+StringPool.OPEN_BRACKET+NewValue.trim()+StringPool.CLOSE_BRACKET+" on "+ HondaLogicUtil.getDateFormat(new Date())+" by PeopleSoft";		
	}
	public void AddAssociateHistory(WFMS_Position wfms_position, AssociateInformation assoInfo) throws SystemException {
		WFMS_Associate_History wfms_associate_history=null;
		wfms_associate_history = new WFMS_Associate_HistoryImpl();
		wfms_associate_history.setAssocHistoryId(getassociatehistoryid());
		wfms_associate_history.setAssociateId(wfms_position.getAssociateNumber());
		wfms_associate_history.setAssociateName(assoInfo.getAssociateName());
		wfms_associate_history.setHistory(AddBackupData("AssociateName", wfms_position.getAssociateName(), assoInfo.getAssociateName()));
		WFMS_Associate_HistoryLocalServiceUtil.addWFMS_Associate_History(wfms_associate_history);  		
	}
	public int getassociatehistoryid() throws SystemException {
		DynamicQuery assocHistoryCondition =DynamicQueryFactoryUtil.forClass(WFMS_Associate_History.class);
        assocHistoryCondition.addOrder(OrderFactoryUtil.desc("assocHistoryId"));
		List <WFMS_Associate_History> WfmsAssociateHistory =  WFMS_Associate_HistoryLocalServiceUtil.dynamicQuery(assocHistoryCondition);
          int assocHistoryId=1;
          if(WfmsAssociateHistory.size()>0){
           assocHistoryId=WfmsAssociateHistory.get(0).getAssocHistoryId();
           assocHistoryId=assocHistoryId+1;
          }
          return assocHistoryId;
	}
	public static void PositionAssociatelog(WFMS_Position wfms_position, String oldvalue,String newvalue, String Associatevariable) throws PortalException, SystemException{
		long aid = com.liferay.counter.kernel.service.CounterLocalServiceUtil.increment(WFMS_Position_Audit.class.getName());
		String auditId =String.valueOf(aid);
		try {
			if(Validator.isNotNull(auditId)){
				WFMS_Position_Audit wfms_pos_audit=null;
				wfms_pos_audit=WFMS_Position_AuditLocalServiceUtil.createWFMS_Position_Audit(auditId);
					if(Validator.isNotNull(wfms_pos_audit)){
						wfms_pos_audit.setPaId(auditId);
						wfms_pos_audit.setPId(wfms_position.getPId());
						wfms_pos_audit.setChange(Associatevariable+" "+StringPool.OPEN_BRACKET+"<b>"+oldvalue.trim()+"</b>"+StringPool.CLOSE_BRACKET+" change to "+StringPool.OPEN_BRACKET+"<b>"+newvalue.trim()+"</b>"+StringPool.CLOSE_BRACKET);
						wfms_pos_audit.setCreateDate(new Date());
						wfms_pos_audit.setAssociateId(wfms_position.getAssociateNumber());
						wfms_pos_audit.setCreatedBy("PeopleSoft");
						WFMS_Position_AuditLocalServiceUtil.addWFMS_Position_Audit(wfms_pos_audit);
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public void PostionAssociateBackup() throws SystemException, SQLException, PortalException{
		    List<WFMS_Position> wfms_list;
			wfms_list = WFMS_PositionLocalServiceUtil.getAll();		
			for(WFMS_Position wfms_position : wfms_list ){	
				if(Validator.isNotNull(wfms_position.getAssociateNumber().trim())){
					AssociateInformation assoInfo = HMAAssociateInfoService.fetchDepManagerInfo(wfms_position.getAssociateNumber());
					if(assoInfo.getAssociateName()!=null && assoInfo.getAssociateTitle()!=null && (!(wfms_position.getAssociateName().trim()).equals(assoInfo.getAssociateName().trim()) || !(wfms_position.getAssociateTitle().trim()).equals(assoInfo.getAssociateTitle().trim()))){
						if(!(wfms_position.getAssociateName().trim()).equals(assoInfo.getAssociateName().trim())){
							AddAssociateHistory(wfms_position,assoInfo);
							PositionAssociatelog(wfms_position,wfms_position.getAssociateName(),assoInfo.getAssociateName(),"Associate Name");
						//	wfms_position.setAssociateNameBackup(AddBackupData("AssociateName",wfms_position.getAssociateNameBackup(),wfms_position.getAssociateName(),assoInfo.getAssociateName()));							
						//	System.out.println("AssociateName-------->>>"+assoInfo.getAssociateName());
							wfms_position.setAssociateName(assoInfo.getAssociateName());
							
						}
						if(!(wfms_position.getAssociateTitle().trim()).equals(assoInfo.getAssociateTitle().trim())){
							PositionAssociatelog(wfms_position,wfms_position.getAssociateTitle(),assoInfo.getAssociateTitle(),"Associate Title");
							//wfms_position.setAssociateTitleBackup(AddBackupData("AssociateTitle",wfms_position.getAssociateTitleBackup(),wfms_position.getAssociateTitle(),assoInfo.getAssociateTitle()));
						//	System.out.println("AssociateTitle------>>>>"+assoInfo.getAssociateTitle());
							wfms_position.setAssociateTitle(assoInfo.getAssociateTitle());
						}
						WFMS_PositionLocalServiceUtil.updateWFMS_Position(wfms_position);
				}
			}				
		}
	}
	@Activate
	@Modified
	protected void activate() {
		schedulerEntryImpl.setTrigger(TriggerFactoryUtil.createTrigger(getEventListenerClass(),getEventListenerClass(),"0 0 0 1/1 * ? *"));
		System.out.println("UpdateAssociateInfo---------------->"+new Date());
		_schedulerEngineHelper.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
	}
	@Deactivate
	protected void deactivate() {
		_schedulerEngineHelper.unregister(this);
	}
	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
		ModuleServiceLifecycle moduleServiceLifecycle) {
	}	
	@Reference(unbind = "-")
	protected void setSchedulerEngineHelper(SchedulerEngineHelper schedulerEngineHelper) {

		_schedulerEngineHelper = schedulerEngineHelper;
	}
	@Reference(unbind = "-")
	protected void setTriggerFactory(TriggerFactory triggerFactory) {
	}
	private SchedulerEngineHelper _schedulerEngineHelper;
	private static Log _log = LogFactoryUtil.getLog(UpdateAssociateInfo.class);
}