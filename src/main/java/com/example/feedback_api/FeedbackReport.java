package com.example.feedback_api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "feedbacks") 
public class FeedbackReport {

    @Id
    private String id;

    private String userText;
    private int rating;
    private String featureTag;
    private String deviceModel;
    private String osVersion;
    private String screenshotBase64; // נשמור את התמונה כטקסט מוצפן
    private String country;

    // Getters and Setters 
    public String getUserText() { return userText; }
    public void setUserText(String userText) { this.userText = userText; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String getFeatureTag() { return featureTag; }
    public void setFeatureTag(String featureTag) { this.featureTag = featureTag; }
    public String getDeviceModel() { return deviceModel; }
    public void setDeviceModel(String deviceModel) { this.deviceModel = deviceModel; }
    public String getOsVersion() { return osVersion; }
    public void setOsVersion(String osVersion) { this.osVersion = osVersion; }
    public String getScreenshotBase64() { return screenshotBase64; }
    public void setScreenshotBase64(String screenshotBase64) { this.screenshotBase64 = screenshotBase64; }
    public String getId() { return id; }
    public void setId(String id) {this.id = id; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
}
