package top.dprkshow.dprkshowspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.dprkshow.dprkshowspring.dao.DprkshowMapper;

import top.dprkshow.dprkshowspring.entity.*;
import top.dprkshow.dprkshowspring.service.BuyerService;
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
    public void addExhibitor(@RequestBody Exhibitor exhibitor) {
        dprkshowMapper.addExhibitor(exhibitor);
    }
}
