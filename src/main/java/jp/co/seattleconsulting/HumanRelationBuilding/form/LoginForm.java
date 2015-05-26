package jp.co.seattleconsulting.HumanRelationBuilding.form;

import java.io.Serializable;

import org.seasar.struts.annotation.Mask;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Msg;
import org.seasar.struts.annotation.Required;

/**
 * ログイン画面のリクエストのパラメータを管理するクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class LoginForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Required
    @Maxlength(maxlength = 12)
    @Mask(mask = "^[0-9a-zA-Z_]*$", msg = @Msg(key = "errors.hankaku"))
    public String userId;

    @Required
    @Maxlength(maxlength = 12)
    @Mask(mask = "^[0-9a-zA-Z_]*$", msg = @Msg(key = "errors.hankaku"))
    public String password;

    /*
    public ActionMessages validate() {
        ActionMessages errors = new ActionMessages();

        errors.add("userId", new ActionMessage("ログインに失敗しました", false));

        return errors;
    }
    */
}
