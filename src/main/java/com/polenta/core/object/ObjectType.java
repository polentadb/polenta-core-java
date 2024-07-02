package com.polenta.core.object;

import com.polenta.core.object.type.Bag;
import com.polenta.core.object.type.Table;
import com.polenta.core.object.type.User;
import com.polenta.core.store.Storable;

public enum ObjectType {

	USER, BAG, TABLE;
	
	public Storable create() {
		if (this == BAG) {
			return new Bag();
		} else if (this == TABLE) {
			return new Table();
		} else if (this == USER) {
			return new User();
		}
		return null;
	}
	
}
