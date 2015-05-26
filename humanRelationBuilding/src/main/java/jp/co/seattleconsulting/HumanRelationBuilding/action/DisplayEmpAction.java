package jp.co.seattleconsulting.HumanRelationBuilding.action;

import java.util.List;

import javax.annotation.Resource;

import jp.co.seattleconsulting.HumanRelationBuilding.dto.DisplayEmpDto;
import jp.co.seattleconsulting.HumanRelationBuilding.form.DisplayEmpForm;
import jp.co.seattleconsulting.HumanRelationBuilding.service.DisplayEmpService;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * 社員情報表示処理の制御を行うクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class DisplayEmpAction {

    @ActionForm
    @Resource
    public DisplayEmpForm displayEmpForm;

    @Resource
    protected DisplayEmpService displayEmpService;

    public DisplayEmpDto displayEmpDto;
    public List<DisplayEmpDto> displayEmpDtoList;

    /**
     * 社員一覧画面表示
     *
     * @return 社員一覧画面の遷移パス
     */
    @Execute(validator = false)
    public String index() {

        displayEmpDtoList = displayEmpService.getAllDto();

        return "index.jsp";
    }

    /**
     * 社員情報詳細画面表示
     *
     * @return 社員情報詳細画面の遷移パス
     */
    @Execute(validator = false)
    public String detailEmp() {

        displayEmpDto.empId = displayEmpForm.empId;
        displayEmpDto = displayEmpService.getById(displayEmpDto);

        return "detail.jsp";
    }

    /**
     * 検索後、検索結果を表示
     *
     * @return 社員一覧画面の遷移パス
     */
    @Execute(validator = false)
    public String searchEmp() {

        displayEmpDtoList = displayEmpService.searchEmp(displayEmpForm.searchWord);

        return "index.jsp";
    }
}
