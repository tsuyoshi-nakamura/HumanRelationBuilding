/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package jp.co.seattleconsulting.HumanRelationBuilding.action;

import javax.annotation.Resource;

import jp.co.seattleconsulting.HumanRelationBuilding.dto.IndexDto;
import jp.co.seattleconsulting.HumanRelationBuilding.service.IndexService;

import org.seasar.struts.annotation.Execute;

/**
 * トップ画面の処理の制御を行うクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class IndexAction {

    @Resource
    protected IndexService indexService;

    public IndexDto indexDto;

    /**
     * トップ画面表示
     *
     * @return トップ画面の遷移パス
     */
    @Execute(validator = false)
    public String index() {

        int allMembersNum = indexService.getAllMembersNum();
        int talkedMembersNum = indexService.getTalkedMembersNum();
        int notTalkedMembers = allMembersNum - talkedMembersNum;
        int talkedMembersPercentage;
        if (0 < allMembersNum) {
            talkedMembersPercentage = (talkedMembersNum * 100) / allMembersNum;
        } else {
            talkedMembersPercentage = 0;
        }

        indexDto.allMembers = String.valueOf(allMembersNum);
        indexDto.talkedMembers = String.valueOf(talkedMembersNum);
        indexDto.notTalkedMembers = String.valueOf(notTalkedMembers);
        indexDto.talkedMembersPercentage = String.valueOf(talkedMembersPercentage);

        return "index.jsp";
    }
}
