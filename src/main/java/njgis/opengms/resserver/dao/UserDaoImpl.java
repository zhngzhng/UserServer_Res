package njgis.opengms.resserver.dao;

import com.alibaba.fastjson.JSONObject;
import njgis.opengms.resserver.entity.User;
import njgis.opengms.resserver.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public String updateUser(JSONObject jsonObject) {
        String userId = (String)jsonObject.get("userId");
        Query query = new Query(Criteria.where("userId").is(userId));
        Update update = CommonUtil.SetUpdate(jsonObject);
        try {
            mongoTemplate.updateFirst(query, update, User.class);
            return "Update success: "+ userId;
        }catch (Exception e){
            return "Update Fail";
        }
    }



    @Override
    public User getUser(String email) {
        Query query = new Query(Criteria.where("email").is(email));
        User user = mongoTemplate.findOne(query, User.class);
        user.setPassword("");
        user.setLoginIp(null);
        return user;
    }

    @Override
    public Object updateUser(HttpServletRequest request) {
        Update update = CommonUtil.SetUpdate(request);
        String userId = request.getParameter("userId");
        Query query = new Query(Criteria.where("userId").is(userId));
        try {
            mongoTemplate.updateFirst(query, update, User.class);
            return "suc";
        }catch (Exception e){
            return false;
        }
    }
}
