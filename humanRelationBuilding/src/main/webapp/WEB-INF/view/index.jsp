<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta charset="UTF-8" />
        <title>Human Relation Building</title>
        <link rel="stylesheet" href='${f:url("/css/reset.css")}'>
        <link rel="stylesheet" href='${f:url("/css/style.css")}'>
		<script type="text/javascript">

		alert('<%=request.getContextPath()%>');

		function getJson() {
		    var data = {
		    		  "talked_members":"Penguin Statue",
		    		  "not_talked_memberst":20,
		    		  "all_members":0.25,
		    		  "talked_members_percentage":"かわいいペ物"
		    		}
            var elem = document.getElementById("talked_members");
            elem.innerText = data.talked_members;
            var elem = document.getElementById("not_talked_members");
            elem.innerText = data.not_talked_members;
            var elem = document.getElementById("all_members");
            elem.innerText = data.all_members;
            var elem = document.getElementById("talked_members_percentage");
            elem.innerText = data.talked_members_percentage;
		 }
		</script>
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
                    <input id="Button_Get" type="button" value="JSON読み込み" onclick="getJson();" />
                    <dl>
                        <dt>話した人</dt>
                        <dd><span id="talked_members" class="ltxt"></span>人</dd>
                    </dl>
                    <dl>
                        <dt>話してない人</dt>
                        <dd><span id="not_talked_members" class="ltxt"></span>人</dd>
                    </dl>
                    <dl>
                        <dt>全員</dt>
                        <dd><span id="all_members" class="ltxt"></span>人</dd>
                    </dl>
                    <dl>
                        <dt>話した人の割合</dt>
                        <dd><span id="talked_members_percentage" class="ltxt"></span>%</dd>
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