package jp.co.seattleconsulting.HumanRelationBuilding.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;

/**
 * エラー処理クラス.
 *
 * @author Tsuyoshi Nakamura
 */
public class ExceptionInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;

    /**
     * AbstractInterceptorを継承する際に、実装する必要のあるメソッド。
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        try {
            return invocation.proceed();
        } catch (Exception ex) {
            return "/error/";
        }
    }
}
