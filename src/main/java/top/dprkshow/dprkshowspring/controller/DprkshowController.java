package top.dprkshow.dprkshowspring.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sun.management.snmp.jvminstr.JvmOSImpl;
import top.dprkshow.dprkshowspring.dao.DprkshowMapper;

import top.dprkshow.dprkshowspring.entity.*;
import top.dprkshow.dprkshowspring.service.BuyerService;
import top.dprkshow.dprkshowspring.service.ExhibitorService;
import top.dprkshow.dprkshowspring.service.PageService;

import java.util.List;

@RestController
public class DprkshowController {

    @Autowired
    DprkshowMapper dprkshowMapper;

    @Autowired
    PageService pageService;

    @Autowired
    BuyerService buyerService;

    @Autowired
    ExhibitorService exhibitorService;

    @GetMapping("/articleslast3")
    public List<Article> selectArticleLast3() {
        return dprkshowMapper.selectArticleLast3();
    }

    @PostMapping("/contactus")
    public void addContactus(@RequestBody ContactMsg contactMsg) {
        dprkshowMapper.addContactus(contactMsg);
    }

    @GetMapping("/articles")
    public Object getPagedArticles(PageRequest pageRequest) {
        return pageService.getPageInfo(pageRequest);
    }

    @GetMapping("/articlecount")
    public Integer getArticleCount() {
        return dprkshowMapper.getArticleCount();
    }

    @GetMapping("/article")
    public Article getArticleById(String aid){
        return dprkshowMapper.getArticleById(Integer.parseInt(aid));
    }

    @PostMapping("/buyersubmit")
    public Integer addBuyer(@RequestBody Buyer buyer) {
        return buyerService.addBuyer(buyer);
    }

    @PostMapping("/exregister")
    // todo 重写密码加密，用service
    public void addExhibitor(@RequestBody Exhibitor exhibitor) {
        exhibitorService.register(exhibitor);
    }

    @PostMapping("/login")
    public JSONObject exhibitorLogin(@RequestBody LoginInfo loginInfo) {
        return exhibitorService.login(loginInfo);
    }

    @GetMapping("/info")
    public Exhibitor exhibitorInfo(String eid) {
        return dprkshowMapper.getExhibitor(Integer.parseInt(eid));
    }

    @PutMapping("/info")
    public void updateExhibitor(@RequestBody ExhibitorInfo exhibitorInfo) {
        dprkshowMapper.updateExhibitor(exhibitorInfo);
    }

    @PostMapping("/pwd")
    public JSONObject updatePwd(@RequestBody ExhibitorPwd exhibitorPwd) {
        return exhibitorService.updatePwd(exhibitorPwd);
    }
}
