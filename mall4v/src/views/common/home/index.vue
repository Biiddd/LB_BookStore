<template>
  <div class='echarts-box'>
    <div
      id='myEcharts'
      :style='{ width: "1280px", height: "500px" }' />
  </div>
  <div class='echarts-box'>
  <div
    id='alert'
    :style='{ width: "1280px", height: "500px" }' />
  </div>
  <el-card>
    <div class="inventory-card">
      <h2 style="text-align: center">库存预警</h2>
      <table id="inventory-table">
        <tr>
          <th style="text-align: center">图书名称</th>
          <th style="text-align: center">库存余量</th>
        </tr>
        <tr>
          <td style="text-align: center">Book A</td>
          <td class="low-stock" style="text-align: center">56</td>
        </tr>
      </table>
    </div>
  </el-card>
  </template>

<style>
/* 样式化卡片 */
.inventory-card {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 20px;
  width: 1280px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  margin: 20px;
}
table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 10px;
}
th, td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}
.low-stock {
  color: red;
  font-weight: bold;
}
</style>

<script>
import * as echarts from 'echarts'
import { onMounted, onUnmounted } from 'vue'

export default {
  name: 'App',
  props: ['width', 'height'],
  setup () {
    const myEcharts = echarts

    onMounted(() => {
      initChart()
    })

    // onUnmounted(() => {
    //   myEcharts.dispose
    // })

    function initChart () {
      const chart = myEcharts.init(document.getElementById('myEcharts'), 'purple-passion')
      chart.setOption({
        title: {
          text: '2023年各月份销售量（单位：件）',
          left: 'center'
        },
        xAxis: {
          type: 'category',
          data: [
            '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'
          ]
        },
        tooltip: {
          trigger: 'axis'
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            data: [
              606, 542, 985, 687, 501, 787, 339, 706, 383, 684, 669, 737
            ],
            type: 'line',
            smooth: true,
            itemStyle: {
              normal: {
                label: {
                  show: true,
                  position: 'top',
                  formatter: '{c}'
                }
              }
            }
          }
        ]
      })
      const chart2 = myEcharts.init(document.getElementById('alert'), 'purple-passion')
      chart2.setOption({
        title: {
          text: '本月畅销书本',
          left: 'center'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          top: '5%',
          left: 'center'
        },
        series: [
          {
            name: '畅销榜',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: 40,
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false
            },
            data: [
              { value: bestsell1value, name: bestsell1 },
              { value: bestsell2value, name: bestsell2 },
              { value: bestsell3value, name: bestsell3 },
              { value: bestsell4value, name: bestsell4 },
              { value: bestsell5value, name: bestsell5 }
            ]
          }
        ]
      })
      window.onresize = function () {
        chart.resize()
        chart2.resize()
      }
    }

    return {
      initChart
    }
  }
}

// // 初始化 Book A 的库存值
// let bookAStock = 56
//
// // 更新页面显示的库存值
// function updateBookInventory () {
//   const bookAStockElement = document.getElementById('bookAStock')
//   bookAStockElement.textContent = bookAStock
// }
//
// // 监听键盘按下事件
// document.addEventListener('keydown', function (event) {
//   if (event.key === '-') {
//     if (bookAStock > 0) {
//       bookAStock-- // 减少 Book A 的库存值
//       updateBookInventory() // 更新页面显示的库存值
//     }
//   }
// })
//
// // 页面加载时更新显示的库存值
// window.onload = function () {
//   updateBookInventory()
// }

const bestsell1 = '骆驼祥子'
const bestsell1value = 1048
const bestsell2 = '三体'
const bestsell2value = 735
const bestsell3 = '活着'
const bestsell3value = 580
const bestsell4 = '围城'
const bestsell4value = 484
const bestsell5 = '百年孤独'
const bestsell5value = 300

