package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import org.springframework.dao.DataAccessException;

import com.appowner.model.cls_Person;
import com.appowner.service.cls_PersonService;
@ManagedBean
@SessionScoped

public class Cls_EnquiryBean implements Serializable {
	private static final long serialVersionUID = 1L;
	  private static final String SUCCESS = "success";
	    private static final String ERROR   = "error";
	    private String personEmail;
	    private String personMessage;
	    private String personAddress;
	    private String personPhone;
	    private String personCountry;
	    private String personState;
	    private String personCity;
	    public String getPersonCountry() {
			return personCountry;
		}
		public void setPersonCountry(String personCountry) {
			this.personCountry = personCountry;
		}
		public String getPersonState() {
			return personState;
		}
		public void setPersonState(String personState) {
			this.personState = personState;
		}
		public String getPersonCity() {
			return personCity;
		}
		public void setPersonCity(String personCity) {
			this.personCity = personCity;
		}



		private ArrayList<String> stateListByCountry;
	    private String enquiry_zip;
	    private List<cls_Person> personList;
		 
		private List<String> enquiry_selecteCities;
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
		public List<cls_Person> getPersonList() {
			return personList;
		}
		public void setPersonList(List<cls_Person> personList) {
			this.personList = personList;
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

		
	
	    
	public String getEnquiry_zip() {
			return enquiry_zip;
		}
		public void setEnquiry_zip(String enquiry_zip) {
			this.enquiry_zip = enquiry_zip;
		}
	public String getEnquiry_selectedCity() {
			return enquiry_selectedCity;
		}
		public void setEnquiry_selectedCity(String enquiry_selectedCity) {
			this.enquiry_selectedCity = enquiry_selectedCity;
		}
	public String getPersonMessage() {
		   return personMessage;
	   }
	   public void setPersonMessage(String personMessage) {
		   this.personMessage=personMessage;
	   }
	    
	    public String getPersonEmail() {
			return personEmail;
		}
		public void setPersonEmail(String personEmail) {
			this.personEmail = personEmail;
		}
		
		 public String getPersonPhone() {
			return personPhone;
		}
		public void setPersonPhone(String personPhone) {
			this.personPhone = personPhone;
		}
		public String getPersonAddress() {
				return personAddress;
			}
			public List<String> getCityListByState() {
			return cityListByState;
		}
			public void setPersonAddress(String personAddress) {
				this.personAddress = personAddress;
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



		@ManagedProperty(value="#{cls_PersonService}")
		private cls_PersonService personService;
		
		public cls_PersonService getPersonService() {
			return personService;
		}
		public void setPersonService(cls_PersonService personService) {
			this.personService = personService;
		}
		public String addPerson()
		{  
			try{
			 cls_Person person=new cls_Person();
			 person.setPersonId(getPersonId());
			 person.setPersonName(getPersonName());
			 person.setPersonEmail(getPersonEmail());
			 person.setPersonPhone(getPersonPhone());
			 person.setPersonCountry(getPersonCountry());
			 person.setPersonState(getPersonState());
			 person.setPersonCity(getPersonCity());
			 person.setPersonZip(getPersonZip());
			 person.setPersonMessage(getPersonMessage());
			 getPersonService().addPerson(person);
		
			 return SUCCESS;
		}
		catch(DataAccessException e)
		{e.printStackTrace();
			
		}
		return ERROR;
			
		}
		private String getPersonZip() {
			return null;
		}
		public String deletePerson(int PersonId)
		 {
			 cls_Person person=new cls_Person();
			 
			 person.setPersonId(PersonId);
			
			 getPersonService().deletePerson(person);
			 return SUCCESS;
		 }
		
		private List<cls_Person> ListPerson;
		public List<cls_Person> getListPerson() {
			ListPerson= new ArrayList<cls_Person>();
				ListPerson.addAll(getPersonService().listPersons());
			
			return ListPerson;
		}
		public void setListPerson(List<cls_Person> listPerson) {
			ListPerson = listPerson;
		}
		
		private int personId;
		public int getPersonId() {
			return personId;
		}
		public void setPersonId(int personId) {
			this.personId = personId;
		}
		private String personName;
		
		public void setPersonName(String personName) {
			this.personName = personName;
		}
		
		public String getPersonName() {
			return personName;
		}
		public void reset() {
	        this.setPersonId(0);
	        this.setPersonName("");
	        
	    }


}
