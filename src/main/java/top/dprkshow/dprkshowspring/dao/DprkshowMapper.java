package top.dprkshow.dprkshowspring.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.*;
import top.dprkshow.dprkshowspring.entity.*;

import java.util.List;

@Mapper
public interface DprkshowMapper {

    @Select("SELECT * FROM `articles` ORDER BY aid DESC LIMIT 3;")
    public List<Article> selectArticleLast3();

    @Insert("insert into contactus(sender, tel, email, message) values(#{sender},#{tel},#{email},#{message})")
    public void addContactus(ContactMsg contactMsg);

    @Select("select * from articles order by aid desc")
    List<Article> getAllArticles();

    @Select("SELECT COUNT(*) FROM articles;")
    Integer getArticleCount();

    @Select("select * from articles where aid=#{aid}")
    Article getArticleById(Integer aid);

    @Insert("insert into buyers(company, section, contact, tel, position, nation, email, address, intro)" +
            "values(#{company}, #{section}, #{contact}, #{tel}, #{position}, #{nation}, #{email}, #{address}, #{intro})")
    @Options(useGeneratedKeys=true, keyProperty="bid", keyColumn="bid")
    void addBuyer(Buyer buyer);

    @Insert("insert into exhibitors(username, password, company, section, contact, tel, position, nation, email, address, intro)" +
            "values(#{username}, #{password}, #{company}, #{section}, #{contact}, #{tel}, #{position}, #{nation}, #{email}, #{address}, #{intro})")
    @Options(useGeneratedKeys=true, keyProperty="eid", keyColumn="eid")
    void addExhibitor(Exhibitor exhibitor);

    @Select("select eid, username, password from exhibitors where username=#{username}")
    JSONObject getPassword(LoginInfo loginInfo);

    @Select("select * from exhibitors where eid=#{eid}")
    Exhibitor getExhibitor(Integer eid);

    @Update("update exhibitors set company=#{company}, section=#{section}, contact=#{contact}, tel=#{tel}," +
            "position=#{position}, nation=#{nation}, email=#{email}, address=#{address}, intro=#{intro} where eid=#{eid}")
    void updateExhibitor(ExhibitorInfo exhibitorInfo);

    @Update("update exhibitors set password=#{new_pwd} where eid=#{eid}")
    void updatePwd(ExhibitorPwd exhibitorPwd);

    @Select("select password from exhibitors where eid=#{eid}")
    String getPasswordByEid(Integer eid);
}
