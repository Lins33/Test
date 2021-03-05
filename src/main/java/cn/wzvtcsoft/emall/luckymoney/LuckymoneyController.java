package cn.wzvtcsoft.emall.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LuckymoneyController {

    @Autowired
    private LuckymoneyRepository repository;

    /**
     *获取红包列表
     * @return list
     */
    @GetMapping("/luckymoney")
    public List<Luckymoney> list(){
        return repository.findAll();
    }
}
