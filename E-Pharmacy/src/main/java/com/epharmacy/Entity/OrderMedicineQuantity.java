package com.epharmacy.Entity;

public class OrderMedicineQuantity {

	private Integer medicineId;
	private Integer quantity;

	public OrderMedicineQuantity() {
		super();

	}

	public OrderMedicineQuantity(Integer medicineId, Integer quantity) {
		super();
		this.medicineId = medicineId;
		this.quantity = quantity;
	}

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
