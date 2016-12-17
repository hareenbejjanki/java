package com.bhirava.ovilearning.bean;

import java.util.Date;

public class User {

    private String password;
    
    private String phone;

    private String OTP_token;

    private String state;

    private String u_demo;

    private String ticketit_agent;

    private String city;

    private long id;

    private String first_name;

    private String username;

    private String institute_name;

    private String name;

    private String contact_name;

    private String[] permissions;

    private String created_at;

    private String gender;

    private String first_login;

    private String postal;

    private Date deleted_at;

    private String device_id;

    private String pic;

    private LastLogin last_login;

    private String country;

    private String updated_at;

    private String bio;

    private String jwt_token;

    private String email;

    private String address;

    private String ticketit_admin;

    private String dob;

    private String last_name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOTP_token() {
		return OTP_token;
	}

	public void setOTP_token(String oTP_token) {
		OTP_token = oTP_token;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getU_demo() {
		return u_demo;
	}

	public void setU_demo(String u_demo) {
		this.u_demo = u_demo;
	}

	public String getTicketit_agent() {
		return ticketit_agent;
	}

	public void setTicketit_agent(String ticketit_agent) {
		this.ticketit_agent = ticketit_agent;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getInstitute_name() {
		return institute_name;
	}

	public void setInstitute_name(String institute_name) {
		this.institute_name = institute_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public String[] getPermissions() {
		return permissions;
	}

	public void setPermissions(String[] permissions) {
		this.permissions = permissions;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirst_login() {
		return first_login;
	}

	public void setFirst_login(String first_login) {
		this.first_login = first_login;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public Date getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public LastLogin getLast_login() {
		return last_login;
	}

	public void setLast_login(LastLogin last_login) {
		this.last_login = last_login;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getJwt_token() {
		return jwt_token;
	}

	public void setJwt_token(String jwt_token) {
		this.jwt_token = jwt_token;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTicketit_admin() {
		return ticketit_admin;
	}

	public void setTicketit_admin(String ticketit_admin) {
		this.ticketit_admin = ticketit_admin;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	@Override
    public String toString()
    {
        return "User [phone = "+phone+", OTP_token = "+OTP_token+", state = "+state+", u_demo = "+u_demo+", ticketit_agent = "+ticketit_agent+", city = "+city+", id = "+id+", first_name = "+first_name+", username = "+username+", institute_name = "+institute_name+", name = "+name+", contact_name = "+contact_name+", permissions = "+permissions+", created_at = "+created_at+", gender = "+gender+", first_login = "+first_login+", postal = "+postal+", deleted_at = "+deleted_at+", device_id = "+device_id+", pic = "+pic+", last_login = "+last_login+", country = "+country+", updated_at = "+updated_at+", bio = "+bio+", jwt_token = "+jwt_token+", email = "+email+", address = "+address+", ticketit_admin = "+ticketit_admin+", dob = "+dob+", last_name = "+last_name+"]";
    }

}
