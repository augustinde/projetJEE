/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.serkox.tpcustomer.session;

import com.serkox.tpcustomer.resources.Customer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author augus
 */
@Stateless
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<Customer> getAllCustomers(){
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }
    
    public Customer update(Customer customer){
        return em.merge(customer);
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
