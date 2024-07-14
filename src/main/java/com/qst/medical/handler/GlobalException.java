package com.qst.medical.handler;

import com.qst.medical.exception.CustomException;
import com.qst.medical.util.Msg;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;
import java.awt.font.ShapeGraphicAttribute;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 全局异常处理类
 *
 * @author liulindong
 * @since 2021年8月18日15:29:17
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(CustomException.class)
    public Msg exceptionHandler(HttpServletRequest request, HttpServletResponse response, CustomException e) {
        return Msg.fail().mess(e.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public Msg UserNotFoundHandler(HttpServletRequest request, HttpServletResponse response, UsernameNotFoundException e) {
        return Msg.fail().mess("用户不存在").code(10002);
    }

    /**
     * 接收前端json数据时校验异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Msg validParam(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        Msg msg = Msg.fail();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(error ->
            msg.data(error.getField(),error.getDefaultMessage())
        );
        return msg;
    }

    /**
     * 参数上加@RequestParam或属性加@NotBlank，@NotNull校验异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Msg constraintViolation(ConstraintViolationException e) {
        return Msg.fail().mess("jlj");
    }

    @ExceptionHandler(BindException.class)
    public Msg bindException(BindException e) {
        List<ObjectError> allErrors = e.getAllErrors();
        Msg msg = Msg.fail();
        allErrors.forEach(item -> {
            if (item.getObjectName().equals("medicalPolicyParam")) {
                msg.data("id", "编号只能为数字");
            }
        });
        return msg;
    }
}