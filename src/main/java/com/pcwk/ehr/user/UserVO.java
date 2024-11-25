package com.pcwk.ehr.user;

public class UserVO{
	
	private int empId;
	private String name;
	private String password;
	private String position;
	private int deptNo;
	private String hiredate;
	private String birthday;
	
	public UserVO() {

	}

	public UserVO(int empId, String name, String password, String position, int deptNo,String hiredate, String birthday) {
		super();
		this.empId = empId;
		this.name = name;
		this.password = password;
		this.position = position;
		this.deptNo = deptNo;
		this.hiredate = hiredate;
		this.birthday = birthday;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}


	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "UserVO [empId=" + empId + ", name=" + name + ", password=" + password + ", position=" + position
			 + "]";
	}
	
}