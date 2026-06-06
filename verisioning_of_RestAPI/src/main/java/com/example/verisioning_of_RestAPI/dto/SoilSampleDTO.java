package com.example.verisioning_of_RestAPI.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SoilSampleDTO {

    private Long sampleID;
    private String sampleName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date sampleCollectionDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date sampleTestDate;

    public Long getSampleID() {
        return sampleID;
    }

    public void setSampleID(Long sampleID) {
        this.sampleID = sampleID;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public Date getSampleCollectionDate() {
        return sampleCollectionDate;
    }

    public void setSampleCollectionDate(Date sampleCollectionDate) {
        this.sampleCollectionDate = sampleCollectionDate;
    }

    public Date getSampleTestDate() {
        return sampleTestDate;
    }

    public void setSampleTestDate(Date sampleTestDate) {
        this.sampleTestDate = sampleTestDate;
    }

    @Override
    public String toString() {
        return "SoilSampleDTO{" +
                "sampleID=" + sampleID +
                ", sampleName='" + sampleName + '\'' +
                ", sampleCollectionDate=" + sampleCollectionDate +
                ", sampleTestDate=" + sampleTestDate +
                '}';
    }
}
