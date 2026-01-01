package com.example.feedback_api;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Entity
@Table(name = "feedback_reports")
public class FeedbackReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 4000)
    private String userText;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer rating;

    @NotBlank
    @Column(length = 255)
    private String featureTag;

    @Column(length = 255)
    private String deviceModel;

    @Column(length = 50)
    private String osVersion;

    // IMPORTANT: screenshot can be large, so store as LOB (TEXT / CLOB)
    @Lob
    @Column(columnDefinition = "TEXT")
    private String screenshotBase64;

    @Column(length = 10)
    private String country;

    private Instant createdAt = Instant.now();

    public FeedbackReport() {}

    // Getters/Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
}
