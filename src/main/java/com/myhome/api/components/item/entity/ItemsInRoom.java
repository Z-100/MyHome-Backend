package com.myhome.api.components.item.entity;

import com.myhome.api.components.room.entity.Room;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "item_is_in_room")
@Entity
@Data
public class ItemsInRoom {

	@EmbeddedId
	private ItemsInRoomId embeddedId;

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id", nullable = false)
//	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("roomId")
	private Room room;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("itemId")
	private Item item;

	@Column(name = "amount")
	private Integer name;

	@Column(name = "in_the_fridge")
	private Integer inTheFridge;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ItemsInRoom that = (ItemsInRoom) o;
		return room.equals(that.room) && item.equals(that.item);
	}

	@Override
	public int hashCode() {
		return Objects.hash(room, item);
	}
}
