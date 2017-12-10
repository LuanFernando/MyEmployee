package com.facear.myemployee.dao;

public class ImpostosDAO {
	double inss = 0.00;
	
	
	public double Calculoinss(double salarioBase)
	{
		
	
		if(salarioBase <= 1659.38)
		{
			inss =  salarioBase * 0.08;
		}else if(salarioBase > 1659.38 && salarioBase <= 2765.66)
		{
			inss =  salarioBase * 0.09;
		}else if(salarioBase > 2765.66 && salarioBase <= 5531.31)
		{
			inss =  salarioBase * 0.11;
		}else if(salarioBase > 5531.31){
			inss =  salarioBase * 0.11;
			
			if(inss >= 608.45)
			{
				inss = 608.45;
			}
			
		}
		
		return inss;
	}
	
	public double Calculoirrf(double salarioBase)
	{
		double irrf = 0.00;
		

		return irrf ;
	}
}
