package com.prashanth.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="test_users")
public class TestUsers implements Serializable{
private int testId;
private String testUser;
private String testPwd;
@Id
/*@GeneratedValue(generator="g1")
@GenericGenerator(name="g1",strategy="com.prashanth.util.FirstCustomGenerator")
@GenericGenerator(name="assign",strategy="hilo",
parameters= {@Parameter(name="max_lo",value="2"),
		@Parameter(name="table",value="mytable"),
		@Parameter(name="column",value="next_hi")})*/

@GeneratedValue(generator="test",strategy=GenerationType.SEQUENCE)
@GenericGenerator(name="test",strategy="sequence",
parameters=@Parameter(name="sequence",value="FORM_SEQ"))
/*@GeneratedValue(generator="test",strategy=GenerationType.SEQUENCE)
@SequenceGenerator(name="test",sequenceName="FORM_SEQ",allocationSize=1)*/
@Column(name="test_id",length=999999999)
public int getTestId() {
	return testId;
}
public void setTestId(int testId) {
	this.testId = testId;
}
@Column(name="test_user")
public String getTestUser() {
	return testUser;
}
public void setTestUser(String testUser) {
	this.testUser = testUser;
}
@Column(name="test_pwd")
public String getTestPwd() {
	return testPwd;
}
public void setTestPwd(String testPwd) {
	this.testPwd = testPwd;
}

}
