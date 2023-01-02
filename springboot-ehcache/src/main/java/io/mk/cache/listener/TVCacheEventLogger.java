package io.mk.cache.listener;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

public class TVCacheEventLogger implements CacheEventListener<Object, Object> {

	@Override
	public void onEvent(CacheEvent<?, ?> cacheEvent) {
		System.out.println("Cache event = " + cacheEvent.getType() + ", Key = " + cacheEvent.getKey()
				+ ",  Old value = " + cacheEvent.getOldValue() + ", New value = " + cacheEvent.getNewValue());
	}
}
