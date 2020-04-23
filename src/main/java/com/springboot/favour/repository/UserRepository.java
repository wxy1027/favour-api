package com.springboot.favour.repository;

import com.springboot.favour.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author: WXY
 * @Dscription:
 * @Date: Created in 2020/4/23
 * @Modified By:
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByOpenId(String openId);
}
