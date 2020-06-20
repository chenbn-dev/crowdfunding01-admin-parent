package cn.chenbonian.crowdfunding.handler;

import cn.chenbonian.crowdfunding.api.MySQLRemoteService;
import cn.chenbonian.crowdfunding.constant.CrowdConstant;
import cn.chenbonian.crowdfunding.entity.vo.AddressVO;
import cn.chenbonian.crowdfunding.entity.vo.MemberLoginVO;
import cn.chenbonian.crowdfunding.entity.vo.OrderProjectVO;
import cn.chenbonian.crowdfunding.util.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author chbn
 * @create 2020-06-20 17:30
 */
@Controller
public class OrderHandler {

  @Autowired private MySQLRemoteService mySQLRemoteService;

  private Logger logger = LoggerFactory.getLogger(OrderHandler.class);

  @RequestMapping("/save/address")
  public String saveAddress(AddressVO addressVO, HttpSession session) {
    // 1.ִ�е�ַ��Ϣ�ı���
    ResultEntity<String> resultEntity = mySQLRemoteService.saveAddressRemote(addressVO);
    logger.debug("��ַ���洦������" + resultEntity.getResult());
    // 2.��Session���ȡorderProjectVO����
    OrderProjectVO orderProjectVO = (OrderProjectVO) session.getAttribute("orderProjectVO");
    // 3.��orderProjectVO�����л�ȡreturnCount
    Integer returnCount = orderProjectVO.getReturnCount();
    // 4.�ض���ָ����ַ�����½���ȷ�϶���ҳ��
    return "redirect:http://localhost/order/confirm/order/" + returnCount;
  }

  @RequestMapping("/confirm/order/{returnCount}")
  public String showConfirmOrderInfo(
      @PathVariable("returnCount") Integer returnCount, HttpSession session) {
    // 1.�ѽ��յ��Ļر������ϲ���Session��
    OrderProjectVO orderProjectVO = (OrderProjectVO) session.getAttribute("orderProjectVO");
    orderProjectVO.setReturnCount(returnCount);
    session.setAttribute("orderProjectVO", orderProjectVO);
    // 2.��ȡ��ǰ�ѵ�¼�û���id
    MemberLoginVO memberLoginVO =
        (MemberLoginVO) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);
    Integer memberId = memberLoginVO.getId();
    // 3.��ѯĿǰ���ջ���ַ����
    ResultEntity<List<AddressVO>> resultEntity = mySQLRemoteService.getAddressVORemote(memberId);
    if (ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
      List<AddressVO> list = resultEntity.getData();
      session.setAttribute("addressVOList", list);
    }
    return "confirm_order";
  }

  @RequestMapping("/confirm/return/info/{projectId}/{returnId}")
  public String showReturnConfirmInfo(
      @PathVariable("projectId") Integer projectId,
      @PathVariable("returnId") Integer returnId,
      HttpSession session) {
    ResultEntity<OrderProjectVO> resultEntity =
        mySQLRemoteService.getOrderProjectVORemote(projectId, returnId);
    if (ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
      OrderProjectVO orderProjectVO = resultEntity.getData();

      // Ϊ���ܹ��ں��������б���orderProjectVO���ݣ�����Session��
      session.setAttribute("orderProjectVO", orderProjectVO);
    }
    return "confirm_return";
  }
}
