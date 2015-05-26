package jp.co.seattleconsulting.HumanRelationBuilding.form;

import java.io.Serializable;

/**
 * 社員情報削除画面のリクエストのパラメータを管理するクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class DeleteEmpForm implements Serializable {

    private static final long serialVersionUID = 1L;

    public String empId;
}
