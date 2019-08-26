package com.gidae.restcrud.service;

import com.gidae.restcrud.domain.Basic;
import com.gidae.restcrud.repository.BasicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicService {

    private final BasicRepository basicRepository;

    public BasicService(BasicRepository basicRepository) {
        this.basicRepository = basicRepository;
    }

    public List<Basic> findBasicAll(){
        return basicRepository.findAll();
    }

    public Basic save(Basic basic){
        return basicRepository.save(basic);
    }

    public void delete(Basic basic){
        basicRepository.delete(basic);
    }

    public Basic findBasicByIdx(Long idx){
        return basicRepository.findById(idx).orElse(new Basic());
    }
}
