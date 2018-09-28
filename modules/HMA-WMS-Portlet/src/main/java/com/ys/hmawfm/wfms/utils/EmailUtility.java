/**
 * HMA Weekend Work portlet
 * @author Youngsoft, Inc
 *
 *
 */

package com.ys.hmawfm.wfms.utils;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletConfig;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.WindowStateException;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

public class EmailUtility {
	
	private static	Configuration configuration = ConfigurationFactoryUtil.getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");

	private static Log logger = LogFactoryUtil.getLog(EmailUtility.class.getName());
	
	protected static String EMAILFROMADDRESS = "Workforce_Management@hma.honda.com";
	
	public static void sendEmail(String emailFromName, String emailToName,
			String emailFromAddress, String emailToAddress,
			String emailSubject, String emailMessage) {
//		logger.info("Inside email utility");

		try {
			//InternetAddress from = new InternetAddress(emailFromAddress,emailFromName);
			//logger.info("To internet address : " + to.toString());			
    	    String emailINCC=configuration.get("mail.config.CCMail");

			//message.setTo(internetAddresses);
			//MailServiceUtil.sendEmail(message);
			 List<String> userList= new ArrayList<String>();
			 userList.add(emailToAddress);
			 userList.add(emailINCC);
			  InternetAddress[] internetAddresses=null;
		         if(userList.size()>0){
		         internetAddresses=new InternetAddress[userList.size()]; 
				for (int i=0;i<userList.size();i++) {
					internetAddresses[i]=new InternetAddress(userList.get(i));
				} 
		         }
			boolean isMailTemp=GetterUtil.getBoolean(configuration.get("mail.config.verify"),true);
			if(isMailTemp){
				InternetAddress[] testAddresses=new InternetAddress[1];
				testAddresses[0]=new InternetAddress(configuration.get("mail.config.verify.mail"));
				sendMailsInCC(emailFromName, emailFromAddress, emailSubject, emailMessage +" <br> <b>recipients Name:-</b> "+userList, testAddresses);
			}else{
				try {
					if(internetAddresses.length>0){
						sendMailsInCC(emailFromName,emailFromAddress,emailSubject,emailMessage, internetAddresses);}
						} catch (Exception e) {
					logger.error(e);
				}
				
			}
			
		} catch (Exception e) {
			logger.error("Exception while sending email message :"
					+ e.getMessage());
			e.printStackTrace();
		}
		//logger.info("Mail sent successfully");
	}
	public static void sendEmailINCCForServiceNowRole(String emailFromName, String emailToName,
			String emailFromAddress, InternetAddress[] CCemailToAddress,
			String emailSubject, String emailMessage) {
	//	logger.info("Inside email utility");
		try {
			InternetAddress from = new InternetAddress(emailFromAddress,emailFromName);
			InternetAddress to = new InternetAddress(emailToName);			
			MailMessage message = new MailMessage(from, to, emailSubject,emailMessage, true);
			message.setTo(CCemailToAddress);
			MailServiceUtil.sendEmail(message);
		} catch (Exception e) {
			logger.error("Exception while sending email message :"+ e.getMessage());
			e.printStackTrace();
		}
	//logger.info("Mail sent successfully");
	}
	
	
	public void sendMailWithPlainText() {
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;

		try {
	    		fromAddress = new InternetAddress("aa665845@gmail.com");
	    		toAddress = new InternetAddress("xxx@gmail.com");
	    		MailMessage mailMessage = new MailMessage();
	    		mailMessage.setTo(toAddress);
	    		mailMessage.setFrom(fromAddress);
	    		mailMessage.setSubject("Testing mail with Plain Text");
	    		mailMessage.setBody("This Mail Comes From Liferay Is Easy");
	    		MailServiceUtil.sendEmail(mailMessage);
	    		System.out.println("Send mail with Plain Text");
		} catch (AddressException e) {
		    	e.printStackTrace();
		}
		}
	
