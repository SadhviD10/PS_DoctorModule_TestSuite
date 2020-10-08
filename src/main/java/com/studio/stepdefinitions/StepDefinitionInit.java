package com.studio.stepdefinitions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.studio.home.po.DoctorSendFormPO;
import com.studio.home.po.DoctorStaffAdminPO;
import com.studio.home.po.ForgotPasswordPO;
import com.studio.home.po.FormDisablePO;
import com.studio.home.po.LoginPO;
//import com.studio.home.po.PatientDashboardProfilePO;
//import com.studio.home.po.PatientForgotPO;
//import com.studio.home.po.PatientLoginPO;
//import com.studio.home.po.PatientSignUpPO;
//import com.studio.home.po.PatientTestFormPO;
import com.studio.utils.PropFileHandler;
import com.studio.automation.framework.ConfigurationRegistory;
import com.studio.automation.framework.TestSession;





public class StepDefinitionInit {

	 Map<String, Object> options = new HashMap<String, Object>();
	   protected static TestSession session;
	  // static HomePO homePO;
	   static LoginPO loginPO;
	   static ForgotPasswordPO forgotPasswordPO;
	   static DoctorSendFormPO doctorSendFormPO;
	   static DoctorStaffAdminPO doctorStaffAdminPO;
	   
	//   static PatientLoginPO patientLoginPO;
	//   static PatientForgotPO patientForgotPO;
	//   static PatientSignUpPO patientSignUpPO;
	//   static PatientTestFormPO patientTestFormPO;
	//   static PatientDashboardProfilePO patientDashboardProfilePO;
	   
	   static FormDisablePO formDisablePO;
	   
	   public TestSession getTestSession() throws Exception{

		   options.put("APPIUM_APP_NO_RESET", true);
		   if (session == null) {
		   session = new TestSession(options);
		   // session.driver.navigate().refresh();
		   }else {



	//	   String url = ConfigurationRegistory.url;
	//	   session.driver.get(url);
			   
			   
			   String url =PropFileHandler.readProperty("URL");
			   System.out.println(url);
			   session.driver.get(url);	   

		   }
	        
	        for(Entry<String, Object> entry : session.config.entrySet())
	        {
	        	System.out.println("*********"+entry.getKey()+" "+entry.getValue());
	        }
	        
	    //    homePO  = new HomePO(session);
	        loginPO = new LoginPO(session);
	        forgotPasswordPO = new ForgotPasswordPO(session);
	        doctorSendFormPO=new DoctorSendFormPO(session);
	        doctorStaffAdminPO=new DoctorStaffAdminPO(session);

	    //    homeWebPO=new HomeWebPO(session);
    //        patientLoginPO=new PatientLoginPO(session);
    //        patientForgotPO=new PatientForgotPO(session);
    //        patientSignUpPO=new PatientSignUpPO(session);
    //        patientTestFormPO=new PatientTestFormPO(session);
    //        patientDashboardProfilePO=new PatientDashboardProfilePO(session);
            
            formDisablePO=new FormDisablePO(session);

	        return session;
	   }
	   
	   
	 
	
}
