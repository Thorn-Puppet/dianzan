package com.zan.contrller;

import com.zan.cache.RedisHandler;
import com.zan.vo.JsonResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ZanContrller {

    @Resource
    private RedisHandler redisHandler;

    /**
     * ajax访问当前方法
     * @param goodsId
     * @return 只能是json字符串
     */
    @RequestMapping("dianzan")
    @ResponseBody
    public JsonResultVO dianzan(Integer goodsId){
        JsonResultVO jsonResultVO = new JsonResultVO();
        //设计key的格式
        //项目名称-功能名称-用户di-商品id
        String key = "pjname-zan-" + 1 +"-"+goodsId;
        //不能直接返回json字符串,所以要封装到一个类中
        try {
            redisHandler.setString(key,"1");
            //将赞写入redis
            jsonResultVO.setCode(0);
            jsonResultVO.setMsg("success");
        } catch (Exception e) {
            e.printStackTrace();
            jsonResultVO.setCode(1);
            jsonResultVO.setMsg("fail");
        }
        return jsonResultVO;
    }
}
