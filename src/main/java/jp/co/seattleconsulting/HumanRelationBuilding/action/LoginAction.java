package jp.co.seattleconsulting.HumanRelationBuilding.action;

import javax.annotation.Resource;

import jp.co.seattleconsulting.HumanRelationBuilding.dto.LoginDto;
import jp.co.seattleconsulting.HumanRelationBuilding.dto.UserDto;
import jp.co.seattleconsulting.HumanRelationBuilding.form.LoginForm;
import jp.co.seattleconsulting.HumanRelationBuilding.service.UserService;

import org.apache.log4j.Logger;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.exception.ActionMessagesException;

/**
 * ログイン処理の制御を行うクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class LoginAction {

    @ActionForm
    @Resource
    protected LoginForm loginForm;

    @Resource
    protected UserService userService;

    @Resource
    protected LoginDto loginDto;

    /**
     * ログイン画面表示
     *
     * @return ログイン画面の遷移パス
     */
    @Execute(validator = false)
    public String index() {

        return "index.jsp";
    }

    /**
     * タイムアウト画面表示
     *
     * @return タイムアウト画面の遷移パス
     */
    @Execute(validator = false)
    public String timeout() {

        return "timeout.jsp";
    }

    /**
     * ログイン処理
     *
     * @return トップ画面の遷移パス
     */
    @Execute(validator = true, input = "index")
    public String login() {
        UserDto userDto = new UserDto();
        userDto.userId = loginForm.userId;
        userDto.password = loginForm.password;

        /**
         * ログイン判定処理
         */
        if (userService.login(userDto)) {
            loginDto.userId = loginForm.userId;
        } else {
            Logger logger = Logger.getLogger(LoginAction.class.getName());
            logger.error("ログインに失敗しました");

            throw new ActionMessagesException("ログインに失敗です！！！！！！！！！！", false);
        }

        return "/index";
    }
}
