package arsh.Bean_Classes;

public class OrderBean {
	private String editionCode;
	private String addonOfferingCode;
	private String pricingDuration;
	private ItemBean[] items;
	private String[] customAttributes;
	public String getEditionCode() {
		return editionCode;
	}
	public String[] getCustomAttributes() {
		return customAttributes;
	}
	public void setCustomAttributes(String[] customAttributes) {
		this.customAttributes = customAttributes;
	}
	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}
	public String getAddonOfferingCode() {
		return addonOfferingCode;
	}
	public void setAddonOfferingCode(String addonOfferingCode) {
		this.addonOfferingCode = addonOfferingCode;
	}
	public String getPricingDuration() {
		return pricingDuration;
	}
	public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}
	public ItemBean[] getItems() {
		return items;
	}
	public void setItems(ItemBean[] items) {
		this.items = items;
	}
	
	
	
}
