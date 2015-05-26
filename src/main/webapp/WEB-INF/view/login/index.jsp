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
        <section id="main-container">
            <h1 id="title">Human Relation Building</h1>
            <h2 id="subtitle">ログイン画面</h2>
            <section id="inner">
                <html:errors/>
                <s:form>
                    <div class="form-container clearfix">
                        <input type="hidden" name="variableId">
                        <input class="column_01" type="text" name="userId" placeholder="ユーザID">
                        <input class="column_01 last" type="text" name="password" placeholder="パスワード">
                    </div>
                    <div class="btn-container column_01 clearfix">
                        <input class="btn" type="submit" name="login" value="ログイン" >
                    </div>
                </s:form>
            </section>
        </section>
    </body>
</html>