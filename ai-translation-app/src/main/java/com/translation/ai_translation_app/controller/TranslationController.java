package com.translation.ai_translation_app.controller;

import com.translation.ai_translation_app.dto.TranslationRequest;
import com.translation.ai_translation_app.dto.TranslationResponse;
import com.translation.ai_translation_app.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TranslationController {

    private final TranslationService translationService;

    @Autowired
    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @GetMapping("/")
    public String showTranslationForm(Model model) {
        model.addAttribute("translationRequest", new TranslationRequest());
        return "translate";
    }

    @PostMapping("/translate")
    public String translateText(@ModelAttribute TranslationRequest translateRequest, Model model) {
        TranslationResponse response = translationService.translate(translateRequest);
        model.addAttribute("translationResponse", response);
        return "result";
    }
}
