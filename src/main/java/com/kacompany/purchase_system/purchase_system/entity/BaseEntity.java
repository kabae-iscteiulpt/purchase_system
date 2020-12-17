package com.kacompany.purchase_system.purchase_system.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 650271985214849142L;

	@CreationTimestamp
	private LocalDateTime created_on;

	@UpdateTimestamp
	private LocalDateTime updated_on;

	public LocalDateTime getCreated_on() {
		return created_on;
	}

	public void setCreated_on(LocalDateTime created_on) {
		this.created_on = created_on;
	}

	public LocalDateTime getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(LocalDateTime updated_on) {
		this.updated_on = updated_on;
	}

}
