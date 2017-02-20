package arsh.Bean_Classes;

public class Bean {
	
	private String type;
	private MarketPlaceBean marketplace;
	private String applicationUuid;
	private String flag;
	private CreatorBean creator;
	private PayLoadBean payload;
	private String returnUrl;
	private String[] links;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public MarketPlaceBean getMarketplace() {
		return marketplace;
	}
	public void setMarketplace(MarketPlaceBean marketplace) {
		this.marketplace = marketplace;
	}
	public String getApplicationUuid() {
		return applicationUuid;
	}
	public void setApplicationUuid(String applicationUuid) {
		this.applicationUuid = applicationUuid;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public CreatorBean getCreator() {
		return creator;
	}
	public void setCreator(CreatorBean creator) {
		this.creator = creator;
	}
	public PayLoadBean getPayload() {
		return payload;
	}
	public void setPayload(PayLoadBean payload) {
		this.payload = payload;
	}
	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public String[] getLinks() {
		return links;
	}
	public void setLinks(String[] links) {
		this.links = links;
	}
	
	
}
