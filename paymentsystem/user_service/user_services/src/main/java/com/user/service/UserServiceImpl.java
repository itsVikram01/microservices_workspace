package com.user.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.user.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	// fake user list
	List<User> list=List.of(
			new User(111L,"Vikram","1234567890"),
			new User(222L,"Mayank","8888888888"),
			new User(333L,"Abhi","9999999999")
	);

	@Override
	public User getUser(Long id) {
		return list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
	}
	
}
