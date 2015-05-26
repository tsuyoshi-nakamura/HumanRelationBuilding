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
            <li>新規登録：確認</li>
        </ul>
        <section id="main-container">
            <html:errors/>
            <h1 id="title">Human Relation Building</h1>
            <h2 id="subtitle">新規登録：確認</h2>
            <section id="inner">
                <s:form>
                    <div class="emp-detail clearfix">
                        <dl class="clearfix">
                            <dt>名前</dt>
                            <dd>${registerEmpDto.lastnameKanji} ${registerEmpDto.firstnameKanji}</dd>

                            <dt>フリガナ</dt>
                            <dd>${registerEmpDto.lastnameKatakana} ${registerEmpDto.firstnameKatakana}</dd>

                            <dt>生年月日</dt>
                            <dd>${registerEmpDto.birthYear} 年 ${registerEmpDto.birthMonth} 月 ${registerEmpDto.birthDay} 日</dd>

                            <dt>電話番号（半角数字のみ）</dt>
                            <dd>${registerEmpDto.cellphoneNum}</dd>

                            <dt>会話済み</dt>
                            <dd>${registerEmpDto.displayContactStatus}</dd>

                            <dt>メモ（200文字以内）</dt>
                            <dd>${registerEmpDto.memo}</dd>
                        </dl>
                    </div>

                    <p class="message">上記の内容でよろしいでしょうか？</p>

                    <div class="btn-container column_02 clearfix">
                        <input class="btn" type="submit" name="goBackIndex" value="戻る" >
                        <input class="btn" type="submit" name="registerEmp" value="登録" >
                    </div>
                </s:form>
            </section>
        </section>
        <jsp:include page="../common/footer.jsp" flush="true" />
    </body>
</html>