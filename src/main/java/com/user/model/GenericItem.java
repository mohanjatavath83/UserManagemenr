package com.user.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class GenericItem {

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationtime;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedtime;

	public Date getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(Date creationtime) {
		this.creationtime = creationtime;
	}

	public Date getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	
}