	public static void sendMailsInCC(String emailFromName,
			String emailFromAddress,
			String emailSubject, String emailMessage,InternetAddress[] ccAddress) {
	//	logger.info("Inside email utility:ccAddress:"+ccAddress.toString());

		try {
			InternetAddress from = new InternetAddress(emailFromAddress,
					emailFromName);
			
			MailMessage message = new MailMessage(from,emailSubject,
					emailMessage, true);
			message.setTo(ccAddress);
			MailServiceUtil.sendEmail(message);
		} catch (Exception e) {
			logger.error("Exception while sending email message :"
				+ e.getMessage());
			e.printStackTrace();
		}
	//	logger.info("Mail sent successfully");
	}

	
	public static void sendMailsNotify(String roleName, String deptNum,
			PortletRequest portletRequest, String subject, String body) {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			String managerEmail = StringPool.BLANK;
			String emailINCC = configuration.get("mail.config.CCMail");
			String emailFromName = EMAILFROMADDRESS;
			String emailFromAddress = EMAILFROMADDRESS;
			List<String> rolelistcc = new ArrayList<String>();

	 if (Validator.isNotNull(deptNum) && Validator.isNotNull(roleName)) { 
			if(HondaPermissionKeys.ROLE_DMP.equalsIgnoreCase(roleName) || HondaPermissionKeys.ROLE_DM.equalsIgnoreCase(roleName) || HondaPermissionKeys.ROLE_DVM.equalsIgnoreCase(roleName)){
				
				if (HondaPermissionKeys.ROLE_DMP.equalsIgnoreCase(roleName)) {
					managerEmail = HondaLogicUtil.getDeptEmailDetailsforCOSApproval(deptNum,HondaPermissionKeys.ROLE_DMP);
				}
				else if (HondaPermissionKeys.ROLE_DM.equalsIgnoreCase(roleName)) {
					managerEmail = HondaLogicUtil.getDeptEmailDetailsforCOSApproval(deptNum,HondaPermissionKeys.COS_NEW_DM);
				}
				else if (HondaPermissionKeys.ROLE_DVM.equalsIgnoreCase(roleName)) {
					managerEmail = HondaLogicUtil.getDeptEmailDetailsforCOSApproval(deptNum,HondaPermissionKeys.COS_NEW_DVM);
				}
				
				rolelistcc.add(managerEmail);
				rolelistcc.add(emailINCC);
				InternetAddress[] internetAddressesForserivcnow = null;
				if (rolelistcc.size() > 0) {
					internetAddressesForserivcnow = new InternetAddress[rolelistcc.size()];
					for (int i = 0; i < rolelistcc.size(); i++) {
						internetAddressesForserivcnow[i] = new InternetAddress(rolelistcc.get(i));
					}
				}
				if ("true".equalsIgnoreCase(configuration.get("mail.config.verify"))) {

					InternetAddress[] testAddresses = new InternetAddress[1];
							testAddresses[0] = new InternetAddress(configuration.get("mail.config.verify.mail"));
							sendMailsInCC(emailFromName, emailFromAddress,subject, body+ " <br> <b>recipients Name:-</b> "+ rolelistcc, testAddresses);		
				} else {
					//EmailUtility.sendEmailINCCForServiceNowRole(emailFromName, " "+roleName.toUpperCase(), emailFromAddress,internetAddressesForserivcnow, subject, body);
					EmailUtility.sendEmailINCCForServiceNowRole(emailFromAddress, roleName.replaceAll("\\s+","").toUpperCase().trim(), emailFromAddress,internetAddressesForserivcnow, subject, body);
				}
			 }
			}
			else {
				long companyId = themeDisplay.getCompanyId();
				if (!roleName.equalsIgnoreCase(HondaPermissionKeys.ROLE_DM) || !roleName.equalsIgnoreCase(HondaPermissionKeys.ROLE_DMP)
						|| !roleName.equalsIgnoreCase(HondaPermissionKeys.ROLE_DVM)) {
					if (Validator.isNotNull(roleName)) {
						Role role = null;
						role = RoleLocalServiceUtil.getRole(companyId, roleName);
						long roleId = role.getRoleId();
						long[] users = UserLocalServiceUtil.getRoleUserIds(roleId);
						List<String> userList = new ArrayList<String>();
						// DynamicQuery
						if (users.length != 0) {
							userList.add(emailINCC);
							List<User> roleUsers = UserLocalServiceUtil.getRoleUsers(roleId);
							for (User user : roleUsers) {
								userList.add(user.getEmailAddress());
							}
						}

						// logger.info(userList+"userList-----userList");
						InternetAddress[] internetAddresses = null;
						if (userList.size() > 0) {
							internetAddresses = new InternetAddress[userList.size()];
							for (int i = 0; i < userList.size(); i++) {
								internetAddresses[i] = new InternetAddress(userList.get(i));
							}
						}
						boolean isMailTemp = GetterUtil.getBoolean(configuration.get("mail.config.verify"), true);
						if (isMailTemp) {
							// logger.info("\t Sending Test Mails \t");
							InternetAddress[] testAddresses = new InternetAddress[1];
							testAddresses[0] = new InternetAddress(configuration.get("mail.config.verify.mail"));
							sendMailsInCC(emailFromName, emailFromAddress,subject, body+ " <br> <b>recipients Name:-</b> "+ userList, testAddresses);
						} else {
							 logger.info(internetAddresses.length);
							try {
								if (internetAddresses.length > 0) {
									//InternetAddress[] testAddresses = new InternetAddress[1];
									//testAddresses[0] = new InternetAddress(configuration.get("mail.config.verify.mail"));
									//sendMailsInCC(emailFromName, emailFromAddress,subject, body+ " <br> <b>recipients Name:-</b> "+ userList, testAddresses);
									sendMailsInCC(emailFromName,emailFromAddress, subject, body,internetAddresses);
								}
							} catch (Exception e) {
								logger.error(e);
							}
						}
					} else {
						logger.info("No role found in portal");
					}

				}

			}
		} catch (Exception e) {
			logger.info("ERROR :: >> " + e.getMessage());
			logger.info(roleName + " having no users in HMA-WMS portal");
		}

	}
	
	public static void modifyPositionMailSender(PortletRequest portletRequest,String posid,String roleKey) throws WindowStateException, PortletModeException{
		String url=GenerateFrindlyURL.getHMAfrindlyURL(portletRequest, posid);
		PortletConfig portletConfig = (PortletConfig) portletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		String[] tokens={posid,url};
		String subject = posid+" Position has been modified";
		String body = posid+" Position has been modified <a href='"+url+"'> Click here to review the record</a>";
		EmailUtility.sendMailsNotify(roleKey, null, portletRequest,subject, body);
	}
	
	
	/*public static void modifyPositionMailSenderLANGULA(PortletRequest portletRequest,String posid,String roleKey) throws WindowStateException, PortletModeException{
	//	String url=GenerateFrindlyURL.getHMAfrindlyURL(portletRequest, posid);
		PortletConfig portletConfig = (PortletConfig) portletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		String[] tokens={"435345","ChandraMouli Siripurapu","03/15/2017 00:31:18 AM"};
		String modified = LanguageUtil.format(portletConfig,Locale.ENGLISH,"position.modofied",tokens);
		
		String Closed = LanguageUtil.format(portletConfig,Locale.ENGLISH,"position.closed",tokens);
		System.out.println(Closed);
		System.out.println(modified);
		//EmailUtility.sendMailsNotify(roleKey, null, portletRequest,subject, body);
	}*/
}
