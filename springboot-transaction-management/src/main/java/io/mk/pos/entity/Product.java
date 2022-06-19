package io.mk.pos.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "PROUDCT")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	private String productd;
	private String name;
	private BigDecimal price;
}
