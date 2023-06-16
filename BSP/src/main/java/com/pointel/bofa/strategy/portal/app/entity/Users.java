package com.pointel.bofa.strategy.portal.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Users {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userid;
	
//	@Id
//	@GeneratedValue( generator = "USER_GROUPS_GROUP_ID_SEQ",   strategy = GenerationType.SEQUENCE )
//	@SequenceGenerator(name = "USER_GROUPS_GROUP_ID_SEQ", sequenceName = "USER_GROUPS_GROUP_ID_SEQ", allocationSize = 1)
//	private String userid;
	
	
	private String alias;
	private String pass;
	private String lastchg;
	private String email;
	private String displayname;
	private String phone;
	private int active;
	private int proj;
	private int rgu;
	private int ivg;
	private String rollId;
	private int groupId;
	private String mgrid;
	private int usertypeId;
	private Date startdate;
	private int birthmonth;
	private int foreCastAreaId;
	private String nickname;
	private String phone_home;
	private String phone_cell;
	private String pager;
	private String additionalContact;
	private int techComponent;
	private int proj_role;
	private String workstation;
	private String connection_key;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getLastchg() {
		return lastchg;
	}
	public void setLastchg(String lastchg) {
		this.lastchg = lastchg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getProj() {
		return proj;
	}
	public void setProj(int proj) {
		this.proj = proj;
	}
	public int getRgu() {
		return rgu;
	}
	public void setRgu(int rgu) {
		this.rgu = rgu;
	}
	public int getIvg() {
		return ivg;
	}
	public void setIvg(int ivg) {
		this.ivg = ivg;
	}
	public String getRollId() {
		return rollId;
	}
	public void setRollId(String rollId) {
		this.rollId = rollId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getMgrid() {
		return mgrid;
	}
	public void setMgrid(String mgrid) {
		this.mgrid = mgrid;
	}
	public int getUsertypeId() {
		return usertypeId;
	}
	public void setUsertypeId(int usertypeId) {
		this.usertypeId = usertypeId;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public int getBirthmonth() {
		return birthmonth;
	}
	public void setBirthmonth(int birthmonth) {
		this.birthmonth = birthmonth;
	}
	public int getForeCastAreaId() {
		return foreCastAreaId;
	}
	public void setForeCastAreaId(int foreCastAreaId) {
		this.foreCastAreaId = foreCastAreaId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone_home() {
		return phone_home;
	}
	public void setPhone_home(String phone_home) {
		this.phone_home = phone_home;
	}
	public String getPhone_cell() {
		return phone_cell;
	}
	public void setPhone_cell(String phone_cell) {
		this.phone_cell = phone_cell;
	}
	public String getPager() {
		return pager;
	}
	public void setPager(String pager) {
		this.pager = pager;
	}
	public String getAdditionalContact() {
		return additionalContact;
	}
	public void setAdditionalContact(String additionalContact) {
		this.additionalContact = additionalContact;
	}
	public int getTechComponent() {
		return techComponent;
	}
	public void setTechComponent(int techComponent) {
		this.techComponent = techComponent;
	}
	public int getProj_role() {
		return proj_role;
	}
	public void setProj_role(int proj_role) {
		this.proj_role = proj_role;
	}
	public String getWorkstation() {
		return workstation;
	}
	public void setWorkstation(String workstation) {
		this.workstation = workstation;
	}
	public String getConnection_key() {
		return connection_key;
	}
	public void setConnection_key(String connection_key) {
		this.connection_key = connection_key;
	}
	
	
	
	
	
	
	
	
}
