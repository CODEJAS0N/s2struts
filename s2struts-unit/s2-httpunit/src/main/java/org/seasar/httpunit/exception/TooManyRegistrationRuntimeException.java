/*
 * Copyright 2004-2006 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
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