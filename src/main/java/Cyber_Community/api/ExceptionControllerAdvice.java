package Cyber_Community.api;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Enzo Cotter on 09/03/2022.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView
    defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        // Si la excepción está anotada con @ResponseStatus se relanza
        // y se deja que el framework la maneje - como el ejemplo
        // OrderNotFoundException al comienzo de esta entrada.
        // AnnotationUtils es una clase de utilidad el Framework Spring.
        if (AnnotationUtils.findAnnotation
                (e.getClass(), ResponseStatus.class) != null)
            throw e;

        // En otro caso, configura y envía al usuario a la vista de error por defecto.
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

}
