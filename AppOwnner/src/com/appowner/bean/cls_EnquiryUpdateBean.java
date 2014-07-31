package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import com.appowner.model.cls_Person;
import com.appowner.service.cls_PersonService;
@ManagedBean
@SessionScoped
public class cls_EnquiryUpdateBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{cls_PersonService}")
	private cls_PersonService personService;
	private List<String> enquiry_selecteCities;
	public cls_PersonService getPersonService() {
		
		return personService;
	}
	public void setPersonService(cls_PersonService personService) {
		this.personService = personService;
	}
	
	public List<String> getEnquiry_selecteCities() {
		if(enquiry_selectedState!=null)
		   {
			   return cityListByState;
		   }
		   else
			   
			   return new ArrayList<String>();

		
	}
	public void setEnquiry_selecteCities(List<String> enquiry_selecteCities) {
		this.enquiry_selecteCities = enquiry_selecteCities;
	}
	
	public void setEnquiry_selectedCountries(List<String> enquiry_selectedCountries) {
		this.enquiry_selectedCountries = enquiry_selectedCountries;
	}



	private String enquiry_selectedState;
	private String enquiry_selectedCountry;
	private String enquiry_selectedCity;
    private List<String> cityList;
    private List<String> stateList;
    private List<String> countryList;
    private List<String> enquiry_selectedCountries;
   
	private List<String> enquiry_selectedStates;
	private ArrayList<String> stateListByCountry;
    
   
    public List<String> getCountryList() {
		return countryList;
	}
	public void setCountryList(List<String> countryList) {
		this.countryList = countryList;
	}

	public ArrayList<String> getStateListByCountry() {
		return stateListByCountry;
	}
	public void setStateListByCountry(ArrayList<String> stateListByCountry) {
		this.stateListByCountry = stateListByCountry;
	}

	
    
	public String getEnquiry_selectedState() {
		return enquiry_selectedState;
	}
	public void setEnquiry_selectedState(String enquiry_selectedState) {
		this.enquiry_selectedState = enquiry_selectedState;
	}
	public void setEnquiry_selectedStates(List<String> enquiry_selectedStates) {
		this.enquiry_selectedStates = enquiry_selectedStates;
	}
	public List<String> getCityList() {
		return cityList;
	}
	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}
	public List<String> getStateList() {
		stateList=new ArrayList<String>();
		stateList.addAll(getPersonService().getStateList());
		return stateList;
	}
	public void setStateList(List<String> stateList) {
		this.stateList = stateList;
	}

	public String getEnquiry_selectedCountry() {
		return enquiry_selectedCountry;
	}
	public void setEnquiry_selectedCountry(String enquiry_selectedCountry) {
		this.enquiry_selectedCountry = enquiry_selectedCountry;
	}
	
	public String getEnquiry_selectedCity() {
		return enquiry_selectedCity;
	}
	public void setEnquiry_selectedCity(String enquiry_selectedCity) {
		this.enquiry_selectedCity = enquiry_selectedCity;
	}
	public List<String> getCityListByState() {
		return cityListByState;
	}
	
	 public String getenquiry_selectedState() {
		 
		   return enquiry_selectedState;
	   }
	   public void setenquiry_selectedState(String enquiry_selectedState) {
		   this.enquiry_selectedState=enquiry_selectedState;
	   }
	   private List<String> cityListByState;
	  /* public List<String> getCityListByState() {
		   cityListByState=new ArrayList<String>();
		   cityListByState.addAll(getPersonService().cityList());
		return cityListByState;
		   		}*/
		public void setCityListByState(List<String> cityListByStates) {
			this.cityListByState= cityListByStates;
		}
	   private List<String>  stateByCountry;
	   
	   public List<String> getStateByCountry() {
		  
		return stateByCountry;
	}
	public void setStateByCountry(List<String> stateByCountry) {
		this.stateByCountry = stateByCountry;
	}
	public List<String> countryChangeListener(ValueChangeEvent event) {
		enquiry_selectedCountry = (String) event.getNewValue();
		   stateByCountry  = new ArrayList<String>();
		   stateByCountry.addAll(getPersonService().stateList(enquiry_selectedCountry));
          System.out.println(stateByCountry);
			return stateByCountry;
		}
	public List<String> stateChangeListener(ValueChangeEvent event)
	{  System.out.println("kalpana");
          enquiry_selectedState=(String)event.getNewValue();
          System.out.println(enquiry_selectedState);
			cityListByState=new ArrayList<String>();
			cityListByState.addAll(getPersonService().cityList1(enquiry_selectedState));
               System.out.println(cityListByState);
               return cityListByState;
		}
		 
	
	   
	   public List<String> getEnquiry_selectedCountries() {

			enquiry_selectedCountries = new ArrayList<String>();
			enquiry_selectedCountries.addAll(getPersonService().countryList());
			System.out.println(enquiry_selectedCountries);
			return enquiry_selectedCountries;
		}
	   
	  public List<String> getEnquiry_selectedCities() {
		    
			if ((enquiry_selectedState!=null)) {

				return cityListByState;
			} else
				return new ArrayList<String>();
		} 
	  
	   
	   public List<String> getEnquiry_selectedStates() {
		   if(enquiry_selectedCountry!=null)
		   {
			   return stateByCountry;
			} else
				return new ArrayList<String>();

		}
	private cls_Person person;
	public cls_Person getperson() {
		return person;
	}
	public void setperson(cls_Person person) {
		this.person = person;
	}
	 
private String personId;
	
	public String getpersonId() {
	return personId;
}
public void setpersonId(String personId) {
	this.personId = personId;
}
	public void getPerson()
	{ person=new cls_Person();
		System.out.println(personId);
		person=getPersonService().getPerson(personId);
		}
	public String savePerson( ) {
		 
	
		if(person.getPersonId()!=null)
	
			getPersonService().update(person);
		else		
			getPersonService().addPerson(person);
		
		
		
		return "ViewEnquiry.xhtml?faces-redirect=true";
	}

}