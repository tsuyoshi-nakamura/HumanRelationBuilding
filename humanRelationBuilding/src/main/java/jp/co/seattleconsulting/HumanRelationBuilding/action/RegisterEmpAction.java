package jp.co.seattleconsulting.HumanRelationBuilding.action;

import java.util.List;

import javax.annotation.Resource;

import jp.co.seattleconsulting.HumanRelationBuilding.dto.RegisterEmpDto;
import jp.co.seattleconsulting.HumanRelationBuilding.form.RegisterEmpForm;
import jp.co.seattleconsulting.HumanRelationBuilding.service.RegisterEmpService;
import jp.co.seattleconsulting.HumanRelationBuilding.util.ChangeCharacterDisplay;

import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * 社員情報登録処理の制御を行うクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class RegisterEmpAction {

    @ActionForm
    @Resource
    public RegisterEmpForm registerEmpForm;

    @Resource
    protected RegisterEmpService registerEmpService;

    @Resource
    public RegisterEmpDto registerEmpDto;
    public List<RegisterEmpDto> registerEmpDtoList;

    /**
     * 社員情報登録入力画面表示
     *
     * @return 社員登録入力画面の遷移パス
     */
    @Execute(validator = false)
    public String index() {

        return "index.jsp";
    }

    /**
     * 社員情報登録入力画面に戻る
     *
     * @return 社員情報登録入力画面の遷移パス
     */
    @Execute(validator = false)
    public String goBackIndex() {
        registerEmpForm.lastnameKanji = registerEmpDto.lastnameKanji;
        registerEmpForm.firstnameKanji = registerEmpDto.firstnameKanji;
        registerEmpForm.lastnameKatakana = registerEmpDto.lastnameKatakana;
        registerEmpForm.firstnameKatakana = registerEmpDto.firstnameKatakana;
        registerEmpForm.birthYear = registerEmpDto.birthYear;
        registerEmpForm.birthMonth = registerEmpDto.birthMonth;
        registerEmpForm.birthDay = registerEmpDto.birthDay;
        registerEmpForm.cellphoneNum = registerEmpDto.cellphoneNum;
        registerEmpForm.contactStatus = registerEmpDto.contactStatus;
        registerEmpForm.memo = registerEmpDto.memo;

        return "index.jsp";
    }

    /**
     * 社員情報登録確認画面表示
     *
     * @return 社員登録確認画面の遷移パス
     */
    @Execute(validator = true, input = "index")
    public String confirm() {

        ChangeCharacterDisplay changeCharacterDisplay = new ChangeCharacterDisplay();

        registerEmpDto.lastnameKanji = registerEmpForm.lastnameKanji;
        registerEmpDto.firstnameKanji = registerEmpForm.firstnameKanji;
        registerEmpDto.lastnameKatakana = registerEmpForm.lastnameKatakana;
        registerEmpDto.firstnameKatakana = registerEmpForm.firstnameKatakana;
        registerEmpDto.birthYear = registerEmpForm.birthYear;
        registerEmpDto.birthMonth = registerEmpForm.birthMonth;
        registerEmpDto.birthDay = registerEmpForm.birthDay;
        registerEmpDto.cellphoneNum = registerEmpForm.cellphoneNum;
        registerEmpDto.contactStatus = registerEmpForm.contactStatus;
        registerEmpDto.memo = registerEmpForm.memo;
        registerEmpDto.displayContactStatus = changeCharacterDisplay
                .contactStatusForDisplay(registerEmpForm.contactStatus);

        return "confirm.jsp";
    }

    /**
     * 社員情報登録する。 登録完了後、社員情報登録完了画面表示 登録失敗後、エラー画面表示
     *
     * @return 社員登録完了画面の遷移パス
     */
    @Execute(validator = false)
    @RemoveSession(name="registerEmpDto")
    public String registerEmp() {

        registerEmpService.registerEmp(registerEmpDto);

        return "complete.jsp";
    }
}
