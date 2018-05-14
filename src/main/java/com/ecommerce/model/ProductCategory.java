package com.ecommerce.model;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JacksonInject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ProductCategory {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private UUID id;

	@Column(length = 100, nullable = false,  unique = true)
	private String name;

	@Column(length = 500, nullable = true)
	private String description;

	@Column(nullable = false)
	private boolean enabled;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "product_category_id")
	private Collection<Product> products;

}
