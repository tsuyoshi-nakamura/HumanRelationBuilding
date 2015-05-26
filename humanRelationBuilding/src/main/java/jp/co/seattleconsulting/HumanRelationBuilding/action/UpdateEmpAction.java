package jp.co.seattleconsulting.HumanRelationBuilding.action;

import javax.annotation.Resource;

import jp.co.seattleconsulting.HumanRelationBuilding.dto.UpdateEmpDto;
import jp.co.seattleconsulting.HumanRelationBuilding.form.UpdateEmpForm;
import jp.co.seattleconsulting.HumanRelationBuilding.service.UpdateEmpService;
import jp.co.seattleconsulting.HumanRelationBuilding.util.ChangeCharacterDisplay;

import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * 社員更新処理の制御を行うクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class UpdateEmpAction {

    @ActionForm
    @Resource
    public UpdateEmpForm updateEmpForm;

    @Resource
    protected UpdateEmpService updateEmpService;

    @Resource
    public UpdateEmpDto updateEmpDto;

    /**
     * 社員更新入力画面表示
     *
     * @return 社員登録入力画面の遷移パス
     */
    @Execute(validator = false)
    public String index() {
        updateEmpDto.empId = updateEmpForm.empId;
        updateEmpDto = updateEmpService.getById(updateEmpDto);

        return "index.jsp";
    }

    /**
     * 社員更新入力画面に戻る
     *
     * @return 社員登録入力画面の遷移パス
     */
    @Execute(validator = false)
    public String goBackIndex() {

        return "index.jsp";
    }

    /**
     * 社員更新確認画面表示
     *
     * @return 社員更新確認画面の遷移パス
     */
    @Execute(validator = true, input = "index")
    public String confirm() {

        ChangeCharacterDisplay changeCharacterDisplay = new ChangeCharacterDisplay();
        updateEmpDto.empId = updateEmpForm.empId;
        updateEmpDto.lastnameKanji = updateEmpForm.lastnameKanji;
        updateEmpDto.firstnameKanji = updateEmpForm.firstnameKanji;
        updateEmpDto.lastnameKatakana = updateEmpForm.lastnameKatakana;
        updateEmpDto.firstnameKatakana = updateEmpForm.firstnameKatakana;
        updateEmpDto.birthYear = updateEmpForm.birthYear;
        updateEmpDto.birthMonth = updateEmpForm.birthMonth;
        updateEmpDto.birthDay = updateEmpForm.birthDay;
        updateEmpDto.cellphoneNum = updateEmpForm.cellphoneNum;
        updateEmpDto.contactStatus = updateEmpForm.contactStatus;
        updateEmpDto.memo = updateEmpForm.memo;
        updateEmpDto.displayContactStatus = changeCharacterDisplay
                .contactStatusForDisplay(updateEmpForm.contactStatus);

        return "confirm.jsp";
    }

    /**
     * 社員情報更新する。 登録完了後、社員情報更新完了画面表示 登録失敗後、エラー画面表示
     *
     * @return 社員登録完了画面の遷移パス
     */
    @Execute(validator = false)
    @RemoveSession(name = "updateEmpDto")
    public String updateEmp() {

        updateEmpService.updateEmp(updateEmpDto);

        return "complete.jsp";
    }
}
