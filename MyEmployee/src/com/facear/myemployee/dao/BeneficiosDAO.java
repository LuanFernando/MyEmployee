package com.facear.myemployee.dao;

public class BeneficiosDAO {
	
	public double transporte(double salarioBase)
	{
		double transporte  = 0.00;
		
		transporte = salarioBase * 0.06;
		if(transporte<=110)
		{	
			transporte = transporte;
		}else if(transporte>=120)
		{
			transporte = 110;
		}
		return transporte;
	}
}
