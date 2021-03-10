package com.Arriendo.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Hosting")
public class Hosting {

	@Id
	private String uid;
	private String userProfileUrl;
	private String fullName;
	private String mobile;
	private String description;
	private int totalVehicles;
	private int fees;
	
    // ********* for files ********

	@Transient
    private MultipartFile aadharFile;
    private String aadharFileUri;

    @Transient
    private MultipartFile residentialFile;
    private String residentialFileUri;

    @Transient
    private MultipartFile parkingPhoto;
    private String parkingPhotoUri;
	
    public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUserProfileUrl() {
		return userProfileUrl;
	}
	public void setUserProfileUrl(String userProfileUrl) {
		this.userProfileUrl = userProfileUrl;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTotalVehicles() {
		return totalVehicles;
	}
	public void setTotalVehicles(int totalVehicles) {
		this.totalVehicles = totalVehicles;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public MultipartFile getAadharFile() {
		return aadharFile;
	}
	public void setAadharFile(MultipartFile aadharFile) {
		this.aadharFile = aadharFile;
	}
	public String getAadharFileUri() {
		return aadharFileUri;
	}
	public void setAadharFileUri(String aadharFileUri) {
		this.aadharFileUri = aadharFileUri;
	}
	public MultipartFile getResidentialFile() {
		return residentialFile;
	}
	public void setResidentialFile(MultipartFile residentialFile) {
		this.residentialFile = residentialFile;
	}
	public String getResidentialFileUri() {
		return residentialFileUri;
	}
	public void setResidentialFileUri(String residentialFileUri) {
		this.residentialFileUri = residentialFileUri;
	}
	public MultipartFile getParkingPhoto() {
		return parkingPhoto;
	}
	public void setParkingPhoto(MultipartFile parkingPhoto) {
		this.parkingPhoto = parkingPhoto;
	}
	public String getParkingPhotoUri() {
		return parkingPhotoUri;
	}
	public void setParkingPhotoUri(String parkingPhotoUri) {
		this.parkingPhotoUri = parkingPhotoUri;
	}

	@Override
	public String toString() {
		return "Hosting [uid=" + uid + ", userProfileUrl=" + userProfileUrl + ", fullName=" + fullName + ", mobile="
				+ mobile + ", description=" + description + ", totalVehicles=" + totalVehicles + ", fees=" + fees
				+ ", aadharFile=" + aadharFile + ", aadharFileUri=" + aadharFileUri + ", residentialFile="
				+ residentialFile + ", residentialFileUri=" + residentialFileUri + ", parkingPhoto=" + parkingPhoto
				+ ", parkingPhotoUri=" + parkingPhotoUri + "]";
	}
	
}
