package com.epharmacy.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epharmacy.Entity.Medicine;
import com.epharmacy.Repository.MedicineRepo;

@Service
public class MedicineService {

	@Autowired
	private MedicineRepo medicineRepo;

	public Medicine addNewMedicine(Medicine medicine) {
		return medicineRepo.save(medicine);

	}

	public List<Medicine> getAllMedicines() {
		return (List<Medicine>) medicineRepo.findAll();
	}

	public void deleteMedicine(Integer medicineId) {
		medicineRepo.deleteById(medicineId);
	}

	public Medicine getMedicineDetailsById(Integer medicineId) {
		return medicineRepo.findById(medicineId).get();
	}

	public List<Medicine> getMedicineDetails(boolean isSingleMedicineCheckout, Integer medicineId) {
		if (isSingleMedicineCheckout) {
			// we buy only single medicine

			List<Medicine> list = new ArrayList<>();
			Medicine medicine = medicineRepo.findById(medicineId).get();
			list.add(medicine);
			return list;

		} else {
			// we checkout entire cart

		}
		return new ArrayList<>();
	}
}
