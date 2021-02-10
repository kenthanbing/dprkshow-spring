package top.dprkshow.dprkshowspring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dprkshow.dprkshowspring.dao.DprkshowMapper;
import top.dprkshow.dprkshowspring.entity.Buyer;
import top.dprkshow.dprkshowspring.service.BuyerService;

@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    DprkshowMapper dprkshowMapper;

    @Override
    public Integer addBuyer(Buyer buyer) {
        dprkshowMapper.addBuyer(buyer);
        return buyer.getBid();
    }
}
