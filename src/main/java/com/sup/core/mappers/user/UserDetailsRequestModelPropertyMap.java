package com.sup.core.mappers.user;

import org.modelmapper.PropertyMap;

import com.sup.core.entities.UserDetails;
import com.sup.core.mapping.CustomMapping;
import com.sup.core.models.user.UserDetailsRequestModel;

@CustomMapping
public class UserDetailsRequestModelPropertyMap extends PropertyMap<UserDetailsRequestModel, UserDetails> {
    @Override
    protected void configure() {
        map(source).setUserStatus(null);
    }
}
