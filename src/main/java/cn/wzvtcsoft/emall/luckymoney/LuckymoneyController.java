package cn.wzvtcsoft.emall.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {

    @Autowired
    private LuckymoneyRepository repository;
    @Autowired
    private LuckymoneyService service;
    /**
     *获取红包列表
     * @return list
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list(){
        return repository.findAll();
    }

    /**
     * 创建红包（发送红包）
     * @param producer 发红包的人
     * @param money 红包金额
     * @return Luckymoney
     */
    @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") String producer, @RequestParam("money")BigDecimal money){
        Luckymoney luckymoney=new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return repository.save(luckymoney);
    }

    @GetMapping("/luckymoneys/{id}")
    public Luckymoney selectById(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,@RequestParam("consumer") String consumer){
        Optional<Luckymoney> optional=repository.findById(id);
        if(optional.isPresent()){
            Luckymoney luckymoney=optional.get();
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }
    return null;
    }


    @PostMapping("/luckymoneys/two")
    public void createTwo(){
        service.createTwo();
    }
}
