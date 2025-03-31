package com.translation.ai_translation_app.dto;

public class TranslationRequest {
    private String fromLanguage;
    private String toLanguage;
    private String text;

    public TranslationRequest(String fromLanguage, String toLanguage, String text) {
        this.fromLanguage = fromLanguage;
        this.toLanguage = toLanguage;
        this.text = text;
    }

    public TranslationRequest() {

    }

    public String getFromLanguage() {
        return fromLanguage;
    }

    public void setFromLanguage(String fromLanguage) {
        this.fromLanguage = fromLanguage;
    }

    public String getToLanguage() {
        return toLanguage;
    }

    public void setToLanguage(String toLanguage) {
        this.toLanguage = toLanguage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
