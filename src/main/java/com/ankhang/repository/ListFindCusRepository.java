package com.ankhang.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ankhang.entities.List_RestAPI_FindCus;

@Repository
public interface ListFindCusRepository extends CrudRepository<List_RestAPI_FindCus, Long> {

}
