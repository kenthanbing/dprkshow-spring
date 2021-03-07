package top.dprkshow.dprkshowspring.service;

import com.alibaba.fastjson.JSONObject;
import top.dprkshow.dprkshowspring.entity.ExhibitorPwd;
import top.dprkshow.dprkshowspring.entity.LoginInfo;

public interface ExhibitorService {
    JSONObject login(LoginInfo loginInfo);
    JSONObject updatePwd(ExhibitorPwd exhibitorPwd);
}