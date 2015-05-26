<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta charset="UTF-8" />
        <title>Human Relation Building</title>
        <link rel="stylesheet" href='${f:url("/css/reset.css")}'>
        <link rel="stylesheet" href='${f:url("/css/style.css")}'>
    </head>

    <body>
        <jsp:include page="../common/header.jsp" flush="true" />
        <ul id="breadcrumbs-list" class="clearfix">
            <li><a href="../">トップページ</a>  >  </li>
            <li><a href="index">社員一覧</a>  >  </li>
            <li>社員詳細</li>
        </ul>
        <section id="main-container">
            <html:errors/>
            <h1 id="title">Human Relation Building</h1>
            <h2 id="subtitle">社員詳細</h2>
            <section id="inner">
                    <div class="emp-detail clearfix">
                        <input type="hidden" name="variableId">

                        <dl class="row clearfix">
                            <dt>名前</dt>
                            <dd>${displayEmpDto.lastnameKanji} ${displayEmpDto.firstnameKanji}</dd>

                            <dt>フリガナ</dt>
                            <dd>${displayEmpDto.lastnameKatakana} ${displayEmpDto.firstnameKatakana}</dd>

                            <dt>生年月日</dt>
                            <dd>${displayEmpDto.birthYear} 年 ${displayEmpDto.birthMonth} 月 ${displayEmpDto.birthDay} 日</dd>

                            <dt>電話番号（半角数字のみ）</dt>
                            <dd>${displayEmpDto.cellphoneNum}</dd>

                            <dt>会話済み</dt>
                            <dd>${displayEmpDto.contactStatus}</dd>

                            <dt>メモ（200文字以内）</dt>
                            <dd>${displayEmpDto.memo}</dd>
                        </dl>
                    </div>

                    <form id="updateEmp" method="POST" action="/HumanRelationBuilding/updateEmp/index">
                        <input type="hidden" name="empId" value='${displayEmpDto.empId}'>
                    </form>

                    <form id="deleteEmp" method="POST" action="/HumanRelationBuilding/deleteEmp/index">
                        <input type="hidden" name="empId" value='${displayEmpDto.empId}'>
                    </form>

                    <div class="btn-container column_02 clearfix">
	                    <input form="updateEmp" class="btn" type="submit" name="updateEmp" value="更新" >
	                    <input form="deleteEmp" class="btn" type="submit" name="deleteEmp" value="削除" >
                    </div>
            </section>
        </section>
        <jsp:include page="../common/footer.jsp" flush="true" />
    </body>
</html>