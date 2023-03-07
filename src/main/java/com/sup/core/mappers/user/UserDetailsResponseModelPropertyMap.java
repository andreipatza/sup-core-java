package com.sup.core.mappers.user;

import org.modelmapper.PropertyMap;

import com.sup.core.entities.UserDetails;
import com.sup.core.mapping.CustomMapping;
import com.sup.core.models.user.UserDetailsResponseModel;

@CustomMapping
public class UserDetailsResponseModelPropertyMap extends PropertyMap<UserDetailsResponseModel, UserDetails> {
    @Override
    protected void configure() {

    }
}