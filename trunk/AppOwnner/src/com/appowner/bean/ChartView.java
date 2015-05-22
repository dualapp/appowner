package com.appowner.bean;
 
import javax.annotation.PostConstruct;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import org.apache.xerces.impl.dv.xs.MonthDV;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

import com.appowner.model.InvoiceTransaction;
 
@ManagedBean
public class ChartView implements Serializable {
 
    private LineChartModel lineModel1;
    
     
 /*   @PostConstruct
    public void init() {
    	
        createLineModels();
    }*/
  public  ChartView()
  {
	  createLineModels();
  }
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
    private static String indicate="";
    

	public static String getIndicate() {
		return indicate;
	}

	public static void setIndicate(String indicate) {
		ChartView.indicate = indicate;
	}

	public void month(int no)
    {  System.out.println(no+"jgvjjgfhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
    if(no==1)
    {
		indicate="day";
		
    }
    else if(no==2)
    {
    	indicate="week";
    	
    }
    else
    {   System.out.println("fgjkggfkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
    	indicate="month";
    }
    createLineModels();
    }
    
     
    private void createLineModels() {
        lineModel1 =  initLinearModel();
        lineModel1.setTitle("Linear Chart");
        System.out.println(indicate+"vgjfjfjffgjfjgfjf");
        if(indicate.isEmpty() || indicate.equalsIgnoreCase("day"))
        {
        	DateAxis axis = new DateAxis("Dates");
        	
          axis.setMin("2014-01-10");
            axis.setMax("2014-02-01");
            axis.setTickFormat("%b %#d, %y");
            lineModel1.getAxes().put(AxisType.X, axis);
          
        }
        else if(indicate.equalsIgnoreCase("month"))
        {
        	System.out.println("fhhujjhfggfgfgfgfgggfgffg"); 
            
        	lineModel1.getAxes().put(AxisType.X, new CategoryAxis("Months"));
        }
        else
        {
        	lineModel1.getAxes().put(AxisType.X, new CategoryAxis("Weeks"));
        }
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setLabel("No. Of Apartment Registered");
        yAxis.setMin(0);
        yAxis.setMax(30);
       
      
    }
     
   
	private LineChartModel initLinearModel() {
    	LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
        Map<Object, Number> data =new LinkedHashMap<Object, Number>();
        if(indicate.isEmpty()|| indicate.equalsIgnoreCase("day"))
        {  System.out.println("fhjgfjfffgfggfggghgh");
        	data.put("2014-01-01", 2);
            data.put("2014-01-06", 12);
            data.put("2014-01-12", 19);
            data.put("2014-01-18", 12);
            data.put("2014-01-24", 6);
            data.put("2014-01-30", 7);
        }
        else if(indicate.equalsIgnoreCase("month"))
        {  System.out.println("jjgjfgfgfgggghhgggg");
        	data.put("jan", 3);
            data.put("feb", 9);
            data.put("Mar", 13);
            data.put("Apr", 12);
            data.put("May", 15);
            data.put("Jun", 20);
            data.put("Jul", 16);
            data.put("Aug", 2);
            data.put("Sep", 4);
            data.put("Oct", 6);
            data.put("Nov", 10);
            data.put("Dec", 18);
            
        }
        else
        {  System.out.println("fhjhgjgfvjjgfjgfjgfjgfjgfjgfjgfj");
        	data.put("Sun", 3);
        	data.put("Mon", 13);
        	data.put("Tue", 15);
        	data.put("Wed", 20);
        	data.put("Thu", 26);
        	data.put("Fri", 27);
        	data.put("Sat", 7);
        }
		series1.setData(data);
        
 
        
 
        model.addSeries(series1);
       
         
        return  model;
    }
     
	
	
	 
 
}