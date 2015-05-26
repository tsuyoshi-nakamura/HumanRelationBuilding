package jp.co.seattleconsulting.HumanRelationBuilding.action;

import org.seasar.framework.aop.annotation.InvalidateSession;
import org.seasar.struts.annotation.Execute;

/**
 * ログアウト処理の制御を行うクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class LogoutAction {

    /**
     * ログアウト処理
     *
     * @return ログイン画面の遷移パス
     */
    @InvalidateSession
    @Execute(validator = false, redirect = true)
    public String index() {

        return "/login/";
    }
}
