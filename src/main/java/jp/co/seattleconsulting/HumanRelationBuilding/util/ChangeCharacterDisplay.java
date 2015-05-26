package jp.co.seattleconsulting.HumanRelationBuilding.util;

import static jp.co.seattleconsulting.HumanRelationBuilding.constants.EmployeeConstants.*;

/**
 * データベースの情報を画面表示用に変換するクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class ChangeCharacterDisplay {

    /**
     * FORMから受け取った会話済みの値（物理）を画面表示用（論理）に変更する.
     *
     * @parm contactStatus：会話済み(1か0)
     * @return 1の場合は"はい", そうでない場合は"いいえ"
     */
    public String contactStatusForDisplay(String contactStatus) {

        if (contactStatus.equals(String.valueOf(CONTACTED))) {
        	return "はい";
        } else {
        	return "いいえ";
        }
    }

    /**
     * ENTITYから受け取った会話済みの値（物理）を画面表示用（論理）に変更する.
     *
     * @parm contactStatus：会話済み(1か0)
     * @return 1の場合は"はい", そうでない場合は"いいえ"
     */
    public String contactStatusForDisplay(int contactStatus) {

        if (contactStatus == CONTACTED) {
            return "はい";
        } else {
            return "いいえ";
        }
    }

    /**
     * ENTITYから受け取った会話済みの値（物理）をFORM用（物理）に変更する.
     *
     * @parm contactStatus：会話済み(1か0)
     * @return 1の場合は"1", そうでない場合は"0"
     */
    public String contactStatusForForm(int contactStatus) {

        if (contactStatus == CONTACTED) {
            return String.valueOf(CONTACTED);
        } else {
            return String.valueOf(NOT_CONTACT);
        }
    }

    /**
     * FORMから受け取った会話済みの値（物理）をENTITY用（物理）に変更する.
     *
     * @parm contactStatus：会話済み("1"か"0")
     * @return "1"の場合は1, "0"の場合は0
     */
    public int contactStatusForDB(String contactStatus) {

        if (contactStatus.equals(String.valueOf(CONTACTED))) {
            return CONTACTED;
        } else {
            return NOT_CONTACT;
        }
    }
}
