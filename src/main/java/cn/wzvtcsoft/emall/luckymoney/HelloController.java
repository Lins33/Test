package cn.wzvtcsoft.emall.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/say")
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;

    @GetMapping({"/hello/{id}","/hi/{id}"})
    public String say(@PathVariable("id") Integer id){
        return "id:"+id;
    }

    @GetMapping("/hihello")
    public String sayOne(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return "id:"+id;
    }
}
