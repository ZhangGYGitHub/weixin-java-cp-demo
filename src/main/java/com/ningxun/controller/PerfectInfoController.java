package com.ningxun.controller;

import com.ningxun.config.WxCpConfiguration;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.Gender;
import me.chanjar.weixin.cp.bean.WxCpOauth2UserInfo;
import me.chanjar.weixin.cp.bean.WxCpUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Classname PerfectInfo
 * @Author ZhangGY
 * @Date 2019/8/15 18:14
 **/
@Controller
public class PerfectInfoController {
    private Integer agentId  = 1000007;
    private WxCpUser user;
    @RequestMapping("/perfect_info")
    public String perfectInfo(String code, Model model) throws WxErrorException {
        WxCpService wxCpService = WxCpConfiguration.getCpService(agentId);
        WxCpOauth2UserInfo userInfo = wxCpService.getOauth2Service().getUserInfo(code);
        String userId = userInfo.getUserId();
        user = wxCpService.getUserService().getById(userId);
        System.out.println(user);
        model.addAttribute("user",user);
        return "perfect_info";
    }

    @RequestMapping("/update")
    public String update(Integer gender,String workAddr,Model model) throws WxErrorException {
        if (gender == 1){
            user.setGender(Gender.MALE);
        }else if (gender == 2){
            user.setGender(Gender.FEMALE);
        }
        WxCpService wxCpService = WxCpConfiguration.getCpService(1000067);
        List<WxCpUser.Attr> extAttrs = user.getExtAttrs();
        extAttrs.get(0).setValue(workAddr);
        wxCpService.getUserService().update(user);
        model.addAttribute("user",user);
        return "perfect_info";
    }
}
