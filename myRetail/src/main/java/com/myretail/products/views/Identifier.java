package com.myretail.products.views;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Identifier{
	@JsonProperty("id_type")
	private String idType;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("is_primary")
	private String isPrimary;
	
	@JsonProperty("source")
	private String source;

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
