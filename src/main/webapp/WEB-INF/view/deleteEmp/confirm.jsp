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
            <li><a href="../displayEmp">社員一覧</a>  >  </li>
            <li>削除：確認</li>
        </ul>
        <section id="main-container">
            <html:errors/>
            <h1 id="title">Human Relation Building</h1>
            <h2 id="subtitle">削除：確認</h2>
            <section id="inner">
                <s:form>
                    <input type="hidden" name="empId" value='${deleteEmpDto.empId}'>
                    <div class="emp-detail clearfix">
                        <input type="hidden" name="variableId">

                        <dl class="clearfix">
                            <dt>名前</dt>
                            <dd>${deleteEmpDto.lastnameKanji} ${deleteEmpDto.firstnameKanji}</dd>

                            <dt>フリガナ</dt>
                            <dd>${deleteEmpDto.lastnameKatakana} ${deleteEmpDto.firstnameKatakana}</dd>

                            <dt>生年月日</dt>
                            <dd>${deleteEmpDto.birthYear} 年 ${deleteEmpDto.birthMonth} 月 ${deleteEmpDto.birthDay} 日</dd>

                            <dt>電話番号（半角数字のみ）</dt>
                            <dd>${deleteEmpDto.cellphoneNum}</dd>

                            <dt>会話済み</dt>
                            <dd>${deleteEmpDto.displayContactStatus}</dd>

                            <dt>メモ（200文字以内）</dt>
                            <dd>${deleteEmpDto.memo}</dd>
                        </dl>
                    </div>

                    <p class="message">上記の社員データを削除してよろしいでしょうか？</p>

                    <div class="btn-container column_01 clearfix">
                        <input class="btn" type="submit" name="deleteEmp" value="削除" >
                    </div>
                </s:form>
            </section>
        </section>
        <jsp:include page="../common/footer.jsp" flush="true" />
    </body>
</html>