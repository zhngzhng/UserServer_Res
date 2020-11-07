package njgis.opengms.resserver.controller;

import com.alibaba.fastjson.JSONObject;
import njgis.opengms.resserver.dao.UserDaoImpl;
import njgis.opengms.resserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserDaoImpl userDao;

    /**
     * 更改请求从客户端后台发送过来
     * @param
     * @return
     */
    @RequestMapping(value = "/update",produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
    public String updateUserInfo(HttpServletRequest request){
        String updateResult = (String)userDao.updateUser(request);
        return updateResult;
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public User getUserInfo(Principal principal){
        String userEmail = principal.getName();
        User user = userDao.getUser(userEmail);
        return user;
    }
}
