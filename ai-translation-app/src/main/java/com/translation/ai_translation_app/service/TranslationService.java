package com.translation.ai_translation_app.service;

import com.translation.ai_translation_app.dto.TranslationRequest;
import com.translation.ai_translation_app.dto.TranslationResponse;
import com.translation.ai_translation_app.model.Translation;
import com.translation.ai_translation_app.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslationService {

    private final TranslationRepository translationRepository;
    private final TranslationApiService translationApiService;

    @Autowired
    public TranslationService(TranslationRepository translationRepository,
                              TranslationApiService translationApiService) {
        this.translationRepository = translationRepository;
        this.translationApiService = translationApiService;
    }

    public TranslationResponse translate(TranslationRequest request) {
        String translatedText = translationApiService.translateText(
                request.getText(), request.getFromLanguage(), request.getToLanguage());

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
    public List<Translation> getAllTranslations() {
        return translationRepository.findAll();
    }
}
