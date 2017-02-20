package arsh.model;

public class SuccessResponse {
private String accountIdentifier;
private String success;
public String getAccountIdentifier() {
	return accountIdentifier;
}
public void setAccountIdentifier(String accountIdentifier) {
	this.accountIdentifier = accountIdentifier;
}
public String getSuccess() {
	return success;
}
public void setSuccess(String success) {
	this.success = success;
}

public SuccessResponse(String accountIdentifier, String success) {
	super();
	this.accountIdentifier = accountIdentifier;
	this.success = success;
}

}
