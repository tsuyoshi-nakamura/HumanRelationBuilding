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
            <li>社員一覧</li>
        </ul>
        <section id="main-container">
            <html:errors/>
            <h1 id="title">Human Relation Building</h1>
            <h2 id="subtitle">社員一覧</h2>
            <section id="inner">

                <c:choose>
                    <c:when test="${displayEmpDtoList.size() == 0 && (displayEmpForm.searchWord.length() == 0 || displayEmpForm.searchWord == null)}">
                        <p class="message">社員が登録されていません。<br />新規登録画面より社員を登録してください。</p>
		                <div class="btn-container column_01 clearfix">
		                    <a class="btn" href="/HumanRelationBuilding/registerEmp/">新規登録</a>
		                </div>
                    </c:when>
                    <c:otherwise>
                        <s:form>
	                        <div class="form-container clearfix">
	                            <input class="column_01" type="text" name="searchWord" placeholder="部分一致検索を行います。" value='${displayEmpForm.searchWord}'>
	                        </div>
	                        <div class="btn-container column_01 clearfix">
	                            <input class="btn" type="submit" name="searchEmp" value="検索" >
	                        </div>
                        </s:form>

                        <c:choose>
		                    <c:when test="${displayEmpDtoList.size() == 0}">
		                        <p class="message">${displayEmpForm.searchWord}に一致する情報は見つかりませんでした。<br />キーワードに誤字・脱字がないか確認してください。</p>
		                    </c:when>
		                    <c:otherwise>
				                <table id="emp-list">
				                    <tr>
				                        <th>名前</th>
				                        <th>フリガナ</th>
				                        <th>生年月日</th>
				                        <th>電話番号</th>
				                        <th>会話済み</th>
				                        <th>詳<br />細</th>
				                        <th>更<br />新</th>
				                        <th>削<br />除</th>
				                    </tr>

				                    <c:forEach var="employee" items="${displayEmpDtoList}">
				                        <tr>
				                            <td>${employee.lastnameKanji} ${employee.firstnameKanji}</td>
				                            <td>${employee.lastnameKatakana} ${employee.firstnameKatakana}</td>
				                            <td>${employee.birthYear}年${employee.birthMonth}月${employee.birthDay}日</td>
				                            <td>${employee.cellphoneNum}</td>
				                            <td>${employee.contactStatus}</td>
				                            <td class="btn-container">
				                                <form method="POST" action="/HumanRelationBuilding/displayEmp/detailEmp">
				                                    <input type="hidden" name="empId" value='${employee.empId}'>
				                                    <input class="small_btn" type="submit" name="detailEmp" value="●" >
				                                </form>
				                            </td>
				                            <td class="btn-container">
				                                <form method="POST" action="/HumanRelationBuilding/updateEmp/index">
				                                    <input type="hidden" name="empId" value='${employee.empId}'>
				                                    <input class="small_btn" type="submit" name="updateEmp" value="■" >
				                                </form>
				                            </td>
				                            <td class="btn-container">
				                                <form method="POST" action="/HumanRelationBuilding/deleteEmp/index">
				                                    <input type="hidden" name="empId" value='${employee.empId}'>
				                                    <input class="small_btn" type="submit" name="index" value="×" >
				                                </form>
				                            </td>
				                        </tr>
				                    </c:forEach>
				                </table>
				            </c:otherwise>
		                </c:choose>
                    </c:otherwise>
                </c:choose>
            </section>
        </section>
        <jsp:include page="../common/footer.jsp" flush="true" />
    </body>
</html>