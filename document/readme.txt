1.���̴��
1.1 ����֮���ϵ
                       admin-parent
                            |
                         �̳С��ۺ�
                            |
    admin-webui ----> admin-component ----> admin-entity
                            |
                           ����
                            |
                        common-util

1.2 Maven���ڰ�װ˳���Ҫ��
1.2.1 ������ϵ�԰�װ˳���Ҫ��
A ���� B
Maven Ҫ���Ȱ�װ B���ٰ�װ A
1.2.2 �̳й�ϵ�԰�װ˳���Ҫ��
A���ӹ��̣��̳� B�������̣�
Maven Ҫ���Ȱ�װ B�������̣����ٰ�װ A���ӹ��̣�

������þۺϣ���ô�ԾۺϹ���ִ�� install ���Maven �ͻ��Զ�������ȷ��˳��װ����ģ�鹤�̡�

������������ common-util ����û�в���ۺϣ�����Ҫ�ȵ����� common-utilִ�а�װ��

1.3
maven��install�������Ѿ�ִ�д����������ٲ���Ҫִ��package����

��ִ��common-util�İ�װ��
    mvn clear install