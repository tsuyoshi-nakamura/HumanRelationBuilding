package jp.co.seattleconsulting.HumanRelationBuilding.service;

import static jp.co.seattleconsulting.HumanRelationBuilding.constants.EmployeeConstants.*;
import jp.co.seattleconsulting.HumanRelationBuilding.dto.DeleteEmpDto;
import jp.co.seattleconsulting.HumanRelationBuilding.entity.Employee;
import jp.co.seattleconsulting.HumanRelationBuilding.util.ChangeCharacterDisplay;

import org.seasar.extension.jdbc.service.S2AbstractService;
import org.seasar.struts.annotation.Execute;

/**
 * 社員エンティティに対する操作を行うクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class DeleteEmpService extends S2AbstractService<Employee> {

    public static ChangeCharacterDisplay changeCharacterDisplay = new ChangeCharacterDisplay();

    /**
     * 社員情報の型を転送用の型に変更する.
     *
     * @parm userList：エンティティから受け取った社員情報
     *       deleteEmpDto：社員情報を保持するDTO
     * @return 転送用の型の社員情報
     */
    private DeleteEmpDto createDto(Employee employee, DeleteEmpDto deleteEmpDto) {
        deleteEmpDto.empId = employee.empId.toString();
        deleteEmpDto.lastnameKanji = employee.lastnameKanji;
        deleteEmpDto.firstnameKanji = employee.firstnameKanji;
        deleteEmpDto.lastnameKatakana = employee.lastnameKatakana;
        deleteEmpDto.firstnameKatakana = employee.firstnameKatakana;
        deleteEmpDto.birthYear = employee.birthYear;
        deleteEmpDto.birthMonth = employee.birthMonth;
        deleteEmpDto.birthDay = employee.birthDay;
        deleteEmpDto.cellphoneNum = employee.cellphoneNum;
        deleteEmpDto.displayContactStatus = changeCharacterDisplay.contactStatusForDisplay(employee.contactStatus);
        deleteEmpDto.memo = employee.memo;

        return deleteEmpDto;
    }

    /**
     * 社員情報取得
     *
     * @parm deleteEmpDto：対象の社員情報(社員ID)
     * @return 社員情報
     */
    @Execute(validator = false)
    public DeleteEmpDto getById(DeleteEmpDto deleteEmpDto) {
        Employee employee = select().id(deleteEmpDto.empId).getSingleResult();

        return createDto(employee, deleteEmpDto);
    }

    /**
     * 社員情報削除
     *
     * @parm deleteEmpDto：削除対象の社員情報
     * @return 削除した件数
     */
    @Execute(validator = false)
    public int deleteEmp(DeleteEmpDto deleteEmpDto) {
        Employee employee = new Employee();
        employee.empId = Integer.valueOf(deleteEmpDto.empId);
        employee.daleteFlag = DELETED;

        return jdbcManager.update(employee).includes("daleteFlag").execute();
    }
}
