package cn.chenbonian.crowdfunding.handler;

import cn.chenbonian.crowdfunding.entity.vo.AddressVO;
import cn.chenbonian.crowdfunding.entity.vo.OrderProjectVO;
import cn.chenbonian.crowdfunding.entity.vo.OrderVO;
import cn.chenbonian.crowdfunding.service.api.OrderService;
import cn.chenbonian.crowdfunding.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderProviderHandler {

  @Autowired private OrderService orderService;

  @RequestMapping("/save/order/remote")
  ResultEntity<String> saveOrderRemote(@RequestBody OrderVO orderVO) {

    try {
      orderService.saveOrder(orderVO);
      return ResultEntity.successWithoutData();
    } catch (Exception e) {
      e.printStackTrace();
      return ResultEntity.failed(e.getMessage());
    }
  }

  @RequestMapping("/save/address/remote")
  public ResultEntity<String> saveAddressRemote(@RequestBody AddressVO addressVO) {
    try {
      orderService.saveAddress(addressVO);
      return ResultEntity.successWithoutData();
    } catch (Exception e) {
      e.printStackTrace();
      return ResultEntity.failed(e.getMessage());
    }
  }

  @RequestMapping("/get/address/vo/remote")
  ResultEntity<List<AddressVO>> getAddressVORemote(@RequestParam("memberId") Integer memberId) {

    try {
      List<AddressVO> addressVOList = orderService.getAddressVOList(memberId);
      return ResultEntity.successWithData(addressVOList);
    } catch (Exception e) {
      e.printStackTrace();
      return ResultEntity.failed(e.getMessage());
    }
  }

  @RequestMapping("/get/order/project/vo/remote")
  ResultEntity<OrderProjectVO> getOrderProjectVORemote(
      @RequestParam("projectId") Integer projectId, @RequestParam("returnId") Integer returnId) {
    try {
      OrderProjectVO orderProjectVO = orderService.getOrderProjectVO(projectId, returnId);
      return ResultEntity.successWithData(orderProjectVO);
    } catch (Exception e) {
      e.printStackTrace();
      return ResultEntity.failed(e.getMessage());
    }
  }
}
