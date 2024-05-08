package org.example.kafkaconsumerdeserializer.dto;

import lombok.Data;

@Data
public class Invoice {

	public int invoiceNumber;
	public String customerName;
	public double totalAmount;

}
