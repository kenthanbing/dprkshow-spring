package top.dprkshow.dprkshowspring.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dprkshow.dprkshowspring.dao.DprkshowMapper;
import top.dprkshow.dprkshowspring.entity.Exhibitor;
import top.dprkshow.dprkshowspring.entity.ExhibitorPwd;
import top.dprkshow.dprkshowspring.entity.LoginInfo;
import top.dprkshow.dprkshowspring.service.ExhibitorService;

import java.util.UUID;

@Service
public class ExhibitorServiceImpl implements ExhibitorService {

    @Autowired
    DprkshowMapper dprkshowMapper;

    @Override
    public JSONObject login(LoginInfo loginInfo) {
        JSONObject result = new JSONObject();
        JSONObject profile = dprkshowMapper.getProfile(loginInfo);
        if (profile != null && SecureUtil.md5(loginInfo.getPassword()).equals(profile.get("password"))) {
            String token = UUID.randomUUID().toString();
            result.put("data", "Login success!");
            result.put("eid", profile.get("eid"));
            result.put("username", profile.get("username"));
            result.put("token", token);
            return result;
        }
        result.put("data", "Login failed!");
        return result;
    }

    @Override
    public JSONObject updatePwd(ExhibitorPwd exhibitorPwd) {
        JSONObject result = new JSONObject();
        String oldPwd = dprkshowMapper.getPasswordByEid(exhibitorPwd.getEid());
        exhibitorPwd.setPwd(SecureUtil.md5(exhibitorPwd.getPwd()));
        exhibitorPwd.setNew_pwd(SecureUtil.md5(exhibitorPwd.getNew_pwd()));
        if (exhibitorPwd.getPwd().equals(oldPwd)) {
            dprkshowMapper.updatePwd(exhibitorPwd);
            result.put("data", "Update success!");
            return result;
        }
        result.put("data", "Update failed!");
        return result;
    }

    @Override
    public void register(Exhibitor exhibitor) {
        exhibitor.setPassword(SecureUtil.md5(exhibitor.getPassword()));
        dprkshowMapper.addExhibitor(exhibitor);
    }
}
