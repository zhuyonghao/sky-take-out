package com.sky.handler;

import com.sky.constant.MessageConstant;
import com.sky.exception.BaseException;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

    /**
     * 处理SQL完整性约束冲突异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHander(SQLIntegrityConstraintViolationException ex){
        //Cause: java.sql.SQLIntegrityConstraintViolationException:
        // Duplicate entry 'zhangxin' for key 'employee.idx_username'
        // 获取异常信息
        String message = ex.getMessage();
        if (message.contains("Duplicate entry")){
            // 将异常按照空格分开得到分开后的新数组
            String[] split = message.split(" ");
            // 获取用户名
            String username = split[2];
            // 添加常量作为返回内容
            String msg = username + MessageConstant.ALREADY_EXISTS;
            return Result.error(msg);
        }else {
            return Result.error(MessageConstant.UNKNOWN_ERROR);
        }
    }
}
