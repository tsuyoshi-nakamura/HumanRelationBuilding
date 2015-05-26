package jp.co.seattleconsulting.HumanRelationBuilding.interceptor;

import javax.annotation.Resource;

import jp.co.seattleconsulting.HumanRelationBuilding.dto.LoginDto;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.struts.annotation.Execute;

/**
 * セッション上にユーザIDが保持されていたらログイン画面へ飛ばすクラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class LoginInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;

    @Resource
    protected LoginDto loginDto;

    /**
     * AbstractInterceptorを継承する際に、実装する必要のあるメソッド。
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        // 両方の条件を満たしていない場合、Loginページへ飛ばす。
        return (!isExecuteMethod(invocation) || isLoggedIn()) ? invocation
                .proceed() : "/login/?redirect=true";
    }

    /**
     * 実行されたActionに@Executeがついていたかどうか。
     *
     * @param invocation
     * @return アノテーションがついていればtrue
     */
    private boolean isExecuteMethod(MethodInvocation invocation) {
        return invocation.getMethod().isAnnotationPresent(Execute.class);
    }

    /**
     * セッション上にDtoがあるか、あった場合その中にuserIDは保持されているか。
     *
     * @return 上記の条件を両方満たしていればtrue
     */
    private boolean isLoggedIn() {
        return (loginDto != null && loginDto.userId != null);
    }
}
