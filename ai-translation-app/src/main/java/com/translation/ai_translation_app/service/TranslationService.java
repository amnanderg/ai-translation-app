package com.translation.ai_translation_app.service;

import com.translation.ai_translation_app.dto.TranslationRequest;
import com.translation.ai_translation_app.dto.TranslationResponse;
import com.translation.ai_translation_app.model.Translation;
import com.translation.ai_translation_app.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationService {
    private final TranslationRepository translationRepository;

    @Autowired
    public TranslationService(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    public TranslationResponse translate(TranslationRequest request) {
        String translatedText = "[Translated" + request.getText() + "]";

        Translation translation = new Translation(
                request.getFromLanguage(),
                request.getToLanguage(),
                request.getText(),
                translatedText
        );

        translationRepository.save(translation);
        return new TranslationResponse(translatedText,
                request.getFromLanguage(),
                request.getToLanguage());
    }
}