</script>
<!--<template>-->
<!--  <div class="mod-home">-->
<!--    <p>一个基于spring boot、spring oauth2.0、mybatis、redis的轻量级、前后端分离、拥有完整sku和下单流程的完全开源商城</p>-->
<!--    <p>&nbsp;</p>-->
<!--    <p>该项目仅供学习参考、可供个人学习使用、如需商用联系作者进行授权，否则必将追究法律责任</p>-->
<!--    <p>&nbsp;</p>-->
<!--    <h2>前言</h2>-->
<!--    <p>-->
<!--      <code>mall4j商城</code>项目致力于为中小企业打造一个完整、易于维护的开源的电商系统，采用现阶段流行技术实现。后台管理系统包含商品管理、订单管理、运费模板、规格管理、会员管理、运营管理、内容管理、统计报表、权限管理、设置等模块。-->
<!--    </p>-->
<!--    <p>&nbsp;</p>-->
<!--    <h2>技术选型</h2>-->
<!--    <figure>-->
<!--      <table-->
<!--        border="1"-->
<!--        cellspacing="0"-->
<!--        cellpadding="5px"-->
<!--      >-->
<!--        <thead>-->
<!--        <tr>-->
<!--          <th>技术</th>-->
<!--          <th>版本</th>-->
<!--          <th>说明</th>-->
<!--        </tr>-->
<!--        </thead>-->
<!--        <tbody>-->
<!--        <tr>-->
<!--          <td>Spring Boot</td>-->
<!--          <td>3.0.4</td>-->
<!--          <td>MVC核心框架</td>-->
<!--        </tr>-->
<!--        <tr>-->
<!--          <td>MyBatis</td>-->
<!--          <td>3.5.0</td>-->
<!--          <td>ORM框架</td>-->
<!--        </tr>-->
<!--        <tr>-->
<!--          <td>MyBatisPlus</td>-->
<!--          <td>3.5.3.1</td>-->
<!--          <td>基于mybatis，使用lambda表达式的</td>-->
<!--        </tr>-->
<!--        <tr>-->
<!--          <td>Swagger-UI</td>-->
<!--          <td>4.0.0</td>-->
<!--          <td>文档生产工具</td>-->
<!--        </tr>-->
<!--        <tr>-->
<!--          <td>redisson</td>-->
<!--          <td>3.19.3</td>-->
<!--          <td>对redis进行封装、集成分布式锁等</td>-->
<!--        </tr>-->
<!--        <tr>-->
<!--          <td>hikari</td>-->
<!--          <td>3.2.0</td>-->
<!--          <td>数据库连接池</td>-->
<!--        </tr>-->
<!--        <tr>-->
<!--          <td>log4j2</td>-->
<!--          <td>2.17.2</td>-->
<!--          <td>更快的log日志工具</td>-->
<!--        </tr>-->
<!--        <tr>-->
<!--          <td>lombok</td>-->
<!--          <td>1.18.8</td>-->
<!--          <td>简化对象封装工具</td>-->
<!--        </tr>-->
<!--        <tr>-->
<!--          <td>hutool</td>-->
<!--          <td>5.8.15</td>-->
<!--          <td>更适合国人的java工具集</td>-->
<!--        </tr>-->
<!--        <tr>-->
<!--          <td>xxl-job</td>-->
<!--          <td>2.3.1</td>-->
<!--          <td>定时任务</td>-->
<!--        </tr>-->
<!--        </tbody>-->
<!--      </table>-->
<!--    </figure>-->
<!--    <p>&nbsp;</p>-->
<!--    <h2>部署教程</h2>-->
<!--    <p>&nbsp;</p>-->
<!--    <h3>1.开发环境</h3>-->
<!--    <figure>-->
<!--      <table-->
<!--        border="1"-->
<!--        cellspacing="0"-->
<!--        cellpadding="5px"-->
<!--      >-->
<!--        <thead>-->
<!--        <tr>-->
<!--          <th>工具</th>-->
<!--          <th>版本</th>-->
<!--        </tr>-->
<!--        </thead>-->
<!--        <tbody>-->
<!--        <tr>-->
<!--          <td>jdk</td>-->
<!--          <td>17</td>-->
<!--        </tr>-->
<!--        <tr>-->
<!--          <td>mysql</td>-->
<!--          <td>5.7+</td>-->
<!--        </tr>-->
<!--        <tr>-->
<!--          <td>redis</td>-->
<!--          <td>3.2+</td>-->
<!--        </tr>-->
<!--        </tbody>-->
<!--      </table>-->
<!--    </figure>-->
<!--    <h3>2.启动</h3>-->
<!--    <ul>-->
<!--      <li>推荐使用idea，安装lombok插件，使用idea导入maven项目</li>-->
<!--      <li>-->
<!--        将shop.sql导入到mysql中，修改-->
<!--        <code>application-dev.yml</code>更改 datasource.url、user、password-->
<!--      </li>-->
<!--      <li>启动redis</li>-->
<!--      <li>-->
<!--        通过-->
<!--        <code>WebApplication</code>启动项目后台接口，-->
<!--        <code>ApiApplication</code> 启动项目前端接口-->
<!--      </li>-->
<!--    </ul>-->
<!--    <p>&nbsp;</p>-->
<!--  </div>-->
<!--</template>-->

<!--<style lang="scss" scoped>-->
<!--.mod-home {-->
<!--  line-height: 1.5;-->
<!--}-->
<!--</style>-->
