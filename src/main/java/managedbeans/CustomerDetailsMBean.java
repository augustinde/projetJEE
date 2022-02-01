/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedbeans;

import com.serkox.tpcustomer.resources.Customer;
import com.serkox.tpcustomer.resources.DiscountCode;
import com.serkox.tpcustomer.session.CustomerManager;
import com.serkox.tpcustomer.session.DiscountCodeManager;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author augus
 */
@Named(value = "customerDetailsMBean")
@ViewScoped
public class CustomerDetailsMBean implements Serializable {

    @EJB
    private DiscountCodeManager discountCodeManager;

    @EJB
    private CustomerManager customerManager;

    private int idCustomer;
    private Customer customer;
    
    public int getIdCustomer(){
        return idCustomer;
    }
    
    public void setIdCustomer(int idCustomer){
        this.idCustomer = idCustomer;
    }
    
    public Customer getDetails(){
        return customer;
    }
    
    public String update(){
        customer = customerManager.update(customer);
        return "CustomerList";
    }
    
    public void loadCustomer(){
        this.customer = customerManager.getCustomer(idCustomer);
    }
    
    public List<DiscountCode> getDiscountCodes() {
        return discountCodeManager.getAllDiscountCodes();
    }
    
    public Converter<DiscountCode> getDiscountCodeConverter() {
        return new Converter<DiscountCode>() {
      
        @Override
        public DiscountCode getAsObject(FacesContext context, UIComponent component, String value) {
            return discountCodeManager.findById(value);
        }

      
        @Override
        public String getAsString(FacesContext context, UIComponent component, DiscountCode value) {
          return value.getDiscountCode();
        }
    };
  }
    
    /**
     * Creates a new instance of CustomerDetailsMBean
     */
    public CustomerDetailsMBean() {
    }
    
}
