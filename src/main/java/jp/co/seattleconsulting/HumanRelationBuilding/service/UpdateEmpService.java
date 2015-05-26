package jp.co.seattleconsulting.HumanRelationBuilding.service;

import static jp.co.seattleconsulting.HumanRelationBuilding.constants.EmployeeConstants.*;

import java.sql.Timestamp;

import jp.co.seattleconsulting.HumanRelationBuilding.dto.UpdateEmpDto;
import jp.co.seattleconsulting.HumanRelationBuilding.entity.Employee;
import jp.co.seattleconsulting.HumanRelationBuilding.util.ChangeCharacterDisplay;

import org.seasar.extension.jdbc.service.S2AbstractService;

/**
 * 社員エンティティに対する操作を行うクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class UpdateEmpService extends S2AbstractService<Employee> {

    public static ChangeCharacterDisplay changeCharacterDisplay = new ChangeCharacterDisplay();

    /**
     * 社員情報の型を転送用の型に変更する.
     *
     * @parm userList：エンティティから受け取った社員情報
     *       deleteEmpDto：社員情報を保持するDTO
     * @return 転送用の型の社員情報
     */
    private UpdateEmpDto createDto(Employee employee, UpdateEmpDto updateEmpDto) {
        updateEmpDto.empId = employee.empId.toString();
        updateEmpDto.lastnameKanji = employee.lastnameKanji;
        updateEmpDto.firstnameKanji = employee.firstnameKanji;
        updateEmpDto.lastnameKatakana = employee.lastnameKatakana;
        updateEmpDto.firstnameKatakana = employee.firstnameKatakana;
        updateEmpDto.birthYear = employee.birthYear;
        updateEmpDto.birthMonth = employee.birthMonth;
        updateEmpDto.birthDay = employee.birthDay;
        updateEmpDto.cellphoneNum = employee.cellphoneNum;
        updateEmpDto.contactStatus = changeCharacterDisplay.contactStatusForForm(employee.contactStatus);
        updateEmpDto.memo = employee.memo;

        return updateEmpDto;
    }

    /**
     * 社員情報取得
     *
     * @parm deleteEmpDto：対象の社員情報(社員ID)
     * @return 社員情報
     */
    public UpdateEmpDto getById(UpdateEmpDto updateEmpDto) {
        Employee employee = select().id(updateEmpDto.empId).getSingleResult();

        return createDto(employee, updateEmpDto);
    }

    /**
     * 社員情報更新
     *
     * @parm updateEmpDto：更新対象の社員情報
     * @return 更新した件数
     */
    public int updateEmp(UpdateEmpDto updateEmpDto) {
        Employee employee = new Employee();

        employee.empId = Integer.valueOf(updateEmpDto.empId);
        employee.lastnameKanji = updateEmpDto.lastnameKanji;
        employee.firstnameKanji = updateEmpDto.firstnameKanji;
        employee.lastnameKatakana = updateEmpDto.lastnameKatakana;
        employee.firstnameKatakana = updateEmpDto.firstnameKatakana;
        employee.birthYear = updateEmpDto.birthYear;
        employee.birthMonth = updateEmpDto.birthMonth;
        employee.birthDay = updateEmpDto.birthDay;
        employee.cellphoneNum = updateEmpDto.cellphoneNum;
        employee.daleteFlag = NOT_DELETE;
        employee.contactStatus = changeCharacterDisplay.contactStatusForDB(updateEmpDto.contactStatus);
        employee.memo = updateEmpDto.memo;
        employee.updateTime = new Timestamp(System.currentTimeMillis());

        return jdbcManager.update(employee).excludes("registerTime").execute();
    }
}
