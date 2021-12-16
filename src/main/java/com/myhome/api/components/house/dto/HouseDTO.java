package com.myhome.api.components.house.dto;

import com.myhome.api.components.room.entity.Room;
import lombok.Data;

import java.util.List;

@Data
public class HouseDTO {

	private Long id;

	private String name;

	private List<Room> rooms;

}
