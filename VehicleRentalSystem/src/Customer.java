public class Customer {
    final String customerId;
    final String customerName;
    final String drivingLicense;
    public Customer(String customerId,String customerName,String drivingLicense){
        this.customerId = customerId;
        this.customerName = customerName;
        this.drivingLicense = drivingLicense;
    }
    public String getCustomerId(){
        return customerId;
    }
    public String getCustomerName(){
        return customerName;
    }
    public String getDrivingLicense(){
        return drivingLicense;
    }
}
