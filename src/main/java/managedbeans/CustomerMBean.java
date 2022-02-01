/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedbeans;

import com.serkox.tpcustomer.resources.Customer;
import com.serkox.tpcustomer.session.CustomerManager;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author augus
 */

@Named(value = "customerMBean")
@ViewScoped
public class CustomerMBean implements Serializable {

    @EJB 
    private CustomerManager customerManager;


    private List<Customer> customerList;

    /**
     * Creates a new instance of CustomerMBean
     */
    public CustomerMBean() {
    }
    
    public List<Customer> getCustomers(){
        if(customerList == null){
            customerList = customerManager.getAllCustomers();
        }
        return customerList;
    }
    
}
