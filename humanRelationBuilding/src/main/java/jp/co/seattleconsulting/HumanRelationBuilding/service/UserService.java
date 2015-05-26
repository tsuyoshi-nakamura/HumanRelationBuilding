package jp.co.seattleconsulting.HumanRelationBuilding.service;

import jp.co.seattleconsulting.HumanRelationBuilding.dto.UserDto;
import jp.co.seattleconsulting.HumanRelationBuilding.entity.User;

import org.seasar.extension.jdbc.service.S2AbstractService;
import org.seasar.extension.jdbc.where.SimpleWhere;

/**
 * ユーザエンティティに対する操作を行うクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class UserService extends S2AbstractService<User> {

    /**
     * ログインできるか判定する.
     *
     * @parm userDto：ログインの対象にするユーザ情報
     * @return ログインできればtrue, 出来なければfalse
     */
    public boolean login(UserDto userDto) {

        boolean login = 0 < select().where(new SimpleWhere().
                eq("userId", userDto.userId).
                eq("password", userDto.password)).
                getCount();

        return login;
    }
}
