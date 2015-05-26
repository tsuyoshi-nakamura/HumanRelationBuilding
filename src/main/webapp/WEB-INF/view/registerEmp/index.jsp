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
            <li>新規登録：入力</li>
        </ul>
        <section id="main-container">
            <h1 id="title">Human Relation Building</h1>
            <h2 id="subtitle">新規登録：入力</h2>
            <section id="inner">
                <html:errors/>
                <s:form>
                    <div class="form-container clearfix">
                        <dl class="row clearfix">
                            <dt>名前</dt>
                            <dd><input class="column_02 left" type="text" name="lastnameKanji" placeholder="姓" value="${registerEmpForm.lastnameKanji}"><input class="column_02 right" type="text" name="firstnameKanji" placeholder="名" value="${registerEmpForm.firstnameKanji}"></dd>
                        </dl>

                        <dl class="row clearfix">
                            <dt>フリガナ</dt>
                            <dd><input class="column_02 left" type="text" name="lastnameKatakana" placeholder="セイ" value="${registerEmpForm.lastnameKatakana}"><input class="column_02 right" type="text" name="firstnameKatakana" placeholder="メイ" value="${registerEmpForm.firstnameKatakana}"></dd>
                        </dl>

                        <dl class="row clearfix">
                            <dt>生年月日</dt>
                            <dd>
                                <select name="birthYear">
                                    <option value="">----</option>
                                    <c:forEach begin="1900" end="2000" step="1" varStatus="status">
                                        <option value='${status.index}' ${registerEmpForm.birthYear == status.index ? 'selected="selected"' : ''}>${status.index}</option>
                                    </c:forEach>
                                </select> 年

                                <select name="birthMonth">
                                    <option value="">----</option>
                                    <c:forEach begin="1" end="12" step="1" varStatus="status">
                                        <option value='${status.index}' ${registerEmpForm.birthMonth == status.index ? 'selected="selected"' : ''}>${status.index}</option>
                                    </c:forEach>
                                </select> 月

                                <select name="birthDay">
                                    <option value="">----</option>
                                    <c:forEach begin="1" end="31" step="1" varStatus="status">
                                        <option value='${status.index}' ${registerEmpForm.birthDay == status.index ? 'selected="selected"' : ''}>${status.index}</option>
                                    </c:forEach>
                                </select> 日
                            </dd>
                        </dl>

                        <dl class="row clearfix">
                            <dt>電話番号（半角数字のみ）</dt>
                            <dd><input class="column_01" type="text" name="cellphoneNum" placeholder="例) 08012345678" value="${registerEmpForm.cellphoneNum}"></dd>
                        </dl>

                        <dl class="row clearfix">
                            <dt>会話済み</dt>
                            <dd>
                                <input type="radio" name="contactStatus" value="1" ${registerEmpForm.contactStatus=='1' ? 'checked="checked"' : ''}>はい
                                <input type="radio" name="contactStatus" value="0" ${registerEmpForm.contactStatus=='0' ? 'checked="checked"' : ''}>いいえ
                            </dd>
                        </dl>

                        <dl class="row clearfix">
                            <dt>メモ（必須 / 200文字以内）</dt>
                            <dd><textarea class="column_01" name="memo" cols="40" rows="5" maxlength="200" placeholder="特徴・会った場所等をご記入ください。">${registerEmpForm.memo}</textarea></dd>
                        </dl>

                    </div>
                    <div class="btn-container column_01 clearfix">
                        <input class="btn" type="submit" name="confirm" value="確認画面へ" >
                    </div>
                </s:form>
            </section>
        </section>
        <jsp:include page="../common/footer.jsp" flush="true" />
    </body>
</html>