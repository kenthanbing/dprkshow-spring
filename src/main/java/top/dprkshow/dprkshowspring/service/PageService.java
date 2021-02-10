package top.dprkshow.dprkshowspring.service;

import com.github.pagehelper.PageInfo;
import top.dprkshow.dprkshowspring.entity.Article;
import top.dprkshow.dprkshowspring.entity.PageRequest;

public interface PageService {
    PageInfo<Article> getPageInfo(PageRequest pageRequest);
}
