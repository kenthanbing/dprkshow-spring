package top.dprkshow.dprkshowspring.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import top.dprkshow.dprkshowspring.entity.Article;
import top.dprkshow.dprkshowspring.entity.Buyer;
import top.dprkshow.dprkshowspring.entity.ContactMsg;
import top.dprkshow.dprkshowspring.entity.Exhibitor;

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
}
