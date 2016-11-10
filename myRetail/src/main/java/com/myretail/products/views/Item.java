package com.myretail.products.views;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {
	@JsonProperty("identifier")
	private List<Identifier> identifiers;
	
	@JsonProperty("relation")
	private String relation;
	
	@JsonProperty("relation_description")
	private String relationDescription;
	
	@JsonProperty("data_page_link")
	private String dataPageLink;
	
	@JsonProperty("imn_identifier")
	private Integer imnIdentifier;
	
	@JsonProperty("parent_id")
	private String parentId;
	
	@JsonProperty("is_orderable")
	private boolean isOrderable;
	
	@JsonProperty("is_sellable")
	private boolean isSellable;
	
	@JsonProperty("general_description")
	private String generalDescription;
	
	@JsonProperty("is_circular_publish")
	private boolean isCircularPublish;
	
	@JsonProperty("business_process_status")
	private List<BusinessProcessStatus> businessProcessStatus;
	
	@JsonProperty("dpci")
	private String dpci;
	
	@JsonProperty("department_id")
	private Integer departmentId;
	
	@JsonProperty("class_id")
	private Integer classId;
	
	@JsonProperty("item_id")
	private Integer itemId;
	
	@JsonProperty("online_description")
	private ProductDescription onlineDescription;
	
	@JsonProperty("store_description")
	private ProductDescription storeDescription;
	
	@JsonProperty("alternate_description")
	private List<ProductDescription> alternateDescriptions;
	
	@JsonProperty("features")
	private List<Feature> features;
	
	@JsonProperty("errors")
	private List<Error> errors;
	
	public List<Identifier> getIdentifiers() {
		return identifiers;
	}
	public void setIdentifiers(List<Identifier> identifiers) {
		this.identifiers = identifiers;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getRelationDescription() {
		return relationDescription;
	}
	public void setRelationDescription(String relationDescription) {
		this.relationDescription = relationDescription;
	}
	public String getDataPageLink() {
		return dataPageLink;
	}
	public void setDataPageLink(String dataPageLink) {
		this.dataPageLink = dataPageLink;
	}
	public Integer getImnIdentifier() {
		return imnIdentifier;
	}
	public void setImnIdentifier(Integer imnIdentifier) {
		this.imnIdentifier = imnIdentifier;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public boolean isOrderable() {
		return isOrderable;
	}
	public void setOrderable(boolean isOrderable) {
		this.isOrderable = isOrderable;
	}
	public boolean isSellable() {
		return isSellable;
	}
	public void setSellable(boolean isSellable) {
		this.isSellable = isSellable;
	}
	public String getGeneralDescription() {
		return generalDescription;
	}
	public void setGeneralDescription(String generalDescription) {
		this.generalDescription = generalDescription;
	}
	public boolean isCircularPublish() {
		return isCircularPublish;
	}
	public void setCircularPublish(boolean isCircularPublish) {
		this.isCircularPublish = isCircularPublish;
	}
	public List<BusinessProcessStatus> getBusinessProcessStatus() {
		return businessProcessStatus;
	}
	public void setBusinessProcessStatus(List<BusinessProcessStatus> businessProcessStatus) {
		this.businessProcessStatus = businessProcessStatus;
	}
	public String getDpci() {
		return dpci;
	}
	public void setDpci(String dpci) {
		this.dpci = dpci;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public ProductDescription getOnlineDescription() {
		return onlineDescription;
	}
	public void setOnlineDescription(ProductDescription onlineDescription) {
		this.onlineDescription = onlineDescription;
	}
	public ProductDescription getStoreDescription() {
		return storeDescription;
	}
	public void setStoreDescription(ProductDescription storeDescription) {
		this.storeDescription = storeDescription;
	}
	public List<ProductDescription> getAlternateDescriptions() {
		return alternateDescriptions;
	}
	public void setAlternateDescriptions(List<ProductDescription> alternateDescriptions) {
		this.alternateDescriptions = alternateDescriptions;
	}
	public List<Feature> getFeatures() {
		return features;
	}
	public void setFeatures(List<Feature> features) {
		this.features = features;
	}
	public List<Error> getErrors() {
		return errors;
	}
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
}
