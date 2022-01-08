package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.Buy;
import fcu.sep.fcushop.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuyController {

  @Autowired
  BuyService productManager;

  /*@GetMapping("/buy")
  public List<Buy> getBuy() {
    return productManager.getBuy();

  }*/

  @GetMapping("/buy/{data}")
  public String buy(@PathVariable("data") String data) {
    String buf = data;
    Buy buy;
    buy = new Buy();

    productManager.pushBuy(buf);

    return "下單成功";
  }

  //@GetMapping("/buy/{keyword}")
  public List<Buy> getBuy(@PathVariable("keyword") String keyword) {
    return productManager.getBuy(keyword);
  }
}