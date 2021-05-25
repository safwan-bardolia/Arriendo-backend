package com.Arriendo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class MyBooking {

	@Id
	private String c_uid;
	private String email;
	private String userProfileUrl;
	
	private String date;
	private String checkInTime;
	private String checkOutTime;
	
	private String fullName;
	private String mobile;
	private String carType;
	private String carNumber;
	private String licenseNumber;
	
	private String confirmation="false";
	private String final_confirmation="false";
	
	// map to Hosting & HostingLocation	
	private String host_uid;
	
    // ********* for files ********

    @Transient
    private MultipartFile licensePhoto;
    private String licensePhotoUri;

    @Transient
    private MultipartFile rcPhoto;
    private String rcPhotoUri;
	public String getC_uid() {
		return c_uid;
	}
	public void setC_uid(String c_uid) {
		this.c_uid = c_uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserProfileUrl() {
		return userProfileUrl;
	}
	public void setUserProfileUrl(String userProfileUrl) {
		this.userProfileUrl = userProfileUrl;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	public String getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getConfirmation() {
		return confirmation;
	}
	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
	public String getFinal_confirmation() {
		return final_confirmation;
	}
	public void setFinal_confirmation(String final_confirmation) {
		this.final_confirmation = final_confirmation;
	}
	public String getHost_uid() {
		return host_uid;
	}
	public void setHost_uid(String host_uid) {
		this.host_uid = host_uid;
	}
	public MultipartFile getLicensePhoto() {
		return licensePhoto;
	}
	public void setLicensePhoto(MultipartFile licensePhoto) {
		this.licensePhoto = licensePhoto;
	}
	public String getLicensePhotoUri() {
		return licensePhotoUri;
	}
	public void setLicensePhotoUri(String licensePhotoUri) {
		this.licensePhotoUri = licensePhotoUri;
	}
	public MultipartFile getRcPhoto() {
		return rcPhoto;
	}
	public void setRcPhoto(MultipartFile rcPhoto) {
		this.rcPhoto = rcPhoto;
	}
	public String getRcPhotoUri() {
		return rcPhotoUri;
	}
	public void setRcPhotoUri(String rcPhotoUri) {
		this.rcPhotoUri = rcPhotoUri;
	}
	@Override
	public String toString() {
		return "MyBooking [c_uid=" + c_uid + ", email=" + email + ", userProfileUrl=" + userProfileUrl + ", date="
				+ date + ", checkInTime=" + checkInTime + ", checkOutTime=" + checkOutTime + ", fullName=" + fullName
				+ ", mobile=" + mobile + ", carType=" + carType + ", carNumber=" + carNumber + ", licenseNumber="
				+ licenseNumber + ", confirmation=" + confirmation + ", final_confirmation=" + final_confirmation
				+ ", host_uid=" + host_uid + ", licensePhoto=" + licensePhoto + ", licensePhotoUri=" + licensePhotoUri
				+ ", rcPhoto=" + rcPhoto + ", rcPhotoUri=" + rcPhotoUri + ", getC_uid()=" + getC_uid() + ", getEmail()="
				+ getEmail() + ", getUserProfileUrl()=" + getUserProfileUrl() + ", getDate()=" + getDate()
				+ ", getCheckInTime()=" + getCheckInTime() + ", getCheckOutTime()=" + getCheckOutTime()
				+ ", getFullName()=" + getFullName() + ", getMobile()=" + getMobile() + ", getCarType()=" + getCarType()
				+ ", getCarNumber()=" + getCarNumber() + ", getLicenseNumber()=" + getLicenseNumber()
				+ ", getConfirmation()=" + getConfirmation() + ", getFinal_confirmation()=" + getFinal_confirmation()
				+ ", getHost_uid()=" + getHost_uid() + ", getLicensePhoto()=" + getLicensePhoto()
				+ ", getLicensePhotoUri()=" + getLicensePhotoUri() + ", getRcPhoto()=" + getRcPhoto()
				+ ", getRcPhotoUri()=" + getRcPhotoUri() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
    
    

}
