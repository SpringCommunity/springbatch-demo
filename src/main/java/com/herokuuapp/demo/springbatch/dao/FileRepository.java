package com.herokuuapp.demo.springbatch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.herokuuapp.demo.springbatch.domain.FileBean;

@Repository
public interface FileRepository extends JpaRepository<FileBean, Integer> {

}
