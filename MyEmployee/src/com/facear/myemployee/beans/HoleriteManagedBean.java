package com.facear.myemployee.beans;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.facear.myemployee.model.Holerite;
import com.facear.myemployee.service.HoleriteService;

@ManagedBean(name = "HoleriteManagedBean")
@SessionScoped
public class HoleriteManagedBean implements Serializable
{
	private static final long serialVersionUID = -9004785433894347006L;	

	private Holerite holerite;
	private List<Holerite> ListHolerite;
	private HoleriteService service;

	public HoleriteManagedBean()
	{
		service = new HoleriteService();
		holerite = new Holerite(0, null, null, null, null);
		/*ListHolerite = service.listAll();*/
	}
	
	/*Method de insert*/
	public Holerite insertHolerite()
	{
		service.insertHolerite(holerite);
		holerite = new Holerite(0, null, null, null, null);
		/*ListHolerite = service.listAll();*/
		return null;
	}
	

	/*Gets and Sets*/
	public Holerite getHolerite() {
		return holerite;
	}

	public void setHolerite(Holerite holerite) {
		this.holerite = holerite;
	}

	public List<Holerite> getListHolerite() {
		return ListHolerite;
	}

	public void setListHolerite(List<Holerite> listHolerite) {
		ListHolerite = listHolerite;
	}
	
}
