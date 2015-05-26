package jp.co.seattleconsulting.HumanRelationBuilding.dto;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

/**
 * 社員情報登録データ転送オブジェクトクラス.
 *
 * @author Tsuyoshi Nakamura
 */
@Component(instance = InstanceType.SESSION)
public class RegisterEmpDto implements Serializable {
    private static final long serialVersionUID = 1L;

    public String lastnameKanji;
    public String firstnameKanji;
    public String lastnameKatakana;
    public String firstnameKatakana;
    public String birthYear;
    public String birthMonth;
    public String birthDay;
    public String cellphoneNum;
    public String contactStatus;
    public String displayContactStatus;
    public String memo;
}
