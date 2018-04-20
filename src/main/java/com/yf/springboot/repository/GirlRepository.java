package com.yf.springboot.repository;

import com.yf.springboot.model.TbGirl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GirlRepository extends JpaRepository<TbGirl,Long> {

    /**
     * 通过罩杯查询女生
     * @param cupSize
     * @return
     */
    List<TbGirl> findTbGirlsByCupSize(String cupSize);
}
