package njgis.opengms.resserver.entity;

import njgis.opengms.resserver.entity.enums.UserTitle;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Data
@Document(collection = "users")
public class User {
    private String userId; //uuid
    private String email;
    /*
    用户可修改信息
     */
    private String password;  //MD5 在后端进行MD5编码
    private String name;

    private long phoneNum;
    private UserTitle title; //enum类型，只需要传入对应的字符串即可
    private String country;
    private String state;
    private String city;
    private String homePage;
    //动态数组，只需要对应String[]即可
    private ArrayList<String> organizations;
    private String introduction;
    /*
    资源对象，直接以对象方式存入mongodb
    其包含的字段：
    UID,Name,Address,Type,Privacy,Thumbnail,EditToolInfo,FileSize
    Parent,MD5,Suffix,Description,Template,UploadTime,Children
     */
    private ArrayList<Resource> resources;

    //用户无法自行修改部分
    private Date creatTime;
    private ArrayList<String> loginIp;
    private ArrayList<String> domain;
}
