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
package org.seasar.struts.unit.util;

import java.lang.reflect.Method;

import org.seasar.framework.exception.NoSuchMethodRuntimeException;

/**
 * <p>
 * public�ȊO�̃��\�b�h�̎��s���\�ɂ��郆�[�e�B���e�B�[�ł��B
 * </p>
 * <p>
 * �w�肵�����\�b�h�����݂��Ȃ��ꍇ�ɂ́A�e�N���X���Q�Ƃ��A���\�b�h���������܂��B
 * </p>
 * 
 * @author Satoshi Kimura
 */
public class MethodUtil {

    private MethodUtil() {
    }

    /**
     * �w�肵�����\�b�h�����s���܂��B
     * 
     * @param target ���s�Ώۂ̃I�u�W�F�N�g
     * @param methodName ���\�b�h�̖��O
     * @param parameterTypes �p�����[�^�̌^��\���z��
     * @param args ���\�b�h�Ăяo���Ɏg�p��������
     * @return ���s�������\�b�h�̖߂�l
     */
    public static Object invoke(Object target, String methodName, Class[] parameterTypes, Object[] args) {
        Class clazz = target.getClass();

        try {
            return invoke(clazz, target, methodName, parameterTypes, args);
        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodRuntimeException(clazz, methodName, parameterTypes, e);
        }
    }

    private static Object invoke(Class targetClass, Object target, String methodName, Class[] parameterTypes,
            Object[] args) throws NoSuchMethodException {
        try {
            Method method = targetClass.getDeclaredMethod(methodName, parameterTypes);
            method.setAccessible(true);

            return org.seasar.framework.util.MethodUtil.invoke(method, target, args);
        } catch (NoSuchMethodException e) {
            Class superClass = targetClass.getSuperclass();

            if (superClass != null) {
                return invoke(superClass, target, methodName, parameterTypes, args);
            } else {
                throw e;
            }
        }
    }
}