package jp.co.seattleconsulting.HumanRelationBuilding.action;

import javax.annotation.Resource;

import jp.co.seattleconsulting.HumanRelationBuilding.dto.DeleteEmpDto;
import jp.co.seattleconsulting.HumanRelationBuilding.form.DeleteEmpForm;
import jp.co.seattleconsulting.HumanRelationBuilding.service.DeleteEmpService;

import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * 社員情報削除処理の制御を行うクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class DeleteEmpAction {

    @ActionForm
    @Resource
    protected DeleteEmpForm deleteEmpForm;

    @Resource
    protected DeleteEmpService deleteEmpService;

    @Resource
    public DeleteEmpDto deleteEmpDto;

    /**
     * 社員情報削除確認画面表示
     *
     * @return 社員削除確認の遷移パス
     */
    @Execute(validator = false)
    public String index() {

        deleteEmpDto.empId = deleteEmpForm.empId;
        deleteEmpDto = deleteEmpService.getById(deleteEmpDto);

        return "confirm.jsp";
    }

    /**
     * 社員情報削除完了画面表示
     *
     * @return 社員削除完了画面の遷移パス
     */
    @Execute(validator = false)
    @RemoveSession(name = "deleteEmpDto")
    public String deleteEmp() {

        deleteEmpService.deleteEmp(deleteEmpDto);

        return "complete.jsp";
    }
}
