package com.yurets_y.job_test__spring_crud_application.service;

import com.yurets_y.job_test__spring_crud_application.entity.Discount;
import com.yurets_y.job_test__spring_crud_application.repository.DiscountRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class DiscountService {

    private DiscountRepo discountRepo;

    public DiscountService(DiscountRepo discountRepo) {
        this.discountRepo = discountRepo;
    }


    @Transactional(readOnly = true)
    public List<Discount> getAll(){
        return discountRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Boolean existsById(Long id){
        return discountRepo.existsById(id);
    }

    @Transactional(readOnly = true)
    public Discount getById(Long id){
        return discountRepo.getOne(id);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public Discount saveDiscount(Discount discount){
        if(discount == null){
            throw new NullPointerException("Error while saving Discount, discount must not be null");
        }
        return discountRepo.save(discount);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void deleteDiscount(Long id){
        discountRepo.deleteById(id);
    }

}
