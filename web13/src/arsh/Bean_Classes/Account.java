package arsh.Bean_Classes;

public class Account {
private String accountIdentifier;
private String parentAccountIdentifier;
private String status;
public String getAccountIdentifier() {
	return accountIdentifier;
}
public void setAccountIdentifier(String accountIdentifier) {
	this.accountIdentifier = accountIdentifier;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getParentAccountIdentifier() {
	return parentAccountIdentifier;
}
public void setParentAccountIdentifier(String parentAccountIdentifier) {
	this.parentAccountIdentifier = parentAccountIdentifier;
}

}
