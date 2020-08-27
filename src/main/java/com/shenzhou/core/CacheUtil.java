package com.shenzhou.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by ASUS on 2014/12/25.
 */
@Component("cacheUtil")
public class CacheUtil {

    private CacheManager cacheManager;

    private Cache cache;

    @Autowired
    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
        this.cache = this.cacheManager.getCache("authz.cache");
    }

    /**
     * @param key
     * @param value
     */
    public void setCacheValue(String key, Object value) {
        if (!StringUtils.hasText(key) || null == value) {
            return;
        }
        cache.put(key, value);
    }

    public Object getCacheValue(String key) {
        if (!StringUtils.hasText(key)) {
            return null;
        }
        Cache.ValueWrapper valueWrapper = cache.get(key);
        if (null == valueWrapper) {
            return null;
        }
        return valueWrapper.get();
    }

    public void removeCacheValue(String key) {
        if (!StringUtils.hasText(key)) {
            return;
        }

        cache.evict(key);
    }

    /**
     * 添加缓存中是否存在 Key
     *
     * @param Key
     * @return
     */
    public Boolean IsExist(String Key) {
        Boolean _IsExist = StringUtils.hasText(Key);

        if (_IsExist) {
            Cache.ValueWrapper valueWrapper = cache.get(Key);
            if (null == valueWrapper) {
                _IsExist = false;
            }
        }
        return _IsExist;
    }
}
