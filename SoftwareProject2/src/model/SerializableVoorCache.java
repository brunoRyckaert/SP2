package model;

import java.io.File;
import java.io.Serializable;

import controller.CacheController;

public abstract interface SerializableVoorCache extends Serializable {
	public default boolean serialize() {
		return serialize(Definitions.getCacheFile());
	}
	
	public default boolean serialize(File destination) {
		return CacheController.serialize(this,destination);
	}
}
