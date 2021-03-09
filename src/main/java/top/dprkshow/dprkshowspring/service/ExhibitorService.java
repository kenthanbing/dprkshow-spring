package top.dprkshow.dprkshowspring.service;

import com.alibaba.fastjson.JSONObject;
import top.dprkshow.dprkshowspring.entity.ExProfile;
import top.dprkshow.dprkshowspring.entity.Exhibitor;
import top.dprkshow.dprkshowspring.entity.ExhibitorPwd;
import top.dprkshow.dprkshowspring.entity.LoginInfo;

public interface ExhibitorService {
    JSONObject login(LoginInfo loginInfo);
    JSONObject updatePwd(ExhibitorPwd exhibitorPwd);
    void register(Exhibitor exhibitor);
    ExProfile getByUsername(String id);
}
