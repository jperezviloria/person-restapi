package com.home.core.dto.request;


public class JobRequestDTO {

    private String idJob;
    private String nameJob;
    private String imageUrl;
    private String imageId;
    private int priceJob;
    private String descriptionJob;

    public JobRequestDTO(String idJob, String nameJob, String imageUrl, String imageId, int priceJob, String descriptionJob) {
        this.idJob = idJob;
        this.nameJob = nameJob;
        this.imageUrl = imageUrl;
        this.imageId = imageId;
        this.priceJob = priceJob;
        this.descriptionJob = descriptionJob;
    }

    public String getIdJob() {
        return idJob;
    }

    public void setIdJob(String idJob) {
        this.idJob = idJob;
    }

    public String getNameJob() {
        return nameJob;
    }

    public void setNameJob(String nameJob) {
        this.nameJob = nameJob;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public int getPriceJob() {
        return priceJob;
    }

    public void setPriceJob(int priceJob) {
        this.priceJob = priceJob;
    }

    public String getDescriptionJob() {
        return descriptionJob;
    }

    public void setDescriptionJob(String descriptionJob) {
        this.descriptionJob = descriptionJob;
    }
}