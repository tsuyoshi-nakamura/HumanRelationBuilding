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
            <li>削除：完了</li>
        </ul>
        <section id="main-container">
            <h1 id="title">Human Relation Building</h1>
            <h2 id="subtitle">削除：完了</h2>
            <section id="inner">
                <p class="message">社員の削除が完了しました。</p>
                <div class="btn-container column_02 clearfix">
                    <a class="btn" href="../">TOP</a>
                    <a class="btn" href="../displayEmp/">社員一覧</a>
                </div>
            </section>
        </section>
        <jsp:include page="../common/footer.jsp" flush="true" />
    </body>
</html>