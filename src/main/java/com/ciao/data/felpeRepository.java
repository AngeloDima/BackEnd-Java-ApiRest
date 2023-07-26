package com.ciao.data;

import com.ciao.data.felpeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface felpeRepository extends JpaRepository<felpeModel, Integer> {
    List<felpeModel> findByTitolo(String titolo);
}
