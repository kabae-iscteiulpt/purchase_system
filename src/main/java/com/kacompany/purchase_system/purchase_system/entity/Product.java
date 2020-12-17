package com.kacompany.purchase_system.purchase_system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.kacompany.purchase_system.purchase_system.enums.TypeOfProduct;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseEntity {

	private static final long serialVersionUID = -2727192420332913455L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@Column(name = "prductName", nullable = false)
	private String prductName;

	@Column(name = "typeOfProduct", nullable = false)
	private TypeOfProduct typeOfProduct;
}
