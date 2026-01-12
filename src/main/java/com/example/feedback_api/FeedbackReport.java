package com.example.feedback_api;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "feedback_reports")
public class FeedbackReport {

    @Id
    private String id;

    @NotBlank
    private String userText;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer rating;

    @NotBlank
    private String featureTag;

    private String deviceModel;
    private String osVersion;
    private String screenshotBase64;
    private String country;
    private int userAge;
    private String userGender;
    private Instant createdAt = Instant.now();

    public FeedbackReport() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserText() { return userText; }
    public void setUserText(String userText) { this.userText = userText; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getFeatureTag() { return featureTag; }
    public void setFeatureTag(String featureTag) { this.featureTag = featureTag; }

    public String getDeviceModel() { return deviceModel; }
    public void setDeviceModel(String deviceModel) { this.deviceModel = deviceModel; }

    public String getOsVersion() { return osVersion; }
    public void setOsVersion(String osVersion) { this.osVersion = osVersion; }

    public String getScreenshotBase64() { return screenshotBase64; }
    public void setScreenshotBase64(String screenshotBase64) { this.screenshotBase64 = screenshotBase64; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public int getUserAge() { return userAge; }
    public void setUserAge(int userAge) { this.userAge = userAge; }

    public String getUserGender() { return userGender; }
    public void setUserGender(String userGender) { this.userGender = userGender; }
}
