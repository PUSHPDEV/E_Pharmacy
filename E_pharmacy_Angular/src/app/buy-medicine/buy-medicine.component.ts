import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { OrderDetails } from '../_model/order-details.model';
import { ActivatedRoute } from '@angular/router';
import { Medicine } from '../_model/medicine.model';
import { MedicineService } from '../_services/medicine.service';

@Component({
  selector: 'app-buy-medicine',
  templateUrl: './buy-medicine.component.html',
  styleUrls: ['./buy-medicine.component.css'],
})
export class BuyMedicineComponent implements OnInit {
  isSingleMedicineCheckout: string | null = null;
  medicineDetails: Medicine[] = []; //array

  orderDetails: OrderDetails = {
    fullName: '',
    fullAddress: '',
    contactNumber: '',
    alternateContactNumber: '',
    orderMedicineQuantityList: [],
  };
  constructor(
    private activatedRoute: ActivatedRoute,
    private medicineService: MedicineService
  ) {}
  ngOnInit(): void {
    this.medicineDetails = this.activatedRoute.snapshot.data['medicineDetails'];
    // this.isSingleMedicineCheckout = this.activatedRoute.snapshot.paramMap.get("isSingleProductCheckout");

    // Initialize orderMedicineQuantityList with default values

    this.medicineDetails.forEach((x) =>
      this.orderDetails.orderMedicineQuantityList.push({
        medicineId: x.medicineId,
        quantity: 1,
      })
    );
    console.log(this.orderDetails);
    console.log(this.medicineDetails);
  }

  public placeOrder(orderForm: NgForm) {
    this.medicineService.placeOrder(this.orderDetails).subscribe(
      (resp) => {
        console.log(resp);
        orderForm.reset();
      },
      (err) => {
        console.log(err);
      }
    );
  }
}
