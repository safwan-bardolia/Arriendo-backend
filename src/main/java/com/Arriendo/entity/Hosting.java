package com.Arriendo.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
    private String aadharFileName;
    private String aadharFileType;
    @Lob
    private byte[] aadharFileData;

    @Transient
    private MultipartFile residentialFile;
    private String residentialFileName;
    private String residentialFileType;
    @Lob
    private byte[] residentialFileData;

    @Transient
    private MultipartFile parkingPhoto;
    private String parkingPhotoName;
    private String parkingPhotoType;
    @Lob
    private byte[] parkingPhotoData;
    
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public String getAadharFileName() {
		return aadharFileName;
	}
	public void setAadharFileName(String aadharFileName) {
		this.aadharFileName = aadharFileName;
	}
	public String getAadharFileType() {
		return aadharFileType;
	}
	public void setAadharFileType(String aadharFileType) {
		this.aadharFileType = aadharFileType;
	}
	public byte[] getAadharFileData() {
		return aadharFileData;
	}
	public void setAadharFileData(byte[] aadharFileData) {
		this.aadharFileData = aadharFileData;
	}
	public MultipartFile getResidentialFile() {
		return residentialFile;
	}
	public void setResidentialFile(MultipartFile residentialFile) {
		this.residentialFile = residentialFile;
	}
	public String getResidentialFileName() {
		return residentialFileName;
	}
	public void setResidentialFileName(String residentialFileName) {
		this.residentialFileName = residentialFileName;
	}
	public String getResidentialFileType() {
		return residentialFileType;
	}
	public void setResidentialFileType(String residentialFileType) {
		this.residentialFileType = residentialFileType;
	}
	public byte[] getResidentialFileData() {
		return residentialFileData;
	}
	public void setResidentialFileData(byte[] residentialFileData) {
		this.residentialFileData = residentialFileData;
	}
	public MultipartFile getParkingPhoto() {
		return parkingPhoto;
	}
	public void setParkingPhoto(MultipartFile parkingPhoto) {
		this.parkingPhoto = parkingPhoto;
	}
	public String getParkingPhotoName() {
		return parkingPhotoName;
	}
	public void setParkingPhotoName(String parkingPhotoName) {
		this.parkingPhotoName = parkingPhotoName;
	}
	public String getParkingPhotoType() {
		return parkingPhotoType;
	}
	public void setParkingPhotoType(String parkingPhotoType) {
		this.parkingPhotoType = parkingPhotoType;
	}
	public byte[] getParkingPhotoData() {
		return parkingPhotoData;
	}
	public void setParkingPhotoData(byte[] parkingPhotoData) {
		this.parkingPhotoData = parkingPhotoData;
	}
	public String getUserProfileUrl() {
		return userProfileUrl;
	}
	public void setUserProfileUrl(String userProfileUrl) {
		this.userProfileUrl = userProfileUrl;
	}

	@Override
	public String toString() {
		return "Hosting [uid=" + uid + ", userProfileUrl=" + userProfileUrl + ", fullName=" + fullName + ", mobile="
				+ mobile + ", description=" + description + ", totalVehicles=" + totalVehicles + ", fees=" + fees
				+ ", aadharFile=" + aadharFile + ", aadharFileName=" + aadharFileName + ", aadharFileType="
				+ aadharFileType + ", aadharFileData=" + Arrays.toString(aadharFileData) + ", residentialFile="
				+ residentialFile + ", residentialFileName=" + residentialFileName + ", residentialFileType="
				+ residentialFileType + ", residentialFileData=" + Arrays.toString(residentialFileData)
				+ ", parkingPhoto=" + parkingPhoto + ", parkingPhotoName=" + parkingPhotoName + ", parkingPhotoType="
				+ parkingPhotoType + ", parkingPhotoData=" + Arrays.toString(parkingPhotoData) + "]";
	}
    
    

}
