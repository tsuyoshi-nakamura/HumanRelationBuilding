package jp.co.seattleconsulting.HumanRelationBuilding.form;

import java.io.Serializable;

import org.seasar.struts.annotation.IntegerType;
import org.seasar.struts.annotation.Mask;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Msg;
import org.seasar.struts.annotation.Required;

/**
 * 社員情報更新画面のリクエストのパラメータを管理するクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class UpdateEmpForm implements Serializable {

    private static final long serialVersionUID = 1L;

    public String empId;

    @Maxlength(maxlength = 10)
    public String lastnameKanji;

    @Maxlength(maxlength = 10)
    public String firstnameKanji;

    @Maxlength(maxlength = 20)
    @Mask(mask = "^[\u30A0-\u30FF]+$", msg = @Msg(key = "errors.katakana"))
    public String lastnameKatakana;

    @Maxlength(maxlength = 20)
    @Mask(mask = "^[\u30A0-\u30FF]+$", msg = @Msg(key = "errors.katakana"))
    public String firstnameKatakana;

    @IntegerType
    @Maxlength(maxlength = 4)
    @Mask(mask = "^[0-9]*$", msg = @Msg(key = "errors.hankakuNum"))
    public String birthYear;

    @Maxlength(maxlength = 2)
    @Mask(mask = "^[0-9]*$", msg = @Msg(key = "errors.hankakuNum"))
    public String birthMonth;

    @Maxlength(maxlength = 2)
    @Mask(mask = "^[0-9]*$", msg = @Msg(key = "errors.hankakuNum"))
    public String birthDay;

    @Maxlength(maxlength = 11)
    @Mask(mask = "^[0-9]*$", msg = @Msg(key = "errors.hankakuNum"))
    public String cellphoneNum;

    @Required
    public String contactStatus;

    @Required
    public String memo;
}
