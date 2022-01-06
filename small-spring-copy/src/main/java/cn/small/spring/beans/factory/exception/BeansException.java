package cn.small.spring.beans.factory.exception;

/**
 * @Classname BeansException
 * @Description TODO
 * @Date 2022/1/5 20:37
 * @Created by baiyu768
 */
public class BeansException extends RuntimeException{

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
