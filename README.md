## 目标
搭建本地服务端，通过postman发送数字，将数字存在本地数据库，并返回数字*2的结果，并将结果记录到数据库中

## 使用到的
1. springboot
2. mybatis 
3. druid
4. mysql
5. redis缓存

## 流程
1. 定义接口 /multiple?number&ratio
其中number是必须的，ratio可选，如果没有ratio，则默认为DEFAULT_RATIO = 2。
2. number和ratio定义为BigDecimal类型。
3. 对结果进行了统一封装 { "code": 200, "msg": "success", "data": 4 }。
4. 对异常进行了全局捕获。
5. mysql中，使用 number 和 ratio 作为联合主键。由于参数类型限制，无须做防sql注入
6. redis中，number-ratio为key，result为value，ttl为2分钟。
