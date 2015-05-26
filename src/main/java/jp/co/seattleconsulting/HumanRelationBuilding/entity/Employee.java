package jp.co.seattleconsulting.HumanRelationBuilding.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 社員entityクラス
 *
 * @author Tsuyoshi Nakamura
 */
@Entity
@Table(name = "emp")
public class Employee {

    public static final String TABLE = "emp";

    @Id
    @GeneratedValue
    @Column(name = "emp_id")
    public Integer empId;

    @Column(name = "lastname_kanji")
    public String lastnameKanji;

    @Column(name = "firstname_kanji")
    public String firstnameKanji;

    @Column(name = "lastname_katakana")
    public String lastnameKatakana;

    @Column(name = "firstname_katakana")
    public String firstnameKatakana;

    @Column(name = "birth_year")
    public String birthYear;

    @Column(name = "birth_month")
    public String birthMonth;

    @Column(name = "birth_day")
    public String birthDay;

    @Column(name = "cellphone_num")
    public String cellphoneNum;

    public String memo;

    @Column(name = "delete_flag")
    public Integer daleteFlag;

    @Column(name = "contact_status")
    public Integer contactStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "register_time")
    public Timestamp registerTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    public Timestamp updateTime;

}
