package org.seasar.httpunit.exception;

/**
 * �T�[�u���b�g���N���X���Ŏ擾���悤�Ƃ����ꍇ�ɁA web.xml�ɓ����N���X�̃T�[�u���b�g��2�ȏ�o�^����Ă���ꍇ�ɔ������܂��B
 * 
 * @author Satoshi Kimura
 */
public class TooManyRegistrationRuntimeException extends RuntimeException {
    /**
     *
     */
    public TooManyRegistrationRuntimeException() {
        super();
    }

    /**
     * @param message
     */
    public TooManyRegistrationRuntimeException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public TooManyRegistrationRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public TooManyRegistrationRuntimeException(Throwable cause) {
        super(cause);
    }
}