package jp.co.seattleconsulting.HumanRelationBuilding.service;

import static jp.co.seattleconsulting.HumanRelationBuilding.constants.EmployeeConstants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.seattleconsulting.HumanRelationBuilding.dto.DisplayEmpDto;
import jp.co.seattleconsulting.HumanRelationBuilding.entity.Employee;
import jp.co.seattleconsulting.HumanRelationBuilding.util.ChangeCharacterDisplay;

import org.seasar.extension.jdbc.service.S2AbstractService;

/**
 * 社員エンティティに対する操作を行うクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class DisplayEmpService extends S2AbstractService<Employee> {

    public static ChangeCharacterDisplay changeCharacterDisplay = new ChangeCharacterDisplay();

    /**
     * 全ての社員情報を取得する.
     *
     * @return dictionaryListDto：DTOクラスのリスト
     */
    public List<DisplayEmpDto> getAllDto() {
        List<Employee> employeeList = findAll();
        List<DisplayEmpDto> displayEmpDtoList = createDto(employeeList);

        return displayEmpDtoList;
    }

    /**
     * 全ての社員情報の型を転送用の型に変更する.
     *
     * @parm userList：社員情報一覧
     * @return 転送用の型の削除されていない社員情報
     */
    private List<DisplayEmpDto> createDto(List<Employee> employeeList) {
        List<DisplayEmpDto> displayEmpDtoList = new ArrayList<DisplayEmpDto>();

        /**
         * エンティティから受け取った
         * 削除されていない社員情報を
         * 転送用の型の社員情報のリストに入れる。
         */
        for (Employee employee : employeeList) {
            DisplayEmpDto displayEmpDto = new DisplayEmpDto();
            displayEmpDto.empId = employee.empId.toString();
            displayEmpDto.lastnameKanji = employee.lastnameKanji;
            displayEmpDto.firstnameKanji = employee.firstnameKanji;
            displayEmpDto.lastnameKatakana = employee.lastnameKatakana;
            displayEmpDto.firstnameKatakana = employee.firstnameKatakana;
            displayEmpDto.birthYear = employee.birthYear;
            displayEmpDto.birthMonth = employee.birthMonth;
            displayEmpDto.birthDay = employee.birthDay;
            displayEmpDto.cellphoneNum = employee.cellphoneNum;
            displayEmpDto.contactStatus = changeCharacterDisplay.contactStatusForDisplay(employee.contactStatus);
            displayEmpDto.memo = employee.memo;

            /**
             * 社員情報が論理的に削除されていなければ
             * 転送用の型の社員情報のリストに入れる。
             */
            if (employee.daleteFlag == NOT_DELETE) {
                displayEmpDtoList.add(displayEmpDto);
            }
        }

        return displayEmpDtoList;
    }

    /**
     * 全ての社員情報の型を転送用の型に変更する.
     *
     * @parm employeeMap：社員情報一覧
     * @return 転送用の型の削除されていない社員情報
     */
    private List<DisplayEmpDto> createDto(Map<Integer, Employee> employeeMap) {
        List<DisplayEmpDto> displayEmpDtoList = new ArrayList<DisplayEmpDto>();

        /**
         * エンティティから受け取った
         * 削除されていない社員情報を
         * 転送用の型の社員情報のリストに入れる。
         */
        for (Map.Entry<Integer, Employee> employee : employeeMap.entrySet()) {
            DisplayEmpDto displayEmpDto = new DisplayEmpDto();
            displayEmpDto.empId = employee.getValue().empId.toString();
            displayEmpDto.lastnameKanji = employee.getValue().lastnameKanji;
            displayEmpDto.firstnameKanji = employee.getValue().firstnameKanji;
            displayEmpDto.lastnameKatakana = employee.getValue().lastnameKatakana;
            displayEmpDto.firstnameKatakana = employee.getValue().firstnameKatakana;
            displayEmpDto.birthYear = employee.getValue().birthYear;
            displayEmpDto.birthMonth = employee.getValue().birthMonth;
            displayEmpDto.birthDay = employee.getValue().birthDay;
            displayEmpDto.cellphoneNum = employee.getValue().cellphoneNum;
            displayEmpDto.contactStatus = changeCharacterDisplay.contactStatusForDisplay(employee.getValue().contactStatus);
            displayEmpDto.memo = employee.getValue().memo;

            /**
             * 社員情報が論理的に削除されていなければ
             * 転送用の型の社員情報のリストに入れる。
             */
            if (employee.getValue().daleteFlag == NOT_DELETE) {
                displayEmpDtoList.add(displayEmpDto);
            }
        }

        return displayEmpDtoList;
    }

    /**
     * 社員情報の型を転送用の型に変更する.
     *
     * @parm userList：エンティティから受け取った社員情報
     *       displayEmpDto：社員情報を保持するDTO
     * @return 転送用の型の社員情報
     */
    private DisplayEmpDto createDto(Employee employee, DisplayEmpDto displayEmpDto) {
        displayEmpDto.empId = employee.empId.toString();
        displayEmpDto.lastnameKanji = employee.lastnameKanji;
        displayEmpDto.firstnameKanji = employee.firstnameKanji;
        displayEmpDto.lastnameKatakana = employee.lastnameKatakana;
        displayEmpDto.firstnameKatakana = employee.firstnameKatakana;
        displayEmpDto.birthYear = employee.birthYear;
        displayEmpDto.birthMonth = employee.birthMonth;
        displayEmpDto.birthDay = employee.birthDay;
        displayEmpDto.cellphoneNum = employee.cellphoneNum;
        displayEmpDto.contactStatus = changeCharacterDisplay.contactStatusForDisplay(employee.contactStatus);
        displayEmpDto.memo = employee.memo;

        return displayEmpDto;
    }

    /**
     * 社員情報取得
     *
     * @parm displayEmpDto：社員IDが入った転送用オブジェクト
     * @return 社員情報
     */
    public DisplayEmpDto getById(DisplayEmpDto displayEmpDto) {
        Employee employee = select().id(displayEmpDto.empId).getSingleResult();

        return createDto(employee, displayEmpDto);
    }

    /**
     * 社員情報検索
     *
     * @parm searchWordString：検索ワード
     * @return 社員情報
     */
    public List<DisplayEmpDto> searchEmp(String searchWordString) {

        List<Employee> employeeList = new ArrayList<Employee>();
        List<DisplayEmpDto> displayEmpDtoList = new ArrayList<DisplayEmpDto>();
        Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
        String[] searchWords = splitSearchWord(searchWordString);

        for (String str : searchWords) {
            String searchWord = "%" + str + "%";
            employeeList = jdbcManager
                    .selectBySqlFile(Employee.class,
                            "sql/search_emp.sql",
                            searchWord)
                    .getResultList();
            for (Employee employee : employeeList) {
                employeeMap.put(employee.empId, employee);
            }
        }
        displayEmpDtoList = createDto(employeeMap);

        return displayEmpDtoList;
    }

    /**
     * 検索ワードを空白ごとに分解
     *
     * @parm searchWord：検索ワード
     * @return 分解された検索ワード
     */
    private String[] splitSearchWord(String searchWord) {
        searchWord = searchWord.replaceAll("　", " ");
        searchWord = searchWord.trim();
        searchWord = searchWord.replaceAll("  *", " ");

        return searchWord.split(" ");
    }
}
