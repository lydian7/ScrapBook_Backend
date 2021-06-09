package com.ScrapBook.scrapbook_service_db.repositories;

import com.ScrapBook.scrapbook_service_db.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
