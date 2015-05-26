package jp.co.seattleconsulting.HumanRelationBuilding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ユーザentityクラス
 *
 * @author Tsuyoshi Nakamura
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    public String userId;

    public String password;

    @Column(name = "delete_flag")
    public Boolean daleteFlag;
}
