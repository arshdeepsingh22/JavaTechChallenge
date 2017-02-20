package arsh.Bean_Classes;

public class CompanyBean {
private String uuid;
private String externalId;
private String name;
private String email;
private String phoneNumber;
private String website;
private String country;



public String getExternalId() {
	return externalId;
}
public void setExternalId(String externalId) {
	this.externalId = externalId;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getWebsite() {
	return website;
}
public void setWebsite(String website) {
	this.website = website;
}
public String getUuid() {
	return uuid;
}
public void setUuid(String uuid) {
	this.uuid = uuid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}

//CompanyBean compBean = new CompanyBean();
//compBean.setUuid(obj.getJSONObject("payload").getJSONObject("company").getString("uuid"));
//compBean.setName(obj.getJSONObject("payload").getJSONObject("company").getString("name"));
//compBean.setEmail(obj.getJSONObject("payload").getJSONObject("company").getString("email"));
//compBean.setPhoneNumber(obj.getJSONObject("payload").getJSONObject("company").getString("phoneNumber"));
//compBean.setCountry(obj.getJSONObject("payload").getJSONObject("company").getString("country"));
////compBean.setWebsite(obj.getJSONObject("payload").getJSONObject("company").getString("website"));



}
