package cn.chenbonian.crowdfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

  /** 主键 */
  private Integer id;

  /** 父节点id */
  private Integer pid;

  /** 节点名称 */
  private String name;

  /** 节点附带的URL地址，是将来点击菜单项时要跳转的地址 */
  private String url;

  /** 节点图标的样式 */
  private String icon;

  /** 存储子节点的集合，初始化是为了避免空指针异常 */
  private List<Menu> children = new ArrayList<>();

  /** 控制节点是否默认为打开状态，设置为true表示默认打开 */
  private Boolean open = true;
}
