package com.mba.dao;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mba.form.AdvisorForm;
import com.mba.form.Concetration;
import com.mba.form.Contact;
import com.mba.form.RegistrationForm;
import com.mba.util.EncodedProgram;

public class UserDao {
	private static String query = "select usertype from usertab where userid=? and password=?";
	private static String concetration = "select DegreeCode,CName from concentratio"; 
	private static String isertStudent = "insert into studentdata(fName,lName,  sID,  uemail,  phoneNo,  perEmail,  entrydate,  verbal,  quantitative, MailingAddr,  gpa,concentrations) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	private static String insertSCredentials ="insert into usertab(userid,password,usertype) values(?,?,?)";
	private static String editEmail = "update studentdata set perEmail=?,uemail=? where sID=?";
	private static String insertConcen ="insert into concentratio(DegreeCode,CName,Advisor) values(?,?,?)";
	private static String insertAdvisor ="insert into advisor(advId,name) values(?,?)";
	private static String concetrationList = "select DegreeCode,status,CName,Advisor from concentratio";
	private static String editConc = "update concentratio set DegreeCode=?,status=?,CName=?,Advisor=? where DegreeCode=?";
	private static String advList = "select advId,name,status from advisor";
	private static String editAdv = "update advisor set status=? where advId=?";
	private static String updateAdvPwd = "update usertab set password=? where userid=?";
	private static String advId = "select userid from usertab where usertype='advisor'";
	private static String editStudentConcen = "SELECT concentrations,DegreeCode FROM concentratio,studentdata where sID=?";
	private static String comptQ = "select QId,Question,type from questionnaire, studentdata WHERE studentdata.ExamAttend = 'no' AND studentdata.sID =?";
	private static String studentId = "select sID from studentdata";
	private static String studentProfile = "select fName,lName,uemail,phoneNo from studentdata where sID=?";
	private static String pullstud = "select fName,lName,uemail,phoneNo from studentdata where Codeofconduct='No'";
	private static String reviewstudentProfile = "select fName,lName,uemail,phoneNo,Answer,Codeofconduct,Question from studentdata left join answers on  sID=StudId left join  questionnaire on QId = QNum where studentdata.sID=?";
	private static String preReqstatus = "SELECT Name, prerequisitstatus.Status FROM prerequisitstatus LEFT JOIN prerequisit ON PID = PreReqID WHERE stuID = ?";
	private static String saveNote = "insert into Note(Note,EnterDate,AdvId) values(?,sysdate(),?)";
	private static String viewNote = "select NoteId,Note,EnterDate from note where AdvId=? order by EnterDate";
	private static String preRequisit = "SELECT PID,Name FROM prerequisit left join prerequisitstatus on PreReqID=PID and stuID=? WHERE PreReqID is null and prerequisit.status=1 ";
	private static String insertPrereq = "insert into prerequisitstatus values(?,?,'Met')";
	private static String insertAns = "insert into answers values(?,?,?)";
	private static String updateStud = "update studentdata set ExamAttend='yes' where sID=?";
	private static String codeofcond = "update studentdata set Codeofconduct='yes' where sID=?";
	private static String chnageStudentStatus = "update studentdata set status=? where sID=?";
	private static String addtPrereq= "insert into prerequisit(PID,Name) values(?,?)";
	private static String getPrequisit = "select PID,Name,status from prerequisit";
	private static String editReq = "update prerequisit set PID=?,Name=? where PID=?";
	private static String activateinactivate = "update prerequisit set status=? where PID=?";
	private static String changeContration = "update studentdata set concentrations=? where sID=?";
	private JdbcTemplate jdbcTemplate; // used  dynamic jdbc template which means (?) 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	public String getUserType(Contact contact){
		System.out.println("template-->"+jdbcTemplate);
		System.out.println("Data--->>"+contact.getUserId()+"  "+contact.getPassword());
		//String userType = (String)jdbcTemplate.queryForObject(query, new Object[]{contact.getUserId(),contact.getPassword()},String.class,String.class);
		String userType = null;
		try {

			userType = (String)jdbcTemplate.queryForObject(
					//query, new Object[] { contact.getUserId(),contact.getPassword() }, String.class);
					query, new Object[] { contact.getUserId(),EncodedProgram.hide(contact.getPassword()) }, String.class);

			System.out.println("UserType------>"+userType);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		
		return userType;
	}
	public boolean insertStudent(RegistrationForm reg){
		System.out.println(reg.getfName()+","+reg.getlName()+","+reg.getsID()+","+reg.getUemail()+","+reg.getPhoneNo()+","+reg.getPerEmail()+","+reg.getEntrydate()+","+reg.getVerbal()+","+reg.getQuantitative()+","+reg.getGpa());
		String str[] = reg.getConcentrations();
		StringBuilder sb= new StringBuilder();
		for(String cons:str){
			sb.append(cons+",");
		}
		int res = jdbcTemplate.update(isertStudent,new Object[]{reg.getfName(),reg.getlName(),reg.getsID(),reg.getUemail(),reg.getPhoneNo(),reg.getPerEmail(),reg.getEntrydate(),reg.getVerbal(),reg.getQuantitative(),reg.getMailingAddr(),reg.getGpa(),sb.toString().substring(0, sb.toString().lastIndexOf(","))});
		if(res>0)
		{
			int res1 = jdbcTemplate.update(insertSCredentials,new Object[]{reg.getsID(),EncodedProgram.hide(reg.getfName()+"@123"),"student"});
			if(res1>0){
				return true;
			}
			return false;
		}
		else
			return false;
	}
	public String getConcetration() {
		List<Map> map = jdbcTemplate.queryForList(concetration);
		StringBuilder sb = new StringBuilder();
	    for(Map m:map){
	    	sb.append("<option value="+m.get("DegreeCode")+">"+m.get("CName")+"</option>");
	    }
		return sb.toString();
	}
	public boolean editEmail(RegistrationForm reg) {
		System.out.println("Editing email");
		int res = jdbcTemplate.update(editEmail,new Object[]{reg.getPerEmail(),reg.getUemail(),reg.getsID()});
		if(res>0){
			System.out.println("result--->"+res);
			return true;
		}
		else
			return false;
	}
	public boolean addAdvisor(AdvisorForm advisor) {
		int res = jdbcTemplate.update(insertAdvisor,new Object[]{advisor.getId(),advisor.getName()}); 
		if(res>0){
			int res1 = jdbcTemplate.update(insertSCredentials,new Object[]{advisor.getId(),EncodedProgram.hide(advisor.getName()+"@123"),"advisor"});
			if(res1>0){
				return true;
			}
			return false;
		}
		else
			return false;
	}
	public boolean addConcen(Concetration conc) {
		int res = jdbcTemplate.update(insertConcen,new Object[]{conc.getdCode(),conc.getcName(),conc.getAdvisor()}); 
		if(res>0){
			System.out.println("result--->"+res);
			return true;
		}
		else
			return false;
	}
	public List<Map> listConcetration() {
		List<Map> list = jdbcTemplate.queryForList(concetrationList);
		System.out.println("List---->"+list);
		return list;
	}
	public boolean editConcetration(Concetration conc) {
		int res = jdbcTemplate.update(editConc,new Object[]{conc.getdCode(),conc.getStat(),conc.getcName(),conc.getAdvisor(),conc.getDegreeCode()}); 
		if(res>0){
			System.out.println("result--->"+res);
			return true;
		}
		else
			return false;
	}
	public List<Map> activeinactive() {
		List<Map> map = jdbcTemplate.queryForList(advList);
		return map;
	}
	public boolean activateAdv(String parameter) {
		String str[] = parameter.split("#");
		System.out.println(str[0]+"data  "+str[1]);
		int res = jdbcTemplate.update(editAdv,new Object[]{str[1],str[0]});
		if(res>0)
		return true;
		else
			return false;
	}
	public boolean resetPwd(String parameter, String parameter2,String advid) {
		int res = jdbcTemplate.update(updateAdvPwd,new Object[]{EncodedProgram.hide(parameter2),advid});
		if(res>0)
		return true;
		else
			return false;
	}
	public List<Map> advList() {
		List<Map> list = jdbcTemplate.queryForList(advId);
		return list;
	}
	public List<Map> editStudentConcen(String sid) {
		List<Map> list = jdbcTemplate.queryForList(editStudentConcen,new Object[]{sid});
		return list;
	}
	public List<Map> completeQ(String user) {
		List<Map> list = jdbcTemplate.queryForList(comptQ,new Object[]{user});
		return list;
		
	}
	public String retrieveStudent() {
		List<Map> list = jdbcTemplate.queryForList(studentId);
		StringBuilder sb= new  StringBuilder();
		sb.append("<option value=''>--Select--</option>");
		for(Map m : list){
			sb.append("<option value="+m.get("sID")+">"+m.get("sID")+"</option>");
		}
		return sb.toString();
	}
	public String studentProfile(int id) {
		// fName,lName,uemail,phoneNo
		List<Map> list = jdbcTemplate.queryForList(studentProfile,new Object[]{id});
		StringBuilder sb= new  StringBuilder();
		sb.append("<table class=\"table table-striped table-bordered\" cellspacing=\"0\" width=\"100%\">");
		sb.append("<thead><tr><th>First Name</th><th>Last Name</th><th>UEmail</th><th>Phone num</th></tr>");
		sb.append("<tbody>");
		for(Map map:list){
			sb.append("<tr><td>"+map.get("fName")+"</td><td>"+map.get("lName")+"</td><td>"+map.get("uemail")+"</td><td>"+map.get("phoneNo")+"</td></tr>");
		}
		sb.append("</tbody></table>");
		return sb.toString();
	}
	public String withdrawstudentProfile(int id,String type) {
		System.out.println("type====>"+type);
		List<Map> list = jdbcTemplate.queryForList(studentProfile,new Object[]{id});
		StringBuilder sb= new  StringBuilder();
		sb.append("<table class=\"table table-striped table-bordered\" cellspacing=\"0\" width=\"100%\">");
		sb.append("<thead><tr><th>First Name</th><th>Last Name</th><th>UEmail</th><th>Phone num</th>");
		if(type.equals("withdraw")){
			sb.append("<th>withdraw</th>");
		}else if(type.equals("accept")){
			sb.append("<th>Accept</th>");
		}else if(type.equals("acceptcond")){
			sb.append("<th>Accept with conditions</th>");
		}
		else if(type.equals("approve")){
			sb.append("<th>Approved for graduation</th>");
		}
		sb.append("</tr>");
		sb.append("<tbody>");
		for(Map map:list){
			sb.append("<tr><td>"+map.get("fName")+"</td><td>"+map.get("lName")+"</td><td>"+map.get("uemail")+"</td><td>"+map.get("phoneNo")+"</td>");
		}
		if(type.equals("withdraw")){
			sb.append("<td><input type='checkbox' onclick='withdrawn(\"withdraw\")'></td>");
		}else if(type.equals("accept")){
			sb.append("<td><input type='checkbox' onclick='withdrawn(\"accept\")'></td>");
		}else if(type.equals("acceptcond")){
			sb.append("<td><input type='checkbox' onclick='withdrawn(\"acceptcond\")'></td>");
		}
		else if(type.equals("approve")){
			sb.append("<td><input type='checkbox' onclick='withdrawn(\"approve\")'></td>");
		}
		sb.append("</tr></tbody></table>");
		return sb.toString();
	}
	public String reviewstudentProfile(int id) {
		List<Map> list = jdbcTemplate.queryForList(reviewstudentProfile,new Object[]{id});
		StringBuilder sb= new  StringBuilder();
		sb.append("<table class=\"table table-striped table-bordered\" cellspacing=\"0\" width=\"100%\">");
		sb.append("<thead><tr><th>First Name</th><th>Last Name</th><th>UEmail</th><th>Phone num</th><th>Codeofconduct</th></tr>");
		sb.append("<tbody>");
		if(list!=null){
			Map map=list.get(0);
			sb.append("<tr><td>"+map.get("fName")+"</td><td>"+map.get("lName")+"</td><td>"+map.get("uemail")+"</td><td>"+map.get("phoneNo")+"</td><td>"+map.get("Codeofconduct")+"</td></tr>");
		}
		sb.append("</tbody></table>");
		sb.append("<div stype=\"height:30px;overflow=auto\">");
		sb.append("<fieldset><legend>status of prereq</legend>");
		sb.append("<table class=\"table table-striped table-bordered\" cellspacing=\"0\" width=\"100%\"><thead><th>Name</th><th>Status</th></thead><tbody>");
		List<Map> list1 = jdbcTemplate.queryForList(preReqstatus,new Object[]{id});
		for(Map map:list1){
			sb.append("<tr><td>"+map.get("Name")+"</td><td>"+map.get("Status")+"</td></tr>");
		}
		sb.append("</tbody></table>");
		sb.append("</div>");
		sb.append("<div stype=\"height:30px;overflow=auto\">");
		sb.append("<fieldset><legend>Answers for Questions posed to students</legend>");
		sb.append("<table class=\"table table-striped table-bordered\" cellspacing=\"0\" width=\"100%\"><thead><th>Question</th><th>Answer</th></thead><tbody>");
		for(Map map:list){
			sb.append("<tr><td>"+map.get("Question")+"</td><td>"+map.get("Answer")+"</td></tr>");
		}
		sb.append("</tbody></table>");
		sb.append("</div>");
		return sb.toString();
	}
	public boolean saveNote(String note,int userId) {
		int res = jdbcTemplate.update(saveNote,new Object[]{note,userId});
		if(res>0)
		return true;
		else
			return false;
	}
	public List<Map> viewNote(int userId) {
		List<Map> list = jdbcTemplate.queryForList(viewNote,new Object[]{userId});
		return list;
	}
	public List<Map> preRequisit(int userId){
		List<Map> list = jdbcTemplate.queryForList(preRequisit,new Object[]{userId});
		return list;
		
	}
	public int insertpreRequisit(JSONArray json) {
		int res=0;
		try {
			for(int i=0;i<json.length();i++){
				JSONObject jsonObj = json.getJSONObject(i);
				res = jdbcTemplate.update(insertPrereq,new Object[]{jsonObj.getString("stuid"),jsonObj.getString("pid")});
			}
			
			System.out.println("result is:::"+res);
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		
	}
	public int insertAns(JSONArray jsonArray,String user) {
		int res=0;
		try {
			for(int i=0;i<jsonArray.length();i++){
				JSONObject jsonObj = jsonArray.getJSONObject(i);
				if(jsonObj!=null && jsonObj.has("QNO"))
				res = jdbcTemplate.update(insertAns,new Object[]{user,jsonObj.getString("QNO"),jsonObj.getString("Ans")});
				if(res>0){
					res = jdbcTemplate.update(updateStud,new Object[]{user});
				}
			}
			
			System.out.println("result is:::"+res);
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int codeofConduct(String user) {
		int res = jdbcTemplate.update(codeofcond,new Object[]{user});
		if(res>0)
		return 1;
		else
			return 0;
		
		
	}
	public String chnageStudentStatus(int id, String type) {
		int res = jdbcTemplate.update(chnageStudentStatus,new Object[]{type,id});
		if(res>0)
		return "success";
		else
			return "failure";
	}
	public String pullstudlist() {
		List<Map> list = jdbcTemplate.queryForList(pullstud);
		StringBuilder sb= new  StringBuilder();
		sb.append("<table class=\"table table-striped table-bordered\" cellspacing=\"0\" width=\"100%\">");
		sb.append("<thead><tr><th>First Name</th><th>Last Name</th><th>UEmail</th><th>Phone num</th>");
		sb.append("</tr>");
		sb.append("<tbody>");
		for(Map map:list){
			sb.append("<tr><td>"+map.get("fName")+"</td><td>"+map.get("lName")+"</td><td>"+map.get("uemail")+"</td><td>"+map.get("phoneNo")+"</td></tr>");
		}
		sb.append("</tbody></table>");
		return sb.toString();
	}
	public boolean addPrerequist(Contact form) {
		
		int res = jdbcTemplate.update(addtPrereq,new Object[]{form.getUserId(),form.getPassword()}); 
		if(res>0){
			System.out.println("result--->"+res);
			return true;
		}
		else
			return false;
	}
	public String editprerequisit() {
		List<Map> list = jdbcTemplate.queryForList(getPrequisit);
		StringBuilder sb= new  StringBuilder();
		sb.append("<table class=\"table table-striped table-bordered\" cellspacing=\"0\" width=\"100%\">");
		sb.append("<thead><tr><th>PrereqId</th><th>Name</th><th>Status</th><th>Edit</th></thead>");
		sb.append("</tr>");
		sb.append("<tbody>");
		for(Map map:list){
			sb.append("<tr><td><input type='text' value='"+map.get("PID")+"' id='"+map.get("PID")+"'/></td><td><input type='text' value='"+map.get("Name")+"' id='"+map.get("PID")+"N'/></td>");
			if(map.get("status").toString().equals("1")){
				sb.append("<td><button onclick='activate(0,\""+map.get("PID")+"\")'>InActivate</button></td>");
			}else{
				sb.append("<td><button onclick='activate(1,\""+map.get("PID")+"\")'>Activate</button></td>");
			}
			sb.append("<td><button onclick=\"edit('"+map.get("PID")+"','"+map.get("Name")+"')\"/>Edit</button></td></tr>");
		}
		sb.append("</tbody></table>");
		return sb.toString();
	}
	public String chnageStudentStatus(String newid, String oldpid, String name) {
		int res = jdbcTemplate.update(editReq,new Object[]{newid,name,oldpid}); 
		if(res>0){
			System.out.println("result--->"+res);
			return "success";
		}
		else
			return "failure";
		
	}
	public String activateInactivate(String status,String pid) {
		int res = jdbcTemplate.update(activateinactivate,new Object[]{status,pid}); 
		if(res>0){
			System.out.println("result--->"+res);
			return "success";
		}
		else
			return "failure";
	}
	public int changeContration(String stuid, String concen) {
		int res = jdbcTemplate.update(changeContration,new Object[]{concen,stuid}); 
		return res;
	}
}
