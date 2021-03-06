/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.coders4africa.elimu.domain.school;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.coders4africa.elimu.domain.Address;
import org.coders4africa.elimu.domain.BaseEntity;

/**
 *
 * @author MSOMDA
 */
@Entity
@Table(name="schools")
@XmlRootElement
public class School extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String fax;
    private String website;
    @OneToOne(targetEntity=Address.class, cascade={
        CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, 
        CascadeType.REMOVE},fetch= FetchType.EAGER)
    @JoinColumn(name="addressID",referencedColumnName="id",unique=true,nullable=false)
    private Address address;
    @OneToMany(targetEntity=Employee.class,cascade={
        CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, 
        CascadeType.REMOVE},fetch= FetchType.LAZY,mappedBy="school")
    private Set<Employee> employees;

    @Override
    @XmlAttribute
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }
    
    /**
     * @return the employees
     */
    @XmlTransient
    public Set<Employee> getEmployees() {
        return employees;
    }

    /**
     * @param employees the employees to set
     */
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    
    /**
     * Convenient method to add a new employee to the list
     * of employees
     * 
     * @param employee 
     */
    public synchronized void addEmployee(Employee employee){
        if(employees == null){
            employees = new HashSet<Employee>();
        }
        employees.add(employee);
    }
    
    /**
     * Convenient method to add a new employee to the list
     * of employees
     * 
     * @param employee 
     */
    public synchronized void removeEmployee(Employee employee){
        if(employees != null && employees.contains(employee)){
            employees.remove(employee);
        }
    }
    
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash += (name == null ? 1 : name.hashCode()) * hash;
        hash += (fax == null ? 1 : fax.hashCode()) * hash;
        hash += (website == null ? 1 : website.hashCode()) * hash;
        hash += (address == null ? 1 : address.hashCode()) * hash;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof School)) {
            return false;
        }
        School other = (School) object;
        return (name == null ? other.getName() == null : name.equals(other.getName()))
                && (fax == null ? other.getFax() == null : fax.equals(other.getFax()))
                && (website == null ? other.getWebsite() == null : website.equals(other.getWebsite()))
                && (address == null ? other.getAddress() == null : address.equals(other.getAddress()));
    }

    @Override
    public String toString() {
        return "School#"+ getId() +"[ name=" + name + ", website="+ website +", fax="+ fax + ", address="+ address + " ]";
    }
}
