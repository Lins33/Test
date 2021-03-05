package cn.wzvtcsoft.emall.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckymoneyService {
    @Autowired
    private LuckymoneyRepository repository;


    @Transactional
    public void createTwo(){
        Luckymoney luckymoney1=new Luckymoney();
        luckymoney1.setProducer("张三");
        luckymoney1.setMoney(new BigDecimal("520"));

        Luckymoney luckymoney2=new Luckymoney();
        luckymoney2.setProducer("张三");
        luckymoney2.setMoney(new BigDecimal("1314"));

        repository.save(luckymoney1);
        repository.save(luckymoney2);

    }
}
