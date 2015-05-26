package jp.co.seattleconsulting.HumanRelationBuilding.service;

import static jp.co.seattleconsulting.HumanRelationBuilding.constants.EmployeeConstants.*;
import jp.co.seattleconsulting.HumanRelationBuilding.entity.Employee;

import org.seasar.extension.jdbc.service.S2AbstractService;
import org.seasar.extension.jdbc.where.SimpleWhere;

/**
 * 社員エンティティに対する操作を行うクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class IndexService extends S2AbstractService<Employee> {

    /**
     * 全ての社員人数を取得する.
     *
     * @return 全ての社員人数
     */
    public int getAllMembersNum() {
        Long allMembersNum = select().where(new SimpleWhere().
                eq("daleteFlag", NOT_DELETE)).
                getCount();

        return new Integer(allMembersNum.toString());
    }

    /**
     * 会話済みの社員人数を取得する.
     *
     * @return 会話済みの社員人数
     */
    public int getTalkedMembersNum() {
        Long talkedMembers = select().where(new SimpleWhere().
                eq("contactStatus", CONTACTED ).
                eq("daleteFlag", NOT_DELETE)).
                getCount();

        return new Integer(talkedMembers.toString());
    }
}
