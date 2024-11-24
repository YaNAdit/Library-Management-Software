package com.practice.LibraryManagementSystem.dao;

import com.practice.LibraryManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    List<User> getListOfUserWhoBorrowedBook();
}
