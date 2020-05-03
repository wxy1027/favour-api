package com.springboot.favour.repository;

import com.springboot.favour.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author: WXY
 * @Dscription:
 * @Date: Created in 2020/4/23
 * @Modified By:
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByOpenId(String openId);
}
