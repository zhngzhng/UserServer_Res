package njgis.opengms.resserver.entity.enums;

import lombok.Getter;

@Getter
public enum UserTitle {
    Professor("Prof."), Dr("Dr."), Mr("Mr"), Ms("Ms"), Miss("Miss"), Mrs("Mrs"), Mx("Mx");
    private String desc;

    UserTitle(String desc) {
        this.desc = desc;
    }
}
