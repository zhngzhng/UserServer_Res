package njgis.opengms.resserver.util;

import com.alibaba.fastjson.JSONObject;
import njgis.opengms.resserver.entity.enums.UserTitle;
import org.springframework.data.mongodb.core.query.Update;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

public class CommonUtil {
    public static Update SetUpdate(HttpServletRequest request){
        Update update = new Update();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String filedName = parameterNames.nextElement();
            String filedValue = request.getParameter(filedName);
            update.set(filedName, filedValue);
            //Mapping放在各客户端即可
            // switch (filedName){
            //     case "mobilePhone":
            //         String key = "phoneNum";
            //         long value = Long.parseLong(filedValue);
            //         update.set(key, value);
            //         break;
            //     case "jobTitle":
            //         String til = "title";
            //         UserTitle title = UserTitle.valueOf(filedValue);
            //         update.set(til, title);
            //         break;
            //     case "userName":
            //         String name = "name";
            //         update.set(name, filedValue);
            //         break;
            //     case "organization":
            //         String ket = "organizations";
            //         String[] org = filedValue.split(",");
            //         update.set(ket, org);
            //         break;
            //     default:
            //         update.set(filedName, filedValue);
            // }
        }

        return update;
    }
    public static Update SetUpdate(JSONObject jsonObject){
        Update update = new Update();
        for (Map.Entry entry: jsonObject.entrySet()){
            if (entry.getKey().equals("userId") || entry.getKey().equals("email")){
                continue;
            }
            if (entry.getKey().equals("organizations")){
                String[] value = ((String)entry.getValue()).split(",");
                update.set((String) entry.getKey(), value);
                continue;
            }
            update.set((String)entry.getKey(), entry.getValue());
        }
        return update;
    }
}
