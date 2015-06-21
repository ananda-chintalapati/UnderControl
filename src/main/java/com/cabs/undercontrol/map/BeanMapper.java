package com.cabs.undercontrol.map;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BeanMapper {

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public <T, K> T transform(K source, Class<T> destinationClass) {
	return dozerBeanMapper.map(source, destinationClass);
    }

    public <T, K> T transform(K source, T destination) {
	dozerBeanMapper.map(source, destination);
	return destination;
    }

    public <T, K> T transform(List<K> sourceCollection, Class<T> destinationClass) throws InstantiationException,
	    IllegalAccessException {
	T t = destinationClass.newInstance();
	if (CollectionUtils.isNotEmpty(sourceCollection)) {
	    for (K collectionEntity : sourceCollection) {
		dozerBeanMapper.map(collectionEntity, t);
	    }
	}

	return t;
    }
}
