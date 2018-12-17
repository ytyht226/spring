package com.jd58.mvcxml.viewresolver;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.view.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * Created by yanghuitao on 2018/8/30.
 */
@Data
public class CustomViewResolver extends UrlBasedViewResolver {
    public static final String JSP_URL_PREFIX = "jsp:";
    public static final String FTL_URL_PREFIX = "freemarker:";

    private static final boolean jstlPresent = ClassUtils.isPresent(
            "javax.servlet.jsp.jstl.core.Config", CustomViewResolver.class.getClassLoader());

    private Boolean exposePathVariables = false;

    private boolean exposeRequestAttributes = false;

    private boolean allowRequestOverride = false;

    private boolean exposeSessionAttributes = false;

    private boolean allowSessionOverride = false;

    private boolean exposeSpringMacroHelpers = true;

    public CustomViewResolver() {
        this.setViewClass(FreeMarkerView.class);
    }

    @Override
    protected AbstractUrlBasedView buildView(String viewName) throws Exception {
        if(viewName.startsWith(FTL_URL_PREFIX)) {
            return buildFreemarkerView(viewName.substring(FTL_URL_PREFIX.length()));
        } else if(viewName.startsWith(JSP_URL_PREFIX)) {
            Class viewCls = jstlPresent ? JstlView.class : InternalResourceView.class;
            return build(viewCls, viewName.substring(JSP_URL_PREFIX.length()), getPrefix(), ".jsp");
        } else {
            //默认以freemarker处理
            return buildFreemarkerView(viewName);
        }
    }

    private AbstractUrlBasedView build(Class viewClass, String viewName, String prefix, String suffix) {
        AbstractUrlBasedView view = (AbstractUrlBasedView) BeanUtils.instantiateClass(viewClass);
        view.setUrl(prefix + viewName + suffix);
        String contentType = getContentType();
        if (contentType != null) {
            view.setContentType(contentType);
        }
        view.setRequestContextAttribute(getRequestContextAttribute());
        view.setAttributesMap(getAttributesMap());
        if (this.exposePathVariables != null) {
            view.setExposePathVariables(exposePathVariables);
        }
        return view;
    }

    private AbstractUrlBasedView buildFreemarkerView(String viewName) throws Exception {
        AbstractTemplateView view = (AbstractTemplateView) build(FreeMarkerView.class, viewName, "", getSuffix());
        view.setExposeRequestAttributes(this.exposeRequestAttributes);
        view.setAllowRequestOverride(this.allowRequestOverride);
        view.setExposeSessionAttributes(this.exposeSessionAttributes);
        view.setAllowSessionOverride(this.allowSessionOverride);
        view.setExposeSpringMacroHelpers(this.exposeSpringMacroHelpers);
        return view;
    }
}