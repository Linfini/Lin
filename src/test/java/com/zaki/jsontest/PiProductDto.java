package com.zaki.jsontest;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class PiProductDto {
    private String name;

    private String code;

    private Long piStoreId;


    private String marker;

    private String piece;

    private Long piProductTypeId;

    private Long piProductLineId;


    private String barcode;

    private Long departmentId;

    private String picture;

    private Long lowlimit;

    private String inventoryPlan;


    private Double shapeLength;


    private Double shapeWidth;

    private Double shapeHeight;


    private Double grossWeight;


    private Double weight;

    private Boolean activeFlag;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String remark;

    private Double cost; //成本价

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getPiStoreId() {
        return piStoreId;
    }

    public void setPiStoreId(Long piStoreId) {
        this.piStoreId = piStoreId;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public Long getPiProductTypeId() {
        return piProductTypeId;
    }

    public void setPiProductTypeId(Long piProductTypeId) {
        this.piProductTypeId = piProductTypeId;
    }

    public Long getPiProductLineId() {
        return piProductLineId;
    }

    public void setPiProductLineId(Long piProductLineId) {
        this.piProductLineId = piProductLineId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Long getLowlimit() {
        return lowlimit;
    }

    public void setLowlimit(Long lowlimit) {
        this.lowlimit = lowlimit;
    }

    public String getInventoryPlan() {
        return inventoryPlan;
    }

    public void setInventoryPlan(String inventoryPlan) {
        this.inventoryPlan = inventoryPlan;
    }

    public Double getShapeLength() {
        return shapeLength;
    }

    public void setShapeLength(Double shapeLength) {
        this.shapeLength = shapeLength;
    }

    public Double getShapeWidth() {
        return shapeWidth;
    }

    public void setShapeWidth(Double shapeWidth) {
        this.shapeWidth = shapeWidth;
    }

    public Double getShapeHeight() {
        return shapeHeight;
    }

    public void setShapeHeight(Double shapeHeight) {
        this.shapeHeight = shapeHeight;
    }

    public Double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }



    private PiProductType piProductType;

    private PiProductLine piProductLine;
    private Department department;
    private MultipartFile fBarCode;
    private MultipartFile fPicture;
    private String departmentName;

    public PiProductType getPiProductType() {
        return piProductType;
    }

    public void setPiProductType(PiProductType piProductType) {
        this.piProductType = piProductType;
    }

    public PiProductLine getPiProductLine() {
        return piProductLine;
    }

    public void setPiProductLine(PiProductLine piProductLine) {
        this.piProductLine = piProductLine;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public MultipartFile getfBarCode() {
        return fBarCode;
    }

    public void setfBarCode(MultipartFile fBarCode) {
        this.fBarCode = fBarCode;
    }

    public MultipartFile getfPicture() {
        return fPicture;
    }

    public void setfPicture(MultipartFile fPicture) {
        this.fPicture = fPicture;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "PiProductDto{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", piStoreId=" + piStoreId +
                ", marker='" + marker + '\'' +
                ", piece='" + piece + '\'' +
                ", piProductTypeId=" + piProductTypeId +
                ", piProductLineId=" + piProductLineId +
                ", barcode='" + barcode + '\'' +
                ", departmentId=" + departmentId +
                ", picture='" + picture + '\'' +
                ", lowlimit=" + lowlimit +
                ", inventoryPlan='" + inventoryPlan + '\'' +
                ", shapeLength=" + shapeLength +
                ", shapeWidth=" + shapeWidth +
                ", shapeHeight=" + shapeHeight +
                ", grossWeight=" + grossWeight +
                ", weight=" + weight +
                ", activeFlag=" + activeFlag +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                ", cost=" + cost +
                '}';
    }
}
