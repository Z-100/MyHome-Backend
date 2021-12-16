package com.myhome.api.components.room.repository;

import com.myhome.api.components.room.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomRepository extends CrudRepository<Room, Long> {
//	House findByAccount(Account account);
}