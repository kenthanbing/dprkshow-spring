package top.dprkshow.dprkshowspring.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dprkshow.dprkshowspring.dao.DprkshowMapper;
import top.dprkshow.dprkshowspring.entity.Article;
import top.dprkshow.dprkshowspring.entity.PageRequest;
import top.dprkshow.dprkshowspring.service.PageService;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    DprkshowMapper dprkshowMapper;

    @Override
    public PageInfo<Article> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Article> articleMenus = dprkshowMapper.getAllArticles();
        return new PageInfo<Article>(articleMenus);
    }
}
