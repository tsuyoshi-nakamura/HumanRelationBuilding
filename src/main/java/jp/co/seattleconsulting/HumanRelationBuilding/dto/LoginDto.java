package jp.co.seattleconsulting.HumanRelationBuilding.dto;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

/**
 * ログインデータ転送オブジェクトクラス.
 *
 * @author Tsuyoshi Nakamura
 */
@Component(instance = InstanceType.SESSION)
public class LoginDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public String userId;
}
