import service.BookingService;
import service.CustomerService;
import service.VehicleService;
import service.ZoomCarService;

import java.util.Date;

public class Driver {
    public static void main(String args[]){
        ZoomCarService zoomCarService=new ZoomCarService();
        zoomCarService.bookingService=new BookingService();
        zoomCarService.customerService=new CustomerService();
        zoomCarService.vehicleService=new VehicleService();
        int v1=zoomCarService.addVehicle("SUV", "1111");
        zoomCarService.setAvailable(v1);
        int v2=zoomCarService.addVehicle("SEDAN", "2222");
        zoomCarService.setAvailable(v2);

        int c1=zoomCarService.addCustomer("jana", "j@j.j");
        int c2=zoomCarService.addCustomer("hiten", "h@h.h");

        System.out.println(zoomCarService.listAllCustomers());

        System.out.println("Before booking: ");
        System.out.println(zoomCarService.listAllVehicles());
        System.out.println();

        String startTime="26-04-2022 1";
        int b1=zoomCarService.addBooking(v1, c1, startTime);
        startTime="26-04-2022 2";
        int b2=zoomCarService.addBooking(v2, c2, startTime);

        System.out.println("After booking: ");
        System.out.println(zoomCarService.listAllVehicles());
        System.out.println(zoomCarService.listAllBookings());
        System.out.println();

        String endTime="27-04-2022 11";
        zoomCarService.returnVehicle(b1, endTime);
        endTime="28-04-2022 3";
        zoomCarService.returnVehicle(b2, endTime);
        System.out.println("After returning: ");
        System.out.println(zoomCarService.listAllVehicles());
        System.out.println(zoomCarService.listAllBookings());
        System.out.println();
        System.out.println("Invoice - " + b1);
        System.out.println(zoomCarService.getInvoice(b1));
        System.out.println();
        System.out.println("Invoice - " + b2);
        System.out.println(zoomCarService.getInvoice(b2));

        System.out.println();
        System.out.println(zoomCarService.getBookingsForUser(c2));
        System.out.println();
        startTime="24-04-2022 2";
        endTime="28-04-2022 3";
        System.out.println(zoomCarService.getBookingsForUser(c2, startTime, endTime));
//        int b2=zoomCarService.addBooking(v1, c2, startTime);
    }
}
