package org.seasar.struts.action;

import org.apache.struts.action.ActionMapping;
import org.seasar.framework.container.S2Container;

/**
 * ActionMapping����A�R���|�[�g�����쐬���邽�߂̃C���^�[�t�F�[�X�B
 * 
 * @author Satoshi Kimura
 */
public interface ComponentNameCreator {
    /**
     * ActionMapping����R���|�[�l���g�����A�쐬���A���̃R���|�[�l���g�����g�p�Ώۂ̃R���e�i�Ɍ�����Ȃ���΁A path���R���|�[�l���g���Ƃ��ĕԂ��B
     * 
     * @param container �����Ώۂ̃R���e�i
     * @param mapping �R���e�i�����쐬����̂Ɏg�p����}�b�s���O
     * @return �R���e�i��
     */
    String createComponentName(S2Container container, ActionMapping mapping);
}