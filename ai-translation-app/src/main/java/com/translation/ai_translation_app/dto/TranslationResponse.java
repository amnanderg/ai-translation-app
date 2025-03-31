package com.translation.ai_translation_app.dto;

public class TranslationResponse {
    private String translatedText;
    private String fromLanguage;
    private String toLanguage;

    public TranslationResponse(String translatedText, String fromLanguage, String toLanguage) {
        this.translatedText = translatedText;
        this.fromLanguage = fromLanguage;
        this.toLanguage = toLanguage;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
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
}
