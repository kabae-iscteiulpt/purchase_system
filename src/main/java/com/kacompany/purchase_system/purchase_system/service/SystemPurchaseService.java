package com.kacompany.purchase_system.purchase_system.service;

import java.util.List;

import com.kacompany.purchase_system.purchase_system.dto.UserDto;

public interface SystemPurchaseService {

	List<UserDto> getAllUsers();

	UserDto createNewUser(UserDto userDto);

	UserDto updateUser(UserDto userDto);
	
	void deleteUser(UserDto dto);
}
