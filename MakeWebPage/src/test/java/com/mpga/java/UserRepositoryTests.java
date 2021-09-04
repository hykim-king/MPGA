package com.mpga.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
//Replace.Any를 사용하면 기본적으로 내장된 임베디드 데이터베이스를 사용합니다. 
//Replace.NONE로 설정하면 @ActiveProfiles에 설정한 프로파일 환경값에 따라 데이터 소스가 적용됩니다.
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("alex@gamil.com");
		user.setPassword("alex2020");
		user.setFirstName("Alexander");
		user.setLastName("Hebb");
		
		User savedUser = repo.save(user);
		
		User existUser = entityManager.find(User.class, savedUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}
	
	@Test
	public void testFindUserByEmail() {
		String email = "nam@codejava.net";
		
		User user = repo.findByEmail(email);
		
		assertThat(user).isNotNull();
	}
}
