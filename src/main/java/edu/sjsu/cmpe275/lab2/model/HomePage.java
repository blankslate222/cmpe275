package edu.sjsu.cmpe275.lab2.model;

/**
 * @author Nikhil, Rayan
 *
 */
public class HomePage {

private String id;
private String firstname;
private String lastname;
private String email;
private String address;
private String organization;
private String aboutMyself;

/**
 * constructor
 */
public HomePage(){
	
}
/**
 * @return id
 */
public String getId() {
	return id;
}
/**
 * @param id userId of the HomePage owner
 */
public void setId(String id) {
	this.id = id;
}
/**
 * @return firstName
 */
public String getFirstname() {
	return firstname;
}
/**
 * @param firstname first name of the HomePage owner
 */
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
/**
 * @return lastName
 */
public String getLastname() {
	return lastname;
}
/**
 * @param lastname last name of the HomePage owner
 */
public void setLastname(String lastname) {
	this.lastname = lastname;
}
/**
 * @return email
 */
public String getEmail() {
	return email;
}
/**
 * @param email email of the HomePage owner
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return address
 */
public String getAddress() {
	return address;
}
/**
 * @param address address of the HomePage owner
 */
public void setAddress(String address) {
	this.address = address;
}
/**
 * @return organization
 */
public String getOrganization() {
	return organization;
}
/**
 * @param organization organization of the HomePage owner
 */
public void setOrganization(String organization) {
	this.organization = organization;
}
/**
 * @return aboutMyself
 */
public String getAboutMyself() {
	return aboutMyself;
}
/**
 * @param aboutMyself bio of the HomePage owner
 */
public void setAboutMyself(String aboutMyself) {
	this.aboutMyself = aboutMyself;
}

}
