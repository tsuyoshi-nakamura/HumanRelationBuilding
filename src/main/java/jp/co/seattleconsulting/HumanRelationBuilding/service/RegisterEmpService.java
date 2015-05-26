package jp.co.seattleconsulting.HumanRelationBuilding.service;

import static jp.co.seattleconsulting.HumanRelationBuilding.constants.EmployeeConstants.*;
import jp.co.seattleconsulting.HumanRelationBuilding.dto.RegisterEmpDto;
import jp.co.seattleconsulting.HumanRelationBuilding.entity.Employee;
import jp.co.seattleconsulting.HumanRelationBuilding.util.ChangeCharacterDisplay;

import org.seasar.extension.jdbc.service.S2AbstractService;

/**
 * 社員エンティティに対する操作を行うクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class RegisterEmpService extends S2AbstractService<Employee> {

    public static ChangeCharacterDisplay changeCharacterDisplay = new ChangeCharacterDisplay();

    /**
     * 社員情報を登録する.
     *
     * @parm registerEmpDto：登録する社員情報
     * @return 登録件数
     */
    public int registerEmp(RegisterEmpDto registerEmpDto) {
        Employee employee = new Employee();

        employee.lastnameKanji = registerEmpDto.lastnameKanji;
        employee.firstnameKanji = registerEmpDto.firstnameKanji;
        employee.lastnameKatakana = registerEmpDto.lastnameKatakana;
        employee.firstnameKatakana = registerEmpDto.firstnameKatakana;
        employee.birthYear = registerEmpDto.birthYear;
        employee.birthMonth = registerEmpDto.birthMonth;
        employee.birthDay = registerEmpDto.birthDay;
        employee.cellphoneNum = registerEmpDto.cellphoneNum;
        employee.daleteFlag = NOT_DELETE;
        employee.contactStatus = changeCharacterDisplay.contactStatusForDB(registerEmpDto.contactStatus);
        employee.memo = registerEmpDto.memo;

        return insert(employee);
    }
}
