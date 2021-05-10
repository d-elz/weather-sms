package com.weatherapi.model;

public class SmsModel {

    private String trackingId;
    private String status;
    private String createdAt;
    private String from;
    private String to;
    private String body;
    private String flash;
    private BodyAnalysis bodyAnalysis;


    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFlash() {
        return flash;
    }

    public void setFlash(String flash) {
        this.flash = flash;
    }

    public BodyAnalysis getBodyAnalysis() {
        return bodyAnalysis;
    }

    public void setBodyAnalysis(BodyAnalysis bodyAnalysis) {
        this.bodyAnalysis = bodyAnalysis;
    }

    public static class BodyAnalysis{
        private String parts;
        private String unicode;
        private String characters;

        public String getParts() {
            return parts;
        }

        public void setParts(String parts) {
            this.parts = parts;
        }

        public String getUnicode() {
            return unicode;
        }

        public void setUnicode(String unicode) {
            this.unicode = unicode;
        }

        public String getCharacters() {
            return characters;
        }

        public void setCharacters(String characters) {
            this.characters = characters;
        }
    }

}
