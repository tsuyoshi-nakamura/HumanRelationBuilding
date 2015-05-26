package jp.co.seattleconsulting.HumanRelationBuilding.util;

import jp.co.seattleconsulting.HumanRelationBuilding.dto.RegisterEmpDto;
import jp.co.seattleconsulting.HumanRelationBuilding.dto.UpdateEmpDto;
import jp.co.seattleconsulting.HumanRelationBuilding.form.RegisterEmpForm;
import jp.co.seattleconsulting.HumanRelationBuilding.form.UpdateEmpForm;

public class ChangeClassType {
    public RegisterEmpDto changeToRegisterEmpDto (RegisterEmpForm registerEmpForm) {
        RegisterEmpDto registerEmpDto = new RegisterEmpDto();

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

        return registerEmpDto;
    }

    public UpdateEmpDto changeToUpdateEmpDto (UpdateEmpForm updateEmpForm) {
        UpdateEmpDto updateEmpDto = new UpdateEmpDto();

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

        return updateEmpDto;
    }
}
