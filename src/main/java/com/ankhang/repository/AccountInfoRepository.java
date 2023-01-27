package com.ankhang.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ankhang.entities.Account_Info;

@Repository
public interface AccountInfoRepository extends CrudRepository<Account_Info, Long> {

}
