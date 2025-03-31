
CREATE TABLE translations (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
from_language VARCHAR(255),
to_language VARCHAR(255),
original_text TEXT,
translated_text TEXT
)