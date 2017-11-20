package com.facear.myemployee.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.facear.myemployee.model.Contract_agreement;
import com.facear.myemployee.model.Employee;
import com.facear.myemployee.model.Employer;
import com.facear.myemployee.model.Holerite;
import com.facear.myemployee.service.EmployeeService;
import com.facear.myemployee.service.HoleriteService;


@ManagedBean(name = "employeeHoleriteMB")
@SessionScoped
public class EmployeeHoleriteMB implements Serializable{

	private static final long serialVersionUID = -9004785433894347006L;	

	private Holerite holerite;
	private Employee employee;
	private Employer employer;
	private Contract_agreement contract;
	
	private List<Holerite> listHolerite;
	
	private HoleriteService service;
	
	public EmployeeHoleriteMB() throws ClassNotFoundException, IOException, SQLException
	{
		service = new HoleriteService();
		
		contract = new Contract_agreement(0, employer, employee, null, 0.00, null, null, 0);
		holerite = new Holerite(0, employer, employee, contract, null, null, null, null, null, null);
		
		/*return list holerite*/
		listHolerite = service.listAll();
	
	}
	
	public Holerite getHolerite() {
		return holerite;
	}

	public void setHolerite(Holerite holerite) {
		this.holerite = holerite;
	}

	public List<Holerite> getListHolerite() {
		return listHolerite;
	}

	public void setListHolerite(List<Holerite> listHolerite) {
		listHolerite = listHolerite;
	}

}
