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
            <li><a href="/HumanRelationBuilding/">トップページ</a>  >  </li>
            <li>エラー</li>
        </ul>
        <section id="main-container">
            <html:errors/>
            <h1 id="title">Human Relation Building</h1>
            <h2 id="subtitle">エラー</h2>
            <section id="inner">
                <p class="message">内部エラーが発生しました。</p>
                <div class="btn-container column_01 clearfix">
                    <a class="btn" href="/HumanRelationBuilding/">TOP</a>
                </div>
            </section>
        </section>
        <jsp:include page="../common/footer.jsp" flush="true" />
    </body>
</html>