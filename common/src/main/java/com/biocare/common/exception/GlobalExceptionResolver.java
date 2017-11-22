package com.biocare.common.exception;

import com.biocare.common.bean.ResponseWrapper;
import com.biocare.common.em.GlobalErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 全局异常解析器
 *
 * @author mariston
 * @version V1.0
 * @since 2016/10/9
 */
public class GlobalExceptionResolver extends SimpleMappingExceptionResolver {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    /**
     * Actually resolve the given exception that got thrown during on handler execution,
     * returning a ModelAndView that represents a specific error page if appropriate.
     * <p>May be overridden in subclasses, in order to apply specific exception checks.
     * Note that this template method will be invoked <i>after</i> checking whether this
     * resolved applies ("mappedHandlers" etc), so an implementation may simply proceed
     * with its actual exception handling.
     *
     * @param request  current HTTP request
     * @param response current HTTP response
     * @param handler  the executed handler, or {@code null} if none chosen at the time
     *                 of the exception (for example, if multipart resolution failed)
     * @param ex       the exception that got thrown during handler execution
     * @return a corresponding ModelAndView to forward to, or {@code null} for default processing
     */
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String viewName = determineViewName(ex, request);
        response.setCharacterEncoding("UTF-8");
        if (!(request.getHeader("accept").contains("application/json") || (request.getHeader("X-Requested-With") != null && request
                .getHeader("X-Requested-With").contains("XMLHttpRequest")))) {
            // 如果不是异步请求
            // Apply HTTP status code for error views, if specified.
            // Only apply it if we're processing a top-level request.
            Integer statusCode = determineStatusCode(request, viewName);
            if (statusCode != null) {
                applyStatusCodeIfPossible(request, response, statusCode);
            }
            logger.debug("=====JSP格式返回：{}", viewName);
            return getModelAndView(viewName, ex, request);
        } else {// JSON格式返回
            try {
                PrintWriter writer = response.getWriter();
                BioException be = ex instanceof BioException ? (BioException) ex : BioException.create(GlobalErrorCode.FAIL);
                ResponseWrapper wrapper = ResponseWrapper.create(be);
                writer.write(wrapper.toString());
                writer.flush();
                writer.close();
                logger.debug("======JSON格式返回：{}", wrapper);
            } catch (IOException e) {
                logger.error("====JSON格式返回异常", e);
            }
            return null;
        }
    }
}
