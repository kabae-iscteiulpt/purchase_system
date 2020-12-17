package com.kacompany.purchase_system.purchase_system.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kacompany.purchase_system.purchase_system.dto.UserDto;
import com.kacompany.purchase_system.purchase_system.entity.User;
import com.kacompany.purchase_system.purchase_system.repositories.UserRepository;
import com.kacompany.purchase_system.purchase_system.service.SystemPurchaseService;

@Service
public class SystemPurchaseServiceImpl implements SystemPurchaseService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDto> getAllUsers() {
		final List<User> users = userRepository.findAll();

		final List<UserDto> listOfUsersDto = new ArrayList<>();

		for (User user : users) {

			UserDto userDto = new UserDto(user.getUserId(), user.getName(), user.getAddress());
			listOfUsersDto.add(userDto);
		}
		return listOfUsersDto;
	}

	@Override
	public UserDto createNewUser(final UserDto userDto) {
		final User user = new User();

		user.setAddress(userDto.getAddress());
		user.setName(userDto.getName());

		userRepository.save(user);
		userDto.setId(user.getUserId());
		return userDto;
	}

	@Override
	public UserDto updateUser(final UserDto userDto) {

		final Optional<User> userData = userRepository.findById(userDto.getId());

		User user = userData.get();

		user.setAddress(userDto.getAddress());
		user.setName(userDto.getName());

		userRepository.save(user);

		return userDto;
	}

	@Override
	public void deleteUser(final UserDto userDto) {

		final Optional<User> user = userRepository.findById(userDto.getId());

		System.out.println(user.toString());
		userRepository.deleteById(user.get().getUserId());
		System.out.println("done -2");
	}
}
