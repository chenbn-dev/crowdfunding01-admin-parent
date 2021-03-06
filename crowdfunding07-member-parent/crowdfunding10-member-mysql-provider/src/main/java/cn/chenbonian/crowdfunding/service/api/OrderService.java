package cn.chenbonian.crowdfunding.service.api;

import cn.chenbonian.crowdfunding.entity.vo.AddressVO;
import cn.chenbonian.crowdfunding.entity.vo.OrderProjectVO;
import cn.chenbonian.crowdfunding.entity.vo.OrderVO;

import java.util.List;

public interface OrderService {

  OrderProjectVO getOrderProjectVO(Integer projectId, Integer returnId);

  List<AddressVO> getAddressVOList(Integer memberId);

  void saveAddress(AddressVO addressVO);

  void saveOrder(OrderVO orderVO);
}
