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
        <jsp:include page="common/header.jsp" flush="true" />
        <section id="main-container">
            <html:errors/>
            <h1 id="title">Human Relation Building</h1>
            <h2 id="subtitle">トップページ</h2>
            <section id="inner">
                <div id="dashboard">
                    <h3 class="inner-title">ダッシュボード</h3>
                    <dl>
                        <dt>話した人</dt>
                        <dd><span class="ltxt">${indexDto.talkedMembers}</span>人</dd>
                    </dl>
                    <dl>
                        <dt>話してない人</dt>
                        <dd><span class="ltxt">${indexDto.NottalkedMembers}</span>人</dd>
                    </dl>
                    <dl>
                        <dt>全員</dt>
                        <dd><span class="ltxt">${indexDto.allMembers}</span>人</dd>
                    </dl>
                    <dl>
                        <dt>話した人の割合</dt>
                        <dd><span class="ltxt">${indexDto.talkedMembersPercentage}</span>%</dd>
                    </dl>
                </div>

                <div class="btn-container column_02 clearfix">
                    <a class="btn" href="/HumanRelationBuilding/displayEmp">社員一覧</a>
                    <a class="btn" href="/HumanRelationBuilding/registerEmp">新規登録</a>
                </div>
            </section>
        </section>
        <jsp:include page="common/footer.jsp" flush="true" />
    </body>
</html>