package com.myhome.api.components.item.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ItemsInRoomId implements Serializable {

	@Column(name ="fk_roomId")
	private Long roomId;

	@Column(name ="fk_itemId")
	private Long itemId;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ItemsInRoomId that = (ItemsInRoomId) o;
		return roomId.equals(that.roomId) && itemId.equals(that.itemId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(roomId, itemId);
	}
}
