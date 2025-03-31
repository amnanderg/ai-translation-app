package com.translation.ai_translation_app.repository;

import com.translation.ai_translation_app.model.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface TranslationRepository extends JpaRepository<Translation, Long> {
    }

