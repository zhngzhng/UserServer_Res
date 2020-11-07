package njgis.opengms.resserver.dao;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;

public interface UserDao {
    Object updateUser(JSONObject jsonObject);
    Object getUser(String email);
    Object updateUser(HttpServletRequest request);
}
