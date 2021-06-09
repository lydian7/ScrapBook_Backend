package com.ScrapBook.scrapbook_service_db.repositories;

import com.ScrapBook.scrapbook_service_db.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
